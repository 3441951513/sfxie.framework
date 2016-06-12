package com.sfxie.website.modules.api3.mall.model.querypaystate.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.request.Request;


@XmlRootElement(name = "request")
public class PayStateRequest  extends Request{

	private PayStateParameter parameter;

	@XmlElement(name="parameter")
	public PayStateParameter getParameter() {
		return parameter;
	}

	public void setParameter(PayStateParameter parameter) {
		this.parameter = parameter;
	}
	
	
}
