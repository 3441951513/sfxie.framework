package com.sfxie.website.modules.api3.mall.model.querypaystate.response;


import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.website.modules.api3.common.model.response.Data;



public class PayStateData extends Data {
	
	private String orderid;
	private String payState;
	private String info;
	/**	必填	用户钱包余额*/
	private String wallet;
	
	@XmlAttribute
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@XmlAttribute(name="pay_state")
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	@XmlAttribute
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@XmlAttribute
	public String getWallet() {
		return wallet;
	}
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	
	

}
