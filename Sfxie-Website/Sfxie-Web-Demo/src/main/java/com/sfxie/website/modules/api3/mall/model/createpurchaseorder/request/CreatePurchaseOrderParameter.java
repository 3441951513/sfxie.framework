package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.request;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.common.model.request.Parameter;


public class CreatePurchaseOrderParameter  extends Parameter {

	private Param data;
	
	private CreatePurchaseOrderClient client;
	

	@XmlElement(name="data")
	public Param getData() {
		return data;
	}

	public void setData(Param data) {
		this.data = data;
	}
	
	@XmlElement(name="client")
	public CreatePurchaseOrderClient getClient() {
		return client;
	}

	public void setClient(CreatePurchaseOrderClient client) {
		this.client = client;
	}
	
	
}
