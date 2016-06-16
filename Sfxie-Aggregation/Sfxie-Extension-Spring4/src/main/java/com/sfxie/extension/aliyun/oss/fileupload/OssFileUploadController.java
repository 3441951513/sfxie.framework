package com.sfxie.extension.aliyun.oss.fileupload;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bingo.common.core.ApplicationContext;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.event.ProgressEvent;
import com.aliyun.oss.event.ProgressEventType;
import com.aliyun.oss.event.ProgressListener;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.vankeservice.common.DateHelper;
import com.vankeservice.common.fileupload.ContentTypeJudge;
import com.vankeservice.common.fileupload.FileUploadStatus;

@RestController
@RequestMapping("/ossFileUpload")
public class OssFileUploadController {
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public @ResponseBody FileUploadStatus upload(@RequestParam(value = "upload", required = false) MultipartFile upload, 
			HttpServletRequest request, ModelMap model) {
 
    	HttpSession session = request.getSession();
    	String fileTimeTag = request.getParameter("fileTimeTag");
    	String validations = request.getParameter("validations");
    	String filepath = request.getParameter("filepath");
    	String maxLengthStr = request.getParameter("maxLength");
    	Integer maxLength = null;
    	if(null!=maxLengthStr){
    		maxLength = Integer.parseInt(maxLengthStr);
    	}
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
    					uploadFile(session,fileTimeTag,upload,dbSavePath,maxLength);
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
		String dbSavePath = request.getParameter("dbSavePath");
		String fileTimeTag = request.getParameter("fileTimeTag");
		
		if(StringUtils.isNotEmpty(dbSavePath)){
			String bucketName = getBucketName();
			OSSClient ossClient = getOSSClient();
			if(dbSavePath.startsWith("/")){
				dbSavePath = dbSavePath.replaceFirst("/","");
			}
			
			if(ossClient.doesObjectExist(bucketName, dbSavePath)){
				//删除oss对象
				ossClient.deleteObject(bucketName, dbSavePath);
			}
			ossClient.shutdown();
		}
		
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
	
	private  void uploadFile(HttpSession session,String fileTimeTag,MultipartFile upload,String path,Integer maxLength) {
		String bucketName = getBucketName();
		OSSClient ossClient = getOSSClient();
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType("image/jpeg");
			//设置对象访问控制，此地设置为公有访读问权限
			meta.setObjectAcl(CannedAccessControlList.PublicRead);
			// 带进度条的上传
			ossClient.putObject(new PutObjectRequest(bucketName, path, upload.getInputStream(), meta).
					<PutObjectRequest> withProgressListener(new PutObjectProgressListener(ossClient,bucketName,session,fileTimeTag,upload.getSize(),path,maxLength)));
		} catch (Exception e) {
        	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
			e.printStackTrace();
		}finally{
			ossClient.shutdown();
		}
	}
	
	private OSSClient getOSSClient(){
		String endpoint = ApplicationContext.getProperty("oss.endpoint","oss-cn-shenzhen.aliyuncs.com");
		String accessKeyId = ApplicationContext.getProperty("oss.accessKeyId","p7Cs5zrHIoTWsvYW");
		String accessKeySecret = ApplicationContext.getProperty("oss.accessKeySecret","9qjRWRQhxoIWpBVz5C0iwzLjVa5rYX");

		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		return ossClient;
	}
	private String getBucketName(){
		return ApplicationContext.getProperty("oss.bucketName","wycrm");
	}
	/**
     * 获取oss上传进度回调
     *
     */
    static class PutObjectProgressListener implements ProgressListener {

    	public PutObjectProgressListener(OSSClient ossClient,String bucketName,HttpSession session,String fileTimeTag,long totalBytes ,String dbSavePath,int maxLength){
    		this.session = session;
    		this.fileTimeTag = fileTimeTag;
    		this.totalBytes = totalBytes;
    		this.dbSavePath = dbSavePath;
    		this.maxLength = maxLength;
    		this.ossClient = ossClient;
    		this.bucketName = bucketName;
    	}
    	
    	private OSSClient ossClient;
    	private HttpSession session ;
    	private String fileTimeTag;
    	private String dbSavePath;
    	private Integer maxLength;
    	private String bucketName;
    	
        private long bytesWritten = 0;
        private long totalBytes = -1;
        private boolean succeed = false;
        private boolean mostMaxLength = false;
        
        @Override
        public void progressChanged(ProgressEvent progressEvent) {
            long bytes = progressEvent.getBytes();
            ProgressEventType eventType = progressEvent.getEventType();
            switch (eventType) {
            //开始上传事件
            case TRANSFER_STARTED_EVENT:
                break;
            //获取文件长度事件
            case REQUEST_CONTENT_LENGTH_EVENT:
                break;
            //正在上传文件事件
            case REQUEST_BYTE_TRANSFER_EVENT:
                this.bytesWritten += bytes;
                if (this.totalBytes != -1) {
                	if(judgeMaxLength()){
                		mostMaxLength = true;
                		break;
                	}else{
                		setFileStatus(session,bytesWritten,totalBytes, fileTimeTag,"/"+dbSavePath);
                	}
                } else {
                	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
                }
                break;
            //文件上传成功事件 
            case TRANSFER_COMPLETED_EVENT:
                this.succeed = true;
                if(mostMaxLength){
                	ossClient.deleteObject(bucketName, dbSavePath);
                }else{
                	setStatusMsg(session, "2", "文件上传成功！",fileTimeTag); 
                }
                break;
            //文件上传失败事件    
            case TRANSFER_FAILED_EVENT:
            	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
                break;
            //默认动作
            default:
            	setStatusMsg(session,"1","上传文件失败。",fileTimeTag);
                break;
            }
        }

        public boolean isSucceed() {
            return succeed;
        }
        
        public boolean  judgeMaxLength(){
        	if(null!=maxLength && maxLength*1024 < totalBytes){
				setStatusMsg(session,"4","文件大小不能超过"+maxLength+"KB",fileTimeTag);
				return true;
			}
        	return false;
        }
    }
	
}
