package com.sfxie.website.modules.api3.common.model.response;

import javax.xml.bind.annotation.XmlAttribute;


public class Data {
	
	private Integer total;

	@XmlAttribute
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
