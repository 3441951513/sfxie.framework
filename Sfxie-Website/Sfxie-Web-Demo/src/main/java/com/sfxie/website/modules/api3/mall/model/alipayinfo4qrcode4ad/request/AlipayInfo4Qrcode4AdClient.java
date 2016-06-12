package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;


public class AlipayInfo4Qrcode4AdClient {

	private String clienttype;
	
	private String mac;
	
	private String deviceid;
	
	private String version;
	
	private String versioncode;
	
	private String type;
	
	@XmlAttribute
	public String getClienttype() {
		return clienttype;
	}

	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}
	@XmlAttribute
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	@XmlAttribute
	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@XmlAttribute
	public String getVersioncode() {
		return versioncode;
	}

	public void setVersioncode(String versioncode) {
		this.versioncode = versioncode;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
