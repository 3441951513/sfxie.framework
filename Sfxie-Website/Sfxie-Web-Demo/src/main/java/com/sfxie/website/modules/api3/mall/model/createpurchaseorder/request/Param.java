package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.FenYuanMutualConvert;

public class Param {
	/**	必填	收货人手机号	*/
	private String phone;
	/** 必填	数量	*/
	private String goodsid;
	/** 必填	商品颜色属性ID	*/
	private Integer colorId;
	/** 必填	商品颜色属性名称	*/
	private String colorName;
	/** 必填	商品尺寸属性ID	*/
	private Integer sizeId;
	/** 必填	商品尺寸属性名称	*/
	private String sizeName;
	/** 必填	收货地址	*/
	private String address;
	/** 必填	数量	*/
	private Integer quantity;
	
	/** 必填	支付类型(1-支付宝,2-微信)	*/
//	private String pay_type;
	/** 必填	抵扣金额	*/
	private Float deduction_price;
	/** 必填	实付人民币	*/
	private Float cash;
	
	@XmlAttribute
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@XmlAttribute
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	@XmlAttribute(name="color_id")
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	@XmlAttribute(name="size_id")
	public Integer getSizeId() {
		return sizeId;
	}
	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}
	@XmlAttribute
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@XmlAttribute
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
//	@XmlAttribute(name="pay_type")
//	public String getPay_type() {
//		return pay_type;
//	}
//	public void setPay_type(String pay_type) {
//		this.pay_type = pay_type;
//	}
	
	@XmlJavaTypeAdapter(FenYuanMutualConvert.class)
	@XmlAttribute(name="deduction_price")
	public Float getDeduction_price() {
		return deduction_price;
	}
	public void setDeduction_price(Float deduction_price) {
		this.deduction_price = deduction_price;
	}
	@XmlAttribute(name="color_name")
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	@XmlAttribute(name="size_name")
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	@XmlAttribute
	@XmlJavaTypeAdapter(FenYuanMutualConvert.class)
	public Float getCash() {
		return cash;
	}
	public void setCash(Float cash) {
		this.cash = cash;
	}
	
}
