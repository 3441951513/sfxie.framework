package com.sfxie.extension.upload.struts2;

/** 
 * 上传状态类 
 * @author xieshengfeng
 * @since 2015-05-04
 */  
public class FileUploadStatus {  
       
    private String statusMsg = "";  
    /** 已经读取的字节数  */
    private long readedBytes = 0L;  
    /** 文件总字节数  */
    private long totalBytes = 0L;  
    private int currentItem = 0;  
    // 1 ： 错误  0 ： 正常  2:完成  ,3:文件验证错误,4-已经上传
    private String state = "0";  
    
    /**
     * 上传成功后的文件路径
     */
    private String dbSavePath;
      
    public String getStatusMsg() {  
        return statusMsg;  
    }  
  
    public void setStatusMsg(String statusMsg) {  
        this.statusMsg = statusMsg;  
    }  
  
    public long getReadedBytes() {  
        return readedBytes;  
    }  
  
    public void setReadedBytes(long readedBytes) {  
        this.readedBytes = readedBytes;  
    }  
  
    public long getTotalBytes() {  
        return totalBytes;  
    }  
  
    public void setTotalBytes(long totalBytes) {  
        this.totalBytes = totalBytes;  
    }  
  
    public int getCurrentItem() {  
        return currentItem;  
    }  
  
    public void setCurrentItem(int currentItem) {  
        this.currentItem = currentItem;  
    }  
   
  
    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String toJSon() {  
        StringBuffer strJSon = new StringBuffer();  
        strJSon.append("{");  
        strJSon.append("state:'").append(state).append("',");  
        strJSon.append("statusMsg:'").append(statusMsg).append("',");  
        strJSon.append("readedBytes:'").append(readedBytes).append("',");  
        strJSon.append("totalBytes:'").append(totalBytes).append("',");  
        strJSon.append("currentItem:'").append(currentItem).append("'");  
        strJSon.append("}");  
        return strJSon.toString();  
    }

	public String getDbSavePath() {
		return dbSavePath;
	}

	public void setDbSavePath(String dbSavePath) {
		this.dbSavePath = dbSavePath.replaceAll("\\\\", "/");
	}   
	
}  
