package com.sfxie.website.modules.api3.mall.model.getmallclassifylist.request;


import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.website.modules.api3.common.model.request.Data;



public class GetMallClassifyListData extends Data {
	
	/**	商城板块类型 */
	private String classifing_code;

	@XmlAttribute
	public String getClassifing_code() {
		return classifing_code;
	}

	public void setClassifing_code(String classifing_code) {
		this.classifing_code = classifing_code;
	}
}
