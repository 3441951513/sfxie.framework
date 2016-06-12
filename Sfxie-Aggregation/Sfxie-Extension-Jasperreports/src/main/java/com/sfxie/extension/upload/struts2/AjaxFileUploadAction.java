package com.sfxie.extension.upload.struts2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.apache.struts2.ServletActionContext;

import com.sfxie.extension.upload.struts2.IAjaxUploadFileDealer;
import com.sfxie.utils.FileUtils;

/**
 * ajax文件上传
 * @author xieshengfeng
 * @since 2015-05-04
 *
 */
public class AjaxFileUploadAction {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6465508254828060392L;
	
	/**
     * 封装上传文件域的属性
     */
    private File upload;
    /**
     * 封装上传文件名的属性
     * struts自动封装
     * 页面不需要相关的域
     */
    private String uploadFileName;
    /**
     * 文件验证集合
     */
    private String validations;
    /**
     * 上传成功后的文件路径
     */
    private String dbSavePath;
    /**
     * 从前端传过来的自定义文件上传路径,这个路径会加在配置文件uploadFilePath属性的后面
     */
    private String filepath;
    
    /**
     * 文件上传状态对象
     */
    private FileUploadStatus uploadStatus;
    /**
     * 文件标记,从前端传过来的参数
     */
    private String fileTimeTag;
    /**
     * 文件上传类型:multy-多文件上传,single-单文件上传
     */
    private String type;
    /** ajax上传文件的处理类 */
	private String dealer;
	
	private Object result;

    /**
     * xsf
     * 2015年5月6日下午5:20:38
     * TODO 上传文件
     * void
     */
    @SuppressWarnings("deprecation")
	public void upload() throws Exception {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.setCharacterEncoding("UTF-8"); 
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	session.setAttribute(fileTimeTag,new FileUploadStatus());
    	try{
    		String fileType = ContentTypeJudge.getFileByFile(upload);
    		String fileSuffi = Tool.getFileSuffi(getUploadFileName());
    		if(null == fileType && !validations.equals("*") && !validations.contains(fileSuffi.toLowerCase()) ){
    			if(!validations.contains(fileSuffi.toLowerCase())){
    				((FileUploadStatus) session.getAttribute(fileTimeTag)).setState("3");
    			}
    		}else if(null != fileType && !validations.equals("*") && !validations.contains(fileType.toLowerCase())){
    			((FileUploadStatus) session.getAttribute(fileTimeTag)).setState("3");
    		}else{
    			//检查输入请求是否为multipart表单数据。     
    			boolean isMultipart= FileUpload.isMultipartContent(request);     
    			if (isMultipart) {  
    				if (null != upload) {
    					//存放该类文件的根目录绝对路径
    					Object value = SpringPropertyPlaceholderConfigurer.getContextProperty("uploadFilePath");
    					String realPath  = value.toString();
    					String path = realPath.substring(0, realPath.lastIndexOf(File.separator))+getSavePath();
    					//上传后文件名称
    					String fileName =  System.currentTimeMillis() + "." + Tool.getFileSuffi(getUploadFileName());
    					String savePath =  SpringPropertyPlaceholderConfigurer.getContextProperty("dbSavePath").toString();
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
    					InputStream is = new FileInputStream(upload);    
    					Long total = upload.length();
    					byte buf[] = new byte[2048];//可以修改 1024 以提高读取速度  
    					int length = 0;    
    					while( (length = is.read(buf)) > 0 ){
    						setFileStatus(session,length,total.intValue());
    						os.write(buf, 0, length);    
//                        Thread.sleep(20);
    					}    
    					//关闭流    
    					os.flush();  
    					os.close();    
    					is.close();
    				}
    			}
    			setStatusMsg(session, "2", "文件上传成功！"); 
    		}
    	}catch(Exception e){
    		setStatusMsg(session,"1","上传文件失败。");
    		logger.error("upload error:"+e.getMessage());
    	}
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
    public String ajaxUploadPage(){
    	return SUCCESS;
    }
	public void status() throws Exception {
		HttpSession  session  = ServletActionContext.getRequest().getSession();
		FileUploadStatus uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);
		String fileUploadStatus = "" ;
		fileUploadStatus = JsonUtils.toJson(uploadStatus);
		if(null!=uploadStatus && uploadStatus.getState().equals("2")){
			session.removeAttribute(fileTimeTag);
		}
    	write(fileUploadStatus);
    }
	
	/** 获取上传文件 */
	public String ajaxUploadFile() throws Exception {
		try {
			// 载货单前缀在config.properties配置文件中的mnfPrefix配置
			String reg = (String) SpringPropertyPlaceholderConfigurer.getContextProperty(dealer);
			Class<?> cls;
			cls = Class.forName(reg);
			IAjaxUploadFileDealer ajaxUploadFileDealer = (IAjaxUploadFileDealer) cls
					.newInstance();
			if(ajaxUploadFileDealer.supports(this, upload)){
				ajaxUploadFileDealer.deal(this, upload);
			}
			return "json";
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * xsf
	 * 2015年5月6日下午5:21:22
	 * TODO	删除文件
	 * void
	 */
	public void delete() throws Exception{
		String uploadFilePath = (String) SpringPropertyPlaceholderConfigurer.getContextProperty("uploadFilePath");
		System.out.println(uploadFilePath+dbSavePath.replaceFirst("/", ""));
		FileUtils.delFile(uploadFilePath+dbSavePath.replaceFirst("/", ""));
		write("{\"success\":true,\"fileTimeTag\":"+fileTimeTag+"}");
	}
	
	
    private void write(String fileUploadStatus) throws IOException{
    	this.getResponse().setCharacterEncoding("UTF-8");
		// 设置页面不缓存  
		this.getResponse().setHeader("Cache-Control", "no-cache");  
		this.getResponse().setHeader("Cache-Control", "no-store");  
		this.getResponse().setHeader("Pragma", "no-cache");  
		this.getResponse().setDateHeader("Expires", 0);  
		this.getResponse().getWriter().write(fileUploadStatus);
    }
    
    private void setFileStatus(HttpSession session,int readedBytes,int totalBytes){
    	uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
    	uploadStatus.setReadedBytes(uploadStatus.getReadedBytes()+readedBytes);
    	uploadStatus.setTotalBytes(totalBytes);
    }
    /** 
     *  
     * 错误信息的处理 
     *  
     * @param request 
     * @param error: 1-错误;0-正常;2-上传完成 ,3-文件验证出错
     * @param message 
     */  
    private void setStatusMsg(HttpSession session, String state, String message) {  
        uploadStatus = (FileUploadStatus) session.getAttribute(fileTimeTag);  
        uploadStatus.setState(state);  
        uploadStatus.setStatusMsg(message);  
    }  

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return (String) SpringPropertyPlaceholderConfigurer.getContextProperty("dbSavePath");
	}

	public String getDbSavePath() {
		return dbSavePath;
	}

	public void setDbSavePath(String dbSavePath) {
		this.dbSavePath = dbSavePath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFileTimeTag() {
		return fileTimeTag;
	}
	public void setFileTimeTag(String fileTimeTag) {
		this.fileTimeTag = fileTimeTag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValidations() {
		return validations;
	}
	public void setValidations(String validations) {
		this.validations = validations;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	
}
