package com.sfxie.extension.aliyun.oss.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sfxie.utils.DateHelper;


@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {
	
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
    					String realPath  = fileRootPath+File.separator;
    					String path = realPath.substring(0, realPath.lastIndexOf(File.separator))+getSavePath();
    					//上传后文件名称
    					String fileName =  System.currentTimeMillis() + "." + getFileSuffi(fileName1);
    					String savePath =  getSavePath();
    					String dbSavePath ;
    					//上传后的文件绝对路径
    					String realSavePath = "";
    					String yearFolderPath = DateHelper.getYear();
    					String monthFolderPath = DateHelper.getMonth();
    					String dateFolderPath = DateHelper.getDay();
    					
    					if(null != filepath && !"".equals(filepath)){
    						makeTodayDir(new File(path + File.separator +filepath),null,null);
    						makeTodayDir(new File(path + File.separator +filepath+File.separator+yearFolderPath),
    									 new File(path + File.separator +filepath+File.separator+yearFolderPath+File.separator+monthFolderPath),
    									 new File(path + File.separator +filepath+File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath));
    						
    						realSavePath = path + File.separator +filepath+File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath+File.separator+fileName;
    						dbSavePath = savePath+ File.separator +filepath+File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath+File.separator+ fileName;
    					}else{
    						makeTodayDir(new File(path + File.separator +File.separator+yearFolderPath),
									 new File(path + File.separator +File.separator+yearFolderPath+File.separator+monthFolderPath),
									 new File(path + File.separator +File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath));
    						realSavePath = path + File.separator +File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath+File.separator+fileName;
    						dbSavePath = savePath+ File.separator +File.separator+yearFolderPath+File.separator+monthFolderPath+File.separator+dateFolderPath+File.separator+ fileName;
    					}
    					((FileUploadStatus) session.getAttribute(fileTimeTag)).setDbSavePath(dbSavePath);
    					//流操作 读取上传的文件内容
    					File uploadedFile = new File(realSavePath);  
    					OutputStream os = new FileOutputStream(uploadedFile);    
    					InputStream is = upload.getInputStream();    
    					Long total = upload.getSize();
    					if(null!=maxLength && Integer.parseInt(maxLength)*1024 <= total){
							setStatusMsg(session,"4","文件大小不能超过"+Integer.parseInt(maxLength)+"KB",fileTimeTag);
							uploadedFile.delete();
						}else {
							byte buf[] = new byte[2048];//可以修改 1024 以提高读取速度  
							int length = 0;    
							while((length = is.read(buf)) > 0 ){
								setFileStatus(session,length,total.intValue(),fileTimeTag);
								os.write(buf, 0, length);    
//                        		Thread.sleep(20);
							}    
							setStatusMsg(session, "2", "文件上传成功！",fileTimeTag); 
						}
    					//关闭流    
    					os.flush();  
    					os.close();    
    					is.close();
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
		String fileRootPath = getContextPath(request);
		String dbSavePath = request.getParameter("dbSavePath");
		String fileTimeTag = request.getParameter("fileTimeTag");
		FileUtils.delFile(fileRootPath+dbSavePath.replaceFirst("/", ""));
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("fileTimeTag", fileTimeTag);
		return result;
	}
	private void setFileStatus(HttpSession session,int readedBytes,int totalBytes,String fileTimeTag){
		FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
    	uploadStatus.setReadedBytes(uploadStatus.getReadedBytes()+readedBytes);
    	uploadStatus.setTotalBytes(totalBytes);
    }
	
	private String getContextPath(HttpServletRequest request){
		String path = request.getServletContext().getRealPath("/");
//		String path=request.getContextPath();
		return path;
	}
	/** 
     *  
     * 错误信息的处理 
     *  
     * @param request 
     * @param error: 1-错误;0-正常;2-上传完成 ,3-文件验证出错
     * @param message 
     */  
    private void setStatusMsg(HttpSession session, String state, String message,String fileTimeTag) {  
    	FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
        uploadStatus.setState(state);  
        uploadStatus.setStatusMsg(message);  
    }  
	private String getSavePath() {
		return File.separator+"upload"+File.separator+"images";
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
 
}
