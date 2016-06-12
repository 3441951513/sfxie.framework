package com.sfxie.test.business.api.test.golive.rts;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "response")
public class RtsResponse{

	private RtsData data;

	@XmlElement(name="data")
	public RtsData getData() {
		return data;
	}

	public void setData(RtsData data) {
		this.data = data;
	}
	
	
	
}
