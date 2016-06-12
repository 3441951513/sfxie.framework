package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.common.xml.response.Error;



@XmlRootElement(name = "response")
public class AlipayInfo4Qrcode4AdResponse {

	private AlipayInfo4Qrcode4AdData data;
	
	@XmlElement(name="data")
	public AlipayInfo4Qrcode4AdData getData() {
		return data;
	}

	public void setData(AlipayInfo4Qrcode4AdData data) {
		this.data = data;
	}
	
	private Error error;

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
