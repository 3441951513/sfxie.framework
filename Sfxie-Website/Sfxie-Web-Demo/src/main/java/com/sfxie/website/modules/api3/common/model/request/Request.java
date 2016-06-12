package com.sfxie.website.modules.api3.common.model.request;

import javax.xml.bind.annotation.XmlAttribute;


public class Request {
	/**	请求参数	*/
//    protected Parameter parameter;
    /**	接口地址 	*/
    protected String website;
    /**	协议版本	*/
    protected String proVersion;
    /**	app版本	*/
    protected String appVersion;

    @XmlAttribute(required = true)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String value) {
        this.website = value;
    }
    @XmlAttribute(name = "pro_version", required = true)
    public String getProVersion() {
        return proVersion;
    }

    public void setProVersion(String value) {
        this.proVersion = value;
    }

    @XmlAttribute(name = "app_version", required = true)
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String value) {
        this.appVersion = value;
    }

   /* @XmlElement
	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}*/
    
    

}
