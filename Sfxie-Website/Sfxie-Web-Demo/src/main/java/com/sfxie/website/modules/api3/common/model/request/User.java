package com.sfxie.website.modules.api3.common.model.request;

import javax.xml.bind.annotation.XmlAttribute;


public class User {
	/**	golive用户账号	*/
    protected String userid;
    /**	golive用户名	*/
    protected String token;

    @XmlAttribute(required = true)
    public String getUserid() {
        return userid;
    }

    public void setUserid(String value) {
        this.userid = value;
    }

    @XmlAttribute(required = true)
    public String getToken() {
        return token;
    }

    public void setToken(String value) {
        this.token = value;
    }

}
