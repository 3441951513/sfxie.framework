package com.sfxie.extension.aliyun.oss.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.vankeservice.common.DateHelper;
import com.vankeservice.common.fileupload.ContentTypeJudge;
import com.vankeservice.common.fileupload.FileUploadStatus;
import com.vankeservice.common.fileupload.FileUtils;
import com.vankeservice.common.fileupload.PostObjectPolicy;

@RestController
@RequestMapping("/ossFileUpload")
public class OssFileUploadController {
	
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody FileUploadStatus upload(@RequestParam(value = "upload", required = false) MultipartFile upload, 
			HttpServletRequest request, ModelMap model) {
 
		String fileRootPath = getContextPath(request);
//    	request.setCharacterEncoding("UTF-8"); 
    	HttpSession session = request.getSession();
    	String fileTimeTag = request.getParameter("fileTimeTag");
    	String validations = request.getParameter("validations");
    	String filepath = request.getParameter("filepath");
    	String maxLength = request.getParameter("maxLength");
    	session.setAttribute(fileTimeTag,new FileUploadStatus());
    	try{
    		String fileType = ContentTypeJudge.getFileByFile(upload.getInputStream());
    		String fileName1 = upload.getOriginalFilename(); 
    		String fileSuffi = getFileSuffi(fileName1);
    		if(null == fileType && !validations.equals("*") && !validations.contains(fileSuffi.toLowerCase()) ){
    			if(!validations.contains(fileSuffi.toLowerCase())){
    				((FileUploadStatus) session.getAttribute(fileTimeTag)).setState("3");
    			}
    		}else if(null != fileType && !validations.equals("*") && !validations.contains(fileType.toLowerCase())){
    			((FileUploadStatus) session.getAttribute(fileTimeTag)).setState("3");
    		}else{
    			//检查输入请求是否为multipart表单数据。     
    			if (FileUpload.isMultipartContent(request)) {  
    				if (null != upload) {
    					
    					//存放该类文件的根目录绝对路径
    					//上传后文件名称
    					String fileName =  System.currentTimeMillis() + "." + getFileSuffi(fileName1);
    					String savePath =  getSavePath();
    					String yearFolderPath = DateHelper.getYear();
    					String monthFolderPath = DateHelper.getMonth();
    					String dateFolderPath = DateHelper.getDay();
    					String dbSavePath = savePath+ "/" +filepath+ "/" +yearFolderPath+ "/" +monthFolderPath+ "/" +dateFolderPath+ "/" + fileName;
    					uploadFile(session,fileTimeTag,upload,dbSavePath);
    				}
    			}
    		}
    	}catch(Exception e){
    		setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
    		e.printStackTrace();
//    		logger.error("upload error:"+e.getMessage());
    	}
		return (FileUploadStatus) session.getAttribute(fileTimeTag);
 
	}
	

	@RequestMapping(value="/status", method = RequestMethod.GET)
	public @ResponseBody FileUploadStatus status(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession  session  = request.getSession();
		String fileTimeTag = request.getParameter("fileTimeTag");
		FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);
		if(null!=uploadStatus && uploadStatus.getState().equals("2")){
			session.removeAttribute(fileTimeTag);
		}
		return uploadStatus;
    }
	/**
	 * 
	 * xsf
	 * 2015年5月6日下午5:21:22
	 * TODO	删除文件
	 * void
	 */
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> delete(HttpServletRequest request) throws Exception{
//		String fileRootPath = getContextPath(request);
//		String dbSavePath = request.getParameter("dbSavePath");
		String fileTimeTag = request.getParameter("fileTimeTag");
//		FileUtils.delFile(fileRootPath+dbSavePath.replaceFirst("/", ""));
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("fileTimeTag", fileTimeTag);
		return result;
	}
	private static void setFileStatus(HttpSession session,long readedBytes,long totalBytes,String fileTimeTag,String dbSavePath){
		FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
    	uploadStatus.setReadedBytes(uploadStatus.getReadedBytes()+readedBytes);
    	uploadStatus.setTotalBytes(totalBytes);
    	uploadStatus.setDbSavePath(dbSavePath);
    }
	
	private String getContextPath(HttpServletRequest request){
//		String path = request.getServletContext().getRealPath("/");
//		return path;
		return "";
	}
	/** 
     *  
     * 错误信息的处理 
     *  
     * @param request 
     * @param error: 1-错误;0-正常;2-上传完成 ,3-文件验证出错
     * @param message 
     */  
    private static void setStatusMsg(HttpSession session, String state, String message,String fileTimeTag) {  
    	FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
        uploadStatus.setState(state);  
        uploadStatus.setStatusMsg(message);  
    }  
	private String getSavePath() {
		return "uploadfile";
	}
	/**
     * 根据文件类型 返回相应的文件后缀
     *
     * @param uploadFileName 文件类型
     * @return 文件名后缀
     */
	private String getFileSuffi(String uploadFileName) {
        String arr[]=uploadFileName.split("\\.");
        String suffix=arr[arr.length-1];
        return suffix;
    }
	private  void makeTodayDir(File year ,File month, File date) { 
    	if(null!=year && !year.exists()){
    		year.mkdir();  
    	}
    	if(null!=month && !month.exists()){
    		month.mkdir();  
    	}
    	if(null!=date && !date.exists()){
    		date.mkdir();  
    	}
    }  
	
	private static void uploadFile(HttpSession session,String fileTimeTag,MultipartFile upload,String path) {
		String endpoint = "oss-cn-shenzhen.aliyuncs.com";

		String accessKeyId = "p7Cs5zrHIoTWsvYW";
		String accessKeySecret = "9qjRWRQhxoIWpBVz5C0iwzLjVa5rYX";
		String bucketName = "wycrm";

//		String key = "decoratioin/object-get-progress-sample.jpg";

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//		
		try {
//			File fh = new File("C:\\Users\\xiesf\\Desktop\\index.jpg");
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType("image/jpeg");
			// 带进度条的上传
			client.putObject(new PutObjectRequest(bucketName, path, upload.getInputStream(), meta).
					<PutObjectRequest> withProgressListener(new PutObjectProgressListener(session,fileTimeTag,upload.getSize(),path)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
     * 获取oss上传进度回调
     *
     */
    static class PutObjectProgressListener implements ProgressListener {

    	public PutObjectProgressListener(HttpSession session,String fileTimeTag,long totalBytes ,String dbSavePath){
    		this.session = session;
    		this.fileTimeTag = fileTimeTag;
    		this.totalBytes = totalBytes;
    		this.dbSavePath = dbSavePath;
    	}
    	
    	private HttpSession session ;
    	private String fileTimeTag;
    	private String dbSavePath;
    	
        private long bytesWritten = 0;
        private long totalBytes = -1;
        private boolean succeed = false;
        
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            long bytes = progressEvent.getBytes();
            ProgressEventType eventType = progressEvent.getEventType();
            switch (eventType) {
            case TRANSFER_STARTED_EVENT:
//                System.out.println("Start to upload......");
                break;
            
            case REQUEST_CONTENT_LENGTH_EVENT:
//                this.totalBytes = bytes;
//                System.out.println(this.totalBytes + " bytes in total will be uploaded to OSS");
                break;
            
            case REQUEST_BYTE_TRANSFER_EVENT:
                this.bytesWritten += bytes;
                if (this.totalBytes != -1) {
//                    int percent = (int)(this.bytesWritten * 100.0 / this.totalBytes);
//                    System.out.println(bytes + " bytes have been written at this time, upload progress: " +
//                            percent + "%(" + this.bytesWritten + "/" + this.totalBytes + ")");
                    setFileStatus(session,bytesWritten,totalBytes, fileTimeTag,"/"+dbSavePath);
                } else {
//                    System.out.println(bytes + " bytes have been written at this time, upload ratio: unknown" +
//                            "(" + this.bytesWritten + "/...)");
                	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
                }
                break;
                
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                setStatusMsg(session, "2", "文件上传成功！",fileTimeTag); 
//                System.out.println("Succeed to upload, " + this.bytesWritten + " bytes have been transferred in total");
                break;
                
            case TRANSFER_FAILED_EVENT:
            	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
//                System.out.println("Failed to upload, " + this.bytesWritten + " bytes have been transferred");
                break;
                
            default:
            	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
                break;
            }
        }

        public boolean isSucceed() {
            return succeed;
        }
    }
	
	/**
     * 用于oss获取下载进度回调
     *
     */
    /*static class GetObjectProgressListener implements ProgressListener {
        
        private long bytesRead = 0;
        private long totalBytes = -1;
        private boolean succeed = false;
        
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            long bytes = progressEvent.getBytes();
            ProgressEventType eventType = progressEvent.getEventType();
            switch (eventType) {
            case TRANSFER_STARTED_EVENT:
                System.out.println("Start to download......");
                break;
            
            case RESPONSE_CONTENT_LENGTH_EVENT:
                this.totalBytes = bytes;
                System.out.println(this.totalBytes + " bytes in total will be downloaded to a local file");
                break;
            
            case RESPONSE_BYTE_TRANSFER_EVENT:
                this.bytesRead += bytes;
                if (this.totalBytes != -1) {
                    int percent = (int)(this.bytesRead * 100.0 / this.totalBytes);
                    System.out.println(bytes + " bytes have been read at this time, download progress: " +
                            percent + "%(" + this.bytesRead + "/" + this.totalBytes + ")");
                } else {
                    System.out.println(bytes + " bytes have been read at this time, download ratio: unknown" +
                            "(" + this.bytesRead + "/...)");
                }
                break;
                
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                System.out.println("Succeed to download, " + this.bytesRead + " bytes have been transferred in total");
                break;
                
            case TRANSFER_FAILED_EVENT:
                System.out.println("Failed to download, " + this.bytesRead + " bytes have been transferred");
                break;
                
            default:
                break;
            }
        }
        
        public boolean isSucceed() {
            return succeed;
        }
    }*/
}
