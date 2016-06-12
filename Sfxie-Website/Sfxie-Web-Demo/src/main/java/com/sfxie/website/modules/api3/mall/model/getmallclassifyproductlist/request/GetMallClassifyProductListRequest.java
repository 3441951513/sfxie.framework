package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.modules.api3.common.model.request.Request;


@XmlRootElement(name = "request")
public class GetMallClassifyProductListRequest extends Request {
	
	protected GetMallClassifyProductListParameter parameter;
	
	@XmlElement
	public GetMallClassifyProductListParameter getParameter() {
		return parameter;
	}

	public void setParameter(GetMallClassifyProductListParameter parameter) {
		this.parameter = parameter;
	}
}
