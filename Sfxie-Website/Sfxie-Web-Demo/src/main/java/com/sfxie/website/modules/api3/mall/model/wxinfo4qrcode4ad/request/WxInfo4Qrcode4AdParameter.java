package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class WxInfo4Qrcode4AdParameter {

	private String language;
	
	private String region;

	
	private WxInfo4Qrcode4AdRequestData data;
	
	private WxInfo4Qrcode4AdClient client;
	
	private WxInfo4Qrcode4AdUser user;

	@XmlElement(name="order")
	public WxInfo4Qrcode4AdRequestData getData() {
		return data;
	}

	public void setData(WxInfo4Qrcode4AdRequestData data) {
		this.data = data;
	}
	@XmlElement(name="client")
	public WxInfo4Qrcode4AdClient getClient() {
		return client;
	}

	public void setClient(WxInfo4Qrcode4AdClient client) {
		this.client = client;
	}
	@XmlElement(name="user")
	public WxInfo4Qrcode4AdUser getUser() {
		return user;
	}

	public void setUser(WxInfo4Qrcode4AdUser user) {
		this.user = user;
	}
	@XmlAttribute
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	@XmlAttribute
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
