package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;


public class WxInfo4Qrcode4AdUser {

	private String id;
	
	private String type;
	
	private String token;
	
	private String name;
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlAttribute
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
