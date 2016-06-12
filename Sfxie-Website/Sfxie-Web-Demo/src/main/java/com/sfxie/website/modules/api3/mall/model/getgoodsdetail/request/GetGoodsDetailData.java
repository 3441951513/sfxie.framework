package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request;


import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.website.modules.api3.common.model.request.Data;



public class GetGoodsDetailData extends Data {
	
	/**	商品ID */
	private Integer goodsid;

	@XmlAttribute(name="goodsid")
	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
}
