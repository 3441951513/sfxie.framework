package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "request")
public class AlipayInfo4Qrcode4AdRequest {

	private AlipayInfo4Qrcode4AdParameter parameter;
	
	private String language;
	
	private String region;

	@XmlElement(name="parameter")
	public AlipayInfo4Qrcode4AdParameter getParameter() {
		return parameter;
	}

	public void setParameter(AlipayInfo4Qrcode4AdParameter parameter) {
		this.parameter = parameter;
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
