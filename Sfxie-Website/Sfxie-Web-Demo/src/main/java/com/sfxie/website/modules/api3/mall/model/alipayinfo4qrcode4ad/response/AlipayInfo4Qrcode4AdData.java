package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.response;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class AlipayInfo4Qrcode4AdData {
	
	private String language;
	private String region;
	
	private AlipayInfo4Qrcode4AdAttach attach;
	
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
	
	@XmlElement(name="attach")
	public AlipayInfo4Qrcode4AdAttach getAttach() {
		return attach;
	}
	public void setAttach(AlipayInfo4Qrcode4AdAttach attach) {
		this.attach = attach;
	}
	
}
