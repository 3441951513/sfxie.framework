package com.sfxie.data.xml.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Data {
	
	private String apkUri;
	
	private String upgradeMode ;

	@XmlAttribute(name = "apk_uri")
	public String getApkUri() {
		return apkUri;
	}

	public void setApkUri(String apkUri) {
		this.apkUri = apkUri;
	}

	@XmlAttribute(name = "upgrade_mode")
	public String getUpgradeMode() {
		return upgradeMode;
	}

	public void setUpgradeMode(String upgradeMode) {
		this.upgradeMode = upgradeMode;
	}
	
	
}
