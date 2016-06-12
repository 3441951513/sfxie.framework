package com.sfxie.extension.jasperreport6.struts2;

public class ReportDownloadStatus {

	// 1 ： 错误   0 ： 正常  2:完成  ,3:文件验证错误,4-已经上传
    private String state = "0";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}  
    
    
}
