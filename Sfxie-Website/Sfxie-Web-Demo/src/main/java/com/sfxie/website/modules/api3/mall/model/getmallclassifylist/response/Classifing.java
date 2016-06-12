package com.sfxie.website.modules.api3.mall.model.getmallclassifylist.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Classifing{
	/**	必填	分类名称	*/
	private String name;
	/**	必填	分类编码	*/
	private String code;
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
