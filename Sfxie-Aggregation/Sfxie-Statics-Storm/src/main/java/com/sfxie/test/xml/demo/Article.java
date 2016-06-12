package com.sfxie.test.xml.demo;

import javax.xml.bind.annotation.XmlAttribute;

public class Article {

	private String name;
	
	private String id;
	
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlAttribute
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
