package com.sfxie.tool.reverse.db2java.xml.cobar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "cobar")
public class LocationCobarSchema {

	
	private LocatioinDataSource locatioinDataSource;


	@XmlElement(name="dataSource")
	public LocatioinDataSource getLocatioinDataSource() {
		return locatioinDataSource;
	}

	public void setLocatioinDataSource(LocatioinDataSource locatioinDataSource) {
		this.locatioinDataSource = locatioinDataSource;
	}

	
}
