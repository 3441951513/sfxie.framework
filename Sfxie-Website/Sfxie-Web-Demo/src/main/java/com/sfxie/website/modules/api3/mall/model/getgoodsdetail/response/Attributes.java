package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Attributes {
	
	private Integer id;

	private List<Attribute> attribute;

	@XmlElement
	public List<Attribute> getAttribute() {
		if(null==attribute){
			attribute = new ArrayList<Attribute>();
		}
		return attribute;
	}

	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}

	@XmlAttribute(name="type")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
