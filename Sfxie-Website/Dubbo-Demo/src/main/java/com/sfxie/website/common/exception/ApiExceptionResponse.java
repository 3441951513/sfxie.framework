package com.sfxie.website.common.exception;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.response.Response;



@XmlRootElement(name = "response")
public class ApiExceptionResponse extends Response {

	
	private Parameter parameters;
	
	@XmlElement(name="parameter")
	public Parameter getParameters() {
		return parameters;
	}

	public void setParameters(Parameter parameters) {
		this.parameters = parameters;
	}

	
}
