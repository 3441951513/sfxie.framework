package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;


public class WxInfo4Qrcode4AdRequestData{

	private String serial;
	

	@XmlAttribute
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

}
