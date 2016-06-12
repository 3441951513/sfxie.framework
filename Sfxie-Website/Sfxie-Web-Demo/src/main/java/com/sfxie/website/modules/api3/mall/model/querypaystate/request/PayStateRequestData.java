package com.sfxie.website.modules.api3.mall.model.querypaystate.request;

import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.website.modules.api3.common.model.request.Data;


public class PayStateRequestData extends Data {

	private Integer orderid;
	
	@XmlAttribute
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
}
