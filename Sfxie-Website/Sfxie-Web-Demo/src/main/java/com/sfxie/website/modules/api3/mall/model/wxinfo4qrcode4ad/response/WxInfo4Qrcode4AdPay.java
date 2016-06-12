package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.response;

import javax.xml.bind.annotation.XmlAttribute;

public class WxInfo4Qrcode4AdPay {

	private String pay_url;
	
//	private String orderCode;
	
	private String qrtext;
	
	@XmlAttribute(name="pay_url")
	public String getPay_url() {
		return pay_url;
	}
	public void setPay_url(String pay_url) {
		this.pay_url = pay_url;
	}
//	@XmlAttribute(name="productid")
//	public String getOrderCode() {
//		return orderCode;
//	}
//	public void setOrderCode(String orderCode) {
//		this.orderCode = orderCode;
//	}
	@XmlAttribute(name="qrtext")
	public String getQrtext() {
		return qrtext;
	}
	public void setQrtext(String qrtext) {
		this.qrtext = qrtext;
	}
	
	
}
