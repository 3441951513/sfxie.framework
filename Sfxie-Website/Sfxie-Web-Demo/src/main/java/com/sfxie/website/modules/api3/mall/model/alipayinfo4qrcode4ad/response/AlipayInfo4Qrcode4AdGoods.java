package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.response;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.PriceFenConvertXmlAdapter;




public class AlipayInfo4Qrcode4AdGoods {
	
	private String price;
	
	private String note;
	
	private String goodsName;
	
	private String smallCover;
	
	private Integer stock;
	
	private Integer macAmount;
	
	private String model;
	
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSmallCover() {
		return smallCover;
	}
	public void setSmallCover(String smallCover) {
		this.smallCover = smallCover;
	}
	@XmlTransient
	public Integer getStock() {
		return null==stock?0:stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@XmlTransient
	public Integer getMacAmount() {
		return macAmount;
	}
	public void setMacAmount(Integer macAmount) {
		this.macAmount = macAmount;
	}
	@XmlTransient
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
