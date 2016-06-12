package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.PriceFenConvertXmlAdapter;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Goods{
	
	private List<Poster> poster;
	
	private List<Attributes> attributes;
	
	private Integer id;
	private String name;
	private String original_price;
	private String current_price;
	private Integer stock;
	private String deduction_price;
	private Integer limit_num;
	private int state;
	private String description;
	/**	必填	已销售数量*/
	private int saled_count;
	/**	必填 商品模式(1-实物,2-电子券)	*/
	private String model;
	/** 上架时间 */
	private Date shelve_time;
	/** 下架时间 */
	private Date unshelve_time;
	/**	商品类型id	*/
	private Integer type;
	/**	商品类型名称	*/
	private String type_name;
	/**	价格单位	*/
	private String unit;
	/**	每人当前允许购买数量(-1表示无限制)	*/
	private Integer buy_limit;
	
	/**	每人当前允许购买数量(-1表示无限制)	*/
	private String over_allow_tip;
	
	@XmlAttribute
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	@XmlAttribute(name="original_price")
	public String getOriginal_price() {
		return original_price;
	}
	public void setOriginal_price(String original_price) {
		this.original_price = original_price;
	}
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	@XmlAttribute(name="current_price")
	public String getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(String current_price) {
		this.current_price = current_price;
	}
	@XmlAttribute
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	@XmlAttribute(name="deduction_price")
	public String getDeduction_price() {
		return deduction_price;
	}
	public void setDeduction_price(String deduction_price) {
		this.deduction_price = deduction_price;
	}
	@XmlAttribute(name="limit_num")
	public Integer getLimit_num() {
		return limit_num;
	}
	public void setLimit_num(Integer limit_num) {
		this.limit_num = limit_num;
	}
	@XmlAttribute
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@XmlAttribute
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlTransient
	public Date getShelve_time() {
		return shelve_time;
	}
	public void setShelve_time(Date shelve_time) {
		this.shelve_time = shelve_time;
	}
	@XmlTransient
	public Date getUnshelve_time() {
		return unshelve_time;
	}
	public void setUnshelve_time(Date unshelve_time) {
		this.unshelve_time = unshelve_time;
	}
	@XmlAttribute
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@XmlAttribute(name="type_name")
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@XmlElement
	public List<Poster> getPoster() {
		return poster;
	}
	public void setPoster(List<Poster> poster) {
		this.poster = poster;
	}
	@XmlElement
	public List<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}
	@XmlAttribute(name="saled_count")
	public int getSaled_count() {
		return saled_count;
	}
	public void setSaled_count(int saled_count) {
		this.saled_count = saled_count;
	}
	@XmlAttribute
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@XmlAttribute
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@XmlAttribute(name="buy_limit")
	public Integer getBuy_limit() {
		return null==buy_limit?0:buy_limit;
	}
	public void setBuy_limit(Integer buy_limit) {
		this.buy_limit = buy_limit;
	}
}
