package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.request;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.common.model.request.Parameter;

public class GetMallClassifyProductListParameter extends Parameter {

	private GetMallClassifyProductListData data;

	@XmlElement(name="data",required = true)
	public GetMallClassifyProductListData getData() {
		return data;
	}

	public void setData(GetMallClassifyProductListData data) {
		this.data = data;
	}
	
	
}
