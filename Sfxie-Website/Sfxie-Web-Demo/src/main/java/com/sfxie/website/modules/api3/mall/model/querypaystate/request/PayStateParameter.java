package com.sfxie.website.modules.api3.mall.model.querypaystate.request;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.common.model.request.Parameter;


public class PayStateParameter  extends Parameter {

	private PayStateRequestData data;

	@XmlElement(name="data")
	public PayStateRequestData getData() {
		return data;
	}

	public void setData(PayStateRequestData data) {
		this.data = data;
	}
	
	
}
