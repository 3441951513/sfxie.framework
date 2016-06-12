package com.sfxie.website.modules.api3.mall.model.getmallclassifylist.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.request.Request;


@XmlRootElement(name = "request")
public class GetMallClassifyListRequest extends Request {
	
	protected GetMallClassifyListParameter parameter;
	
	@XmlElement
	public GetMallClassifyListParameter getParameter() {
		return parameter;
	}

	public void setParameter(GetMallClassifyListParameter parameter) {
		this.parameter = parameter;
	}
}
