package com.sfxie.data.xml.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class Response {

	
	private Data data ;
	
	private Error error;

	@XmlElement(name="data")
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	@XmlElement(name="error")
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
	
}
