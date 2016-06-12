package com.sfxie.website.modules.api3.mall.model.getmallclassifylist.request;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.website.modules.api3.common.model.request.Parameter;

public class GetMallClassifyListParameter extends Parameter {

	private GetMallClassifyListData data;

	@XmlElement(name="data",required = true)
	public GetMallClassifyListData getData() {
		return data;
	}

	public void setData(GetMallClassifyListData data) {
		this.data = data;
	}
	
	
}
