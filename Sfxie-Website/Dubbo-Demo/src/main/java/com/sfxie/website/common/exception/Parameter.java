package com.sfxie.website.common.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.utils.jacson.codehaus.JsonUtil;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="parameter")
public class Parameter {

	private Object data;
	
	private String type;

	@XmlElement
	public Object getData() {
		return null!=data?JsonUtil.toJSON(data):null;
	}

	public void setData(Object data) {
		this.data = data;
	}
	@XmlAttribute(name = "type")
	public String getType() {
		return null==type?"false":type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
