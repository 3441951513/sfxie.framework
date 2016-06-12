package com.sfxie.website.modules.api3.mall.model.getmallclassifylist.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.common.xml.response.Data;
import com.sfxie.website.common.xml.response.Response;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="response")
public class GetMallClassifyListResponse extends Response<Classifing> {
	
	@XmlElement(name="data",type=GetMallClassifyListData.class)
	public Data<Classifing> getData() {
		if(null==data)
			data = new GetMallClassifyListData();
		return data;
	}
	
	@XmlAccessorType(XmlAccessType.NONE)
	@XmlRootElement
	static class GetMallClassifyListData extends Data<Classifing> {
		@XmlElement(name="classifing")
		@Override
		public List<Classifing> getList() {
			return createList();
		}
	}

	@Override
	public Data<Classifing> getEntity() {
		return null;
	}
	
}
