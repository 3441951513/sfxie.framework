package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.notify.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="xml")
public class WxNotifyResponse {
	
	private String return_code;
	private String return_msg;
	
	@XmlElement
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	@XmlElement
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
	
}
