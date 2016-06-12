package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sfxie.utils.CollectionUtil;


public class PurchaseOrderData {
	
	/**	必填	订单ID	*/
	private String orderid;
	/**	必填	订单流水号	*/
	private String orderSerial;
	
	private Integer quantity;
	/**	必填	是否完成付款(Y-是,N-否)	*/
	private String isFinished;
	
	private List<Pay> pay;
	/**	必填	用户钱包余额*/
	private String wallet;

	@XmlAttribute
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	@XmlAttribute(name="order_serial")
	public String getOrderSerial() {
		return orderSerial;
	}
	public void setOrderSerial(String orderSerial) {
		this.orderSerial = orderSerial;
	}
	@XmlElement
	public List<Pay> getPay() {
		pay = CollectionUtil.nullRetureNewList(pay);
		return pay;
	}
	public void setPay(List<Pay> pay) {
		this.pay = pay;
	}
	@XmlTransient
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@XmlAttribute(name="is_finished")
	public String getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
	@XmlAttribute
	public String getWallet() {
		return wallet;
	}
	public void setWallet(String wallet) {
		this.wallet = wallet;
	}
	
}