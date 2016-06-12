package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.response;

import javax.xml.bind.annotation.XmlElement;

public class WxInfo4Qrcode4AdData {

	private WxInfo4Qrcode4AdPay pay;

	public WxInfo4Qrcode4AdPay getPay() {
		return pay;
	}

	@XmlElement
	public void setPay(WxInfo4Qrcode4AdPay pay) {
		this.pay = pay;
	}
	
	
}
