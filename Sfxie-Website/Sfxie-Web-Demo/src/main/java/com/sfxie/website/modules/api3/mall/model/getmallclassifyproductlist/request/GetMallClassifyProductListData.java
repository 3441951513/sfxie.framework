package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.request;


import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.website.modules.api3.common.model.request.Data;



public class GetMallClassifyProductListData extends Data {

	/** 商城板块分类编码 */
	private String classifingCode;

	@XmlAttribute(name="classifing_code")
	public String getClassifingCode() {
		return classifingCode;
	}

	public void setClassifingCode(String classifingCode) {
		this.classifingCode = classifingCode;
	}
	
	
	
}
