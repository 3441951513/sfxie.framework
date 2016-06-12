package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.confirm;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.request.WxInfo4Qrcode4AdClient;

public class WxConfirmData {

	private String language;
	
	private String region;
	
	private WxInfo4Qrcode4AdClient client;
	
	private WxConfirmOrder order;
	
	private WxConfirmAttach attach;


	
	
	@XmlElement(name="client")
	public WxInfo4Qrcode4AdClient getClient() {
		return client;
	}

	public void setClient(WxInfo4Qrcode4AdClient client) {
		this.client = client;
	}
	@XmlElement(name="order")
	public WxConfirmOrder getOrder() {
		return order;
	}

	public void setOrder(WxConfirmOrder order) {
		this.order = order;
	}
	@XmlElement(name="attach")
	public WxConfirmAttach getAttach() {
		return attach;
	}

	public void setAttach(WxConfirmAttach attach) {
		this.attach = attach;
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
