package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.website.common.xml.response.Data;
import com.sfxie.website.common.xml.response.Response;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "response")
public class GetGoodsDetailResponse extends Response<Goods> {

	@XmlElement(name="data",type=GetGoodsDetailData.class)
	public Data<Goods> getData() {
		if(null==data)
			data = new GetGoodsDetailData();
		return data;
	}

	@XmlAccessorType(XmlAccessType.NONE)
	@XmlRootElement
	static class GetGoodsDetailData extends Data<Goods> {
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
