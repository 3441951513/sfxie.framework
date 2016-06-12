package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.response;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.FenYuanMutualConvert;



@XmlRootElement
public class Goods {
	
	private Covers covers;
	
	private Integer id;

	private String name;

	/**	推荐海报类型（1首页横条2首页竖条 ）	*/
	private String recommond_cover_type;
	
	/**	现价	*/
	private Float current_price;

	/**	原价	*/
	private Float original_price;

	/**	抵扣金额	*/
	private Float deduction_price;
	
	
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

	@XmlAttribute(name="recommond_cover_type")
	public String getRecommond_cover_type() {
		return recommond_cover_type;
	}

	public void setRecommond_cover_type(String recommond_cover_type) {
		this.recommond_cover_type = recommond_cover_type;
	}

	@XmlElement
	public Covers getCovers() {
		if(null==covers)
			covers = new Covers();
		return covers;
	}

	public void setCovers(Covers covers) {
		this.covers = covers;
	}
	/**
	* 设置现价
	* @param current_price
	*/
	public void setCurrent_price(Float current_price){
		this.current_price=current_price;
	}

	/**	获取现价	*/
	@XmlJavaTypeAdapter(FenYuanMutualConvert.class)
	@XmlAttribute(name="current_price")
	public Float getCurrent_price(){
		return current_price;
	}

	/**
	* 设置原价
	* @param original_price
	*/
	public void setOriginal_price(Float original_price){
		this.original_price=original_price;
	}

	/**	获取原价	*/
	@XmlJavaTypeAdapter(FenYuanMutualConvert.class)
	@XmlAttribute(name="original_price")
	public Float getOriginal_price(){
		return original_price;
	}

	/**
	* 设置抵扣金额
	* @param deduction_price
	*/
	public void setDeduction_price(Float deduction_price){
		this.deduction_price=deduction_price;
	}

	/**	获取抵扣金额	*/
	@XmlJavaTypeAdapter(FenYuanMutualConvert.class)
	@XmlAttribute(name="deduction_price")
	public Float getDeduction_price(){
		return deduction_price;
	}
	
}
