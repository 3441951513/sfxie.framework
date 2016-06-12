package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "request")
public class WxInfo4Qrcode4AdRequest {

	private WxInfo4Qrcode4AdParameter parameter;
	

	@XmlElement(name="parameter")
	public WxInfo4Qrcode4AdParameter getParameter() {
		return parameter;
	}

	public void setParameter(WxInfo4Qrcode4AdParameter parameter) {
		this.parameter = parameter;
	}
	
}
