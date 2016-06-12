package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.request.Request;


@XmlRootElement(name = "request")
public class GetGoodsDetailRequest extends Request {
	
	protected GetGoodsDetailParameter parameter;
	
	@XmlElement
	public GetGoodsDetailParameter getParameter() {
		return parameter;
	}

	public void setParameter(GetGoodsDetailParameter parameter) {
		this.parameter = parameter;
	}
}
