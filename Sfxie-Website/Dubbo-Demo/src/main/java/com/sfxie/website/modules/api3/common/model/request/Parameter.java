package com.sfxie.website.modules.api3.common.model.request;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
public class Parameter {

	/**	设置参数	*/
    protected Device device;
    /**	用户参数	*/
    protected User user;
    /**	接口名称	*/
    protected String iname;
    /**	apk类型：1 直播+院线，2 单直播， 3 单院线， 4 独立广告apk */
    protected String apktype;
    /**	语言代码	*/
    protected String language;
    /**	地区代码	*/
    protected String region;

    @XmlElement(name="device",required = true)
    public Device getDevice() {
        return device;
    }
    public void setDevice(Device value) {
        this.device = value;
    }

    @XmlElement(name="user",required = true)
    public User getUser() {
        return user;
    }

    public void setUser(User value) {
        this.user = value;
    }

    @XmlAttribute(required = true)
    public String getIname() {
        return iname;
    }

    public void setIname(String value) {
        this.iname = value;
    }

    @XmlAttribute(required = true)
    public String getApktype() {
        return apktype;
    }

    public void setApktype(String value) {
        this.apktype = value;
    }

    @XmlAttribute(required = true)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String value) {
        this.language = value;
    }

    @XmlAttribute(required = true)
    public String getRegion() {
        return region;
    }

    public void setRegion(String value) {
        this.region = value;
    }

}
