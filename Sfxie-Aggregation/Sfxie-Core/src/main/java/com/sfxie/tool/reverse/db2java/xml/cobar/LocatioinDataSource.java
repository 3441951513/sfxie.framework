package com.sfxie.tool.reverse.db2java.xml.cobar;

import javax.xml.bind.annotation.XmlElement;

public class LocatioinDataSource {

	
	private LocationProperty property;

	
	@XmlElement(name="property")
	public LocationProperty getProperty() {
		return property;
	}

	public void setProperty(LocationProperty property) {
		this.property = property;
	}


	
}
