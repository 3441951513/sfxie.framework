package com.sfxie.soa.modules.dubbo.service.geo.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.ConditionColumn;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieGeoCountry 实体类
 * Sun Jul 17 21:18:25 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_geo_country")
public class SfxieGeoCountry extends SecurityObject{

	/**	主键	*/
	@ColumnName(field="id_",isKey=true)
	private Integer id_;

	/**	国家编码	*/
	@ColumnName(field="country_code")
	private String country_code;

	/**	国家名称	*/
	@ColumnName(field="country_name")
	@ConditionColumn
	private String country_name;

	/**	记录创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

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
	* 设置国家编码
	* @param country_code
	*/
	public void setCountry_code(String country_code){
		this.country_code=country_code;
	}

	/**	获取国家编码	*/
	 @XmlAttribute
	public String getCountry_code(){
		return country_code;
	}

	/**
	* 设置国家名称
	* @param country_name
	*/
	public void setCountry_name(String country_name){
		this.country_name=country_name;
	}

	/**	获取国家名称	*/
	 @XmlAttribute
	public String getCountry_name(){
		return country_name;
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

