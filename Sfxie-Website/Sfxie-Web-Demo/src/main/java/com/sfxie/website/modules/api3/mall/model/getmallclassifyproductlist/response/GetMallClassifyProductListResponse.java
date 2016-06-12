package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.common.xml.response.Data;
import com.sfxie.website.common.xml.response.Response;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="response")
public class GetMallClassifyProductListResponse extends Response<Goods> {

	@XmlElement(name="data",type=GetMallClassifyProductListData.class)
	public Data<Goods> getData() {
		if(null==data)
			data = new GetMallClassifyProductListData();
		return data;
	}

	@XmlAccessorType(XmlAccessType.NONE)
	@XmlRootElement
	static class GetMallClassifyProductListData extends Data<Goods> {
		
		@XmlElement(name="goods")
		@Override
		public List<Goods> getList() {
			return createList();
		}
	}

	@Override
	public Data<Goods> getEntity() {
		return null;
	}
}
