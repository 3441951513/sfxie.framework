package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.response;


import javax.xml.bind.annotation.XmlAttribute;


public class AlipayInfo4Qrcode4AdAttach {
	
	private String orderinfo;
	private String url;
	
	@XmlAttribute
	public String getOrderinfo() {
		return orderinfo;
	}
	public void setOrderinfo(String orderinfo) {
		this.orderinfo = orderinfo;
	}
	@XmlAttribute
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
