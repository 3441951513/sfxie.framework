package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlElement;

public class AlipayInfo4Qrcode4AdParameter {

	private AlipayInfo4Qrcode4AdRequestData data;
	
	private AlipayInfo4Qrcode4AdClient client;
	
	private AlipayInfo4Qrcode4AdUser user;

	@XmlElement(name="data")
	public AlipayInfo4Qrcode4AdRequestData getData() {
		return data;
	}

	public void setData(AlipayInfo4Qrcode4AdRequestData data) {
		this.data = data;
	}
	@XmlElement(name="client")
	public AlipayInfo4Qrcode4AdClient getClient() {
		return client;
	}

	public void setClient(AlipayInfo4Qrcode4AdClient client) {
		this.client = client;
	}
	@XmlElement(name="user")
	public AlipayInfo4Qrcode4AdUser getUser() {
		return user;
	}

	public void setUser(AlipayInfo4Qrcode4AdUser user) {
		this.user = user;
	}
	
	
}
