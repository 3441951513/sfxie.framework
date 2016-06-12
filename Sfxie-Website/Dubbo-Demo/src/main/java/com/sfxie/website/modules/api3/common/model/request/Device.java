package com.sfxie.website.modules.api3.common.model.request;


import javax.xml.bind.annotation.XmlAttribute;


public class Device {

	/**	电视用户系统的dnum	*/
    protected String dnum;
    /**	电视用户系统的didtoken	*/
    protected String didtoken;
    /**	电视用户系统的终端类型	*/
    protected String devmodel;
    /**	电视用户系统版本，默认值2	*/
    protected String dver;
    /**	终端类型：1-电视；2-OTT；3-手机；4-PAD；5-其他	*/
    protected String devtype;
    /**	设备类型	*/
    protected String clienttype;
    /**	mac地址	*/
    protected String mac;
    /**	终端设备号	*/
    protected String deviceid;

    @XmlAttribute(required = true)
    public String getDnum() {
        return dnum;
    }

    public void setDnum(String value) {
        this.dnum = value;
    }

    @XmlAttribute(required = true)
    public String getDidtoken() {
        return didtoken;
    }

    public void setDidtoken(String value) {
        this.didtoken = value;
    }

    @XmlAttribute(required = true)
    public String getDevmodel() {
        return devmodel;
    }

    public void setDevmodel(String value) {
        this.devmodel = value;
    }

    @XmlAttribute(required = true)
    public String getDver() {
        return dver;
    }

    public void setDver(String value) {
        this.dver = value;
    }

    @XmlAttribute(required = true)
    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String value) {
        this.devtype = value;
    }

    @XmlAttribute(required = true)
    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String value) {
        this.clienttype = value;
    }

    @XmlAttribute(required = true)
    public String getMac() {
        return mac;
    }

    public void setMac(String value) {
        this.mac = value;
    }

    @XmlAttribute(required = true)
    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String value) {
        this.deviceid = value;
    }

}
