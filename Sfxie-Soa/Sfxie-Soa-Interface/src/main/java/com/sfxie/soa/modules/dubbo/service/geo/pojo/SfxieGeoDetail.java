package com.sfxie.soa.modules.dubbo.service.geo.pojo;

import com.sfxie.soa.common.request.SecurityObject;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieGeoDetail 实体类
 * Sun Jul 17 21:18:25 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_geo_detail")
public class SfxieGeoDetail extends SecurityObject{

	/**	主键	*/
	@ColumnName(field="id_",isKey=true)
	private Integer id_;

	/**	建筑物编码	*/
	@ColumnName(field="poi_code")
	private String poi_code;

	/**	建筑物名称	*/
	@ColumnName(field="poi_name")
	private String poi_name;

	/**	建筑物全名	*/
	@ColumnName(field="full_name")
	private String full_name;

	/**	记录创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	街道编码	*/
	@ColumnName(field="street_code")
	private String street_code;

	/**	街道名称	*/
	@ColumnName(field="street_name")
	private String street_name;

	/**	地理位置级别	*/
	@ColumnName(field="level")
	private String level;

	/**
	* 设置主键
	* @param id_
	*/
	public void setId_(Integer id_){
		this.id_=id_;
	}

	/**	获取主键	*/
	 @XmlAttribute
	public Integer getId_(){
		return id_;
	}

	/**
	* 设置建筑物编码
	* @param poi_code
	*/
	public void setPoi_code(String poi_code){
		this.poi_code=poi_code;
	}

	/**	获取建筑物编码	*/
	 @XmlAttribute
	public String getPoi_code(){
		return poi_code;
	}

	/**
	* 设置建筑物名称
	* @param poi_name
	*/
	public void setPoi_name(String poi_name){
		this.poi_name=poi_name;
	}

	/**	获取建筑物名称	*/
	 @XmlAttribute
	public String getPoi_name(){
		return poi_name;
	}

	/**
	* 设置建筑物全名
	* @param full_name
	*/
	public void setFull_name(String full_name){
		this.full_name=full_name;
	}

	/**	获取建筑物全名	*/
	 @XmlAttribute
	public String getFull_name(){
		return full_name;
	}

	/**
	* 设置记录创建时间
	* @param create_time
	*/
	public void setCreate_time(Date create_time){
		this.create_time=create_time;
	}

	/**	获取记录创建时间	*/
	 @XmlAttribute
	public Date getCreate_time(){
		return create_time;
	}

	/**
	* 设置街道编码
	* @param street_code
	*/
	public void setStreet_code(String street_code){
		this.street_code=street_code;
	}

	/**	获取街道编码	*/
	 @XmlAttribute
	public String getStreet_code(){
		return street_code;
	}

	/**
	* 设置街道名称
	* @param street_name
	*/
	public void setStreet_name(String street_name){
		this.street_name=street_name;
	}

	/**	获取街道名称	*/
	 @XmlAttribute
	public String getStreet_name(){
		return street_name;
	}

	/**
	* 设置地理位置级别
	* @param level
	*/
	public void setLevel(String level){
		this.level=level;
	}

	/**	获取地理位置级别	*/
	 @XmlAttribute
	public String getLevel(){
		return level;
	}
}

