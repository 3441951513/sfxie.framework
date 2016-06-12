package com.sfxie.website.modules.api3.common.model.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 购买模块(purchase)返回基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:42:43 2015年9月2日
 * @example		
 *
 */
//@XmlRootElement(name = "response")
public class Response {

	private String website;
	
	private Error error;

	@XmlElement(name="error")
	public Error getError() {
		if(null==error){
			Error e = new Error();
			e.setCode("");
			e.setNote("");
			e.setType("false");
			return e;
		}
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getWebsite() {
		return website;
	}
	@XmlAttribute
	public void setWebsite(String website) {
		this.website = website;
	}
}
