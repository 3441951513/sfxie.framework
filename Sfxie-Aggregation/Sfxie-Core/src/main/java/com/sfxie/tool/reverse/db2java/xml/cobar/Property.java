package com.sfxie.tool.reverse.db2java.xml.cobar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class Property {

	private String name;
	
	private DataSourceRef dataSourceRef;
	
	private String location;
	
	private String value;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	
//	public DataSourceRef getDataSourceRef() {
//		return dataSourceRef;
//	}
//
//	public void setDataSourceRef(DataSourceRef dataSourceRef) {
//		this.dataSourceRef = dataSourceRef;
//	}

//	@XmlElement
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}

	@XmlValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
