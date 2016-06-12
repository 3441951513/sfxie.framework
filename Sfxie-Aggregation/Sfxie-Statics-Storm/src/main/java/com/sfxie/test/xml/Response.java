package com.sfxie.test.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * 购买模块(purchase)返回基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:42:43 2015年9月2日
 * @example		
 *
 
 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>

<response
	website="http://183.60.142.159:8765/GoLiveLhq3/springmvc/api3/makemoney/judgeAdQuestionAnswer">
	<error code="" note="" servertime="2016-03-01 19:43:03" type="false" />
	<data is_right="1" />
</response>
 
 */

@XmlRootElement
//@XmlSeeAlso({
//SfxieResponse.class})
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Response<T> {
	public Response(){
		
	}
	protected Data<T> data;
	
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
	
	public abstract Data<T> getData();

	public abstract void setData(Data<T> data);
}
