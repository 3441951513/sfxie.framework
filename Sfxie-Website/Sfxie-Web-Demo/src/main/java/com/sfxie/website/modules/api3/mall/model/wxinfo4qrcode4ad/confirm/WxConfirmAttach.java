package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.confirm;

import javax.xml.bind.annotation.XmlAttribute;

public class WxConfirmAttach {

	private String notifyUrl;

	@XmlAttribute
	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
	
}
