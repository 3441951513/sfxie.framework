package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.request.Request;


@XmlRootElement(name = "request")
public class CreatePurchaseOrderRequest  extends Request{

	private CreatePurchaseOrderParameter parameter;

	@XmlElement(name="parameter")
	public CreatePurchaseOrderParameter getParameter() {
		return parameter;
	}

	public void setParameter(CreatePurchaseOrderParameter parameter) {
		this.parameter = parameter;
	}
	
	
}
