package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.common.model.request.Parameter;

public class GetGoodsDetailParameter extends Parameter {

	private GetGoodsDetailData data;

	@XmlElement(name="data",required = true)
	public GetGoodsDetailData getData() {
		return data;
	}

	public void setData(GetGoodsDetailData data) {
		this.data = data;
	}
	
	
}
