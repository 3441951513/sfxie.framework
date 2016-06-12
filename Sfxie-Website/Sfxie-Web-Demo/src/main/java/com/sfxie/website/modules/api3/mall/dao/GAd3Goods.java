package com.sfxie.website.modules.api3.mall.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.sfxie.extension.mybatis.annotation.NotDBField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.utils.CollectionUtil;
/**
 * GAd3Goods 实体类
 * Fri Mar 04 13:02:25 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="g_ad3_goods")
public class GAd3Goods implements Serializable{

	@ColumnName(field="id")
	private Integer id;

	/**	商品名称	*/
	@ColumnName(field="name")
	private String name;

	/**	商品类型	*/
	@ColumnName(field="type")
	private Integer type;
	/**	商品类型名称	*/
	@NotDBField
	private String type_name;

	/**	现价	*/
	@ColumnName(field="current_price")
	private Float current_price;

	/**	原价	*/
	@ColumnName(field="original_price")
	private Float original_price;

	/**	抵扣金额	*/
	@ColumnName(field="deduction_price")
	private Float deduction_price;

	/**	限购数量	*/
	@ColumnName(field="limit_num")
	private Integer limit_num;

	/**	库存	*/
	@ColumnName(field="stock")
	private Integer stock;

	/**	上架时间	*/
	@ColumnName(field="shelve_time")
	private Date shelve_time;

	/**	下架时间	*/
	@ColumnName(field="unshelve_time")
	private Date unshelve_time;

	/**	商品顺序	*/
	@ColumnName(field="seq")
	private Integer seq;

	/**	记录状态	*/
	@ColumnName(field="state")
	private Short state;

	/**	商品描述	*/
	@ColumnName(field="description")
	private String description;

	/**	修改人	*/
	@ColumnName(field="modifier")
	private String modifier;

	/**	创建人	*/
	@ColumnName(field="creator")
	private String creator;

	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	更新时间	*/
	@ColumnName(field="update_time")
	private Date update_time;
	/**	必填	已销售数量*/
	@ColumnName(field="saled_count")
	private int saled_count;
	/**	必填 商品模式(1-实物,2-电子券)	*/
	@ColumnName(field="model")
	private String model;
	/**	必填 单位	*/
	@ColumnName(field="unit")
	private String unit;

	@NotDBField
	private Integer buy_limit;
	/**	是否推荐,Y-是,N-否	*/
	@ColumnName(field="is_recommend")
	private String is_recommend;
	/**	推荐类型的排序	*/
	@ColumnName(field="rseq")
	private Integer rseq;
	/**	推荐海报类型（1首页横条2首页竖条 ）	*/
	@ColumnName(field="recommond_cover_type")
	private String recommond_cover_type;
	
	@NotDBField
	private Integer ad_id;

	public void setId(Integer id){
		this.id=id;
	}

	 @XmlAttribute
	public Integer getId(){
		return id;
	}

	/**
	* 设置商品名称
	* @param name
	*/
	public void setName(String name){
		this.name=name;
	}

	/**	获取商品名称	*/
	 @XmlAttribute
	public String getName(){
		return name;
	}

	/**
	* 设置商品类型
	* @param type
	*/
	public void setType(Integer type){
		this.type=type;
	}

	/**	获取商品类型	*/
	 @XmlAttribute(name="classifing_code")
	public Integer getType(){
		return type;
	}
	 
	 /**	获取商品类型名称	*/
	 @XmlAttribute(name="classifing_name")
	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	/**
	* 设置现价
	* @param current_price
	*/
	public void setCurrent_price(Float current_price){
		this.current_price=current_price;
	}

	/**	获取现价	*/
	 @XmlAttribute
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
	 @XmlAttribute
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
	 @XmlAttribute
	public Float getDeduction_price(){
		return deduction_price;
	}

	/**
	* 设置限购数量
	* @param limit_num
	*/
	public void setLimit_num(Integer limit_num){
		this.limit_num=limit_num;
	}

	/**	获取限购数量	*/
	 @XmlAttribute
	public Integer getLimit_num(){
		return null==limit_num?-1:limit_num;
	}

	/**
	* 设置库存
	* @param stock
	*/
	public void setStock(Integer stock){
		this.stock=stock;
	}

	/**	获取库存	*/
	 @XmlAttribute
	public Integer getStock(){
		return stock;
	}

	/**
	* 设置上架时间
	* @param shelve_time
	*/
	public void setShelve_time(Date shelve_time){
		this.shelve_time=shelve_time;
	}

	/**	获取上架时间	*/
	 @XmlAttribute
	public Date getShelve_time(){
		return shelve_time;
	}

	/**
	* 设置下架时间
	* @param unshelve_time
	*/
	public void setUnshelve_time(Date unshelve_time){
		this.unshelve_time=unshelve_time;
	}

	/**	获取下架时间	*/
	 @XmlAttribute
	public Date getUnshelve_time(){
		return unshelve_time;
	}

	/**
	* 设置商品顺序
	* @param seq
	*/
	public void setSeq(Integer seq){
		this.seq=seq;
	}

	/**	获取商品顺序	*/
	 @XmlAttribute
	public Integer getSeq(){
		return seq;
	}

	/**
	* 设置记录状态
	* @param state
	*/
	public void setState(Short state){
		this.state=state;
	}

	/**	获取记录状态	*/
	 @XmlAttribute
	public Short getState(){
		return state;
	}

	/**
	* 设置商品描述
	* @param description
	*/
	public void setDescription(String description){
		this.description=description;
	}

	/**	获取商品描述	*/
	 @XmlAttribute
	public String getDescription(){
		return description;
	}

	/**
	* 设置修改人
	* @param modifier
	*/
	public void setModifier(String modifier){
		this.modifier=modifier;
	}

	/**	获取修改人	*/
	 @XmlAttribute
	public String getModifier(){
		return modifier;
	}

	/**
	* 设置创建人
	* @param creator
	*/
	public void setCreator(String creator){
		this.creator=creator;
	}

	/**	获取创建人	*/
	 @XmlAttribute
	public String getCreator(){
		return creator;
	}

	/**
	* 设置创建时间
	* @param create_time
	*/
	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}

	/**	获取创建时间	*/
	 @XmlAttribute
	public Date getCreate_time(){
		return create_time;
	}

	/**
	* 设置更新时间
	* @param update_time
	*/
	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}

	/**	获取更新时间	*/
	 @XmlAttribute
	public Date getUpdate_time(){
		return update_time;
	}

	 public int getSaled_count() {
		return saled_count;
	}

	public void setSaled_count(int saled_count) {
		this.saled_count = saled_count;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	@XmlAttribute
	public Integer getAd_id() {
		return ad_id;
	}

	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	@XmlAttribute
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@XmlAttribute
	public Integer getBuy_limit() {
		return buy_limit;
	}

	public void setBuy_limit(Integer buy_limit) {
		this.buy_limit = buy_limit;
	}
	@XmlAttribute(name="is_recommend")
	public String getIs_recommend() {
		return null==is_recommend?"N":is_recommend;
	}

	public void setIs_recommend(String is_recommend) {
		this.is_recommend = is_recommend;
	}
	@XmlAttribute
	public Integer getRseq() {
		return rseq;
	}

	public void setRseq(Integer rseq) {
		this.rseq = rseq;
	}
	@XmlAttribute
	public String getRecommond_cover_type() {
		return recommond_cover_type;
	}

	public void setRecommond_cover_type(String recommond_cover_type) {
		this.recommond_cover_type = recommond_cover_type;
	}
}

