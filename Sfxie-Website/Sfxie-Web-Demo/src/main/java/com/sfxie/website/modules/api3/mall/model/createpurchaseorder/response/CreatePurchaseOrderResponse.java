package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.response.Response;




@XmlRootElement(name = "response")
public class CreatePurchaseOrderResponse extends Response {

	private PurchaseOrderData data;

	@XmlElement(name="data")
	public PurchaseOrderData getData() {
		return data;
	}

	public void setData(PurchaseOrderData data) {
		this.data = data;
	}
	
	
}
