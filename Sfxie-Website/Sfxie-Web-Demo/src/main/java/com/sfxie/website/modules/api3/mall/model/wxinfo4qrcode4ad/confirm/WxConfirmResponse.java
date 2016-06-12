package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.confirm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.common.xml.response.Error;


@XmlRootElement(name = "response")
public class WxConfirmResponse {
	
	private WxConfirmData data;
	
	private Error error;
	
	@XmlElement(name="data")
	public WxConfirmData getData() {
		return data;
	}

	public void setData(WxConfirmData data) {
		this.data = data;
	}

	@XmlElement(name="error")
	public Error getError() {
		if(null==error){
			Error e = new Error();
			e.setCode("");
			e.setNote("");
			e.setType("false");
			return e;
		}
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	
	
}
