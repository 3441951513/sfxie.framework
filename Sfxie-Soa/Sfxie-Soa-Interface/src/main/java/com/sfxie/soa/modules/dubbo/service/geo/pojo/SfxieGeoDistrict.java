package com.sfxie.soa.modules.dubbo.service.geo.pojo;

import com.sfxie.soa.common.request.SecurityObject;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieGeoDistrict 实体类
 * Sun Jul 17 21:18:25 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_geo_district")
public class SfxieGeoDistrict extends SecurityObject{

	/**	主键	*/
	@ColumnName(field="id_",isKey=true)
	private Integer id_;

	/**	区编码	*/
	@ColumnName(field="district_code")
	private String district_code;

	/**	区名称	*/
	@ColumnName(field="district_name")
	private String district_name;

	/**	记录创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	城市编码	*/
	@ColumnName(field="city_code")
	private String city_code;

	/**	城市名称	*/
	@ColumnName(field="city_name")
	private String city_name;

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
	* 设置区编码
	* @param district_code
	*/
	public void setDistrict_code(String district_code){
		this.district_code=district_code;
	}

	/**	获取区编码	*/
	 @XmlAttribute
	public String getDistrict_code(){
		return district_code;
	}

	/**
	* 设置区名称
	* @param district_name
	*/
	public void setDistrict_name(String district_name){
		this.district_name=district_name;
	}

	/**	获取区名称	*/
	 @XmlAttribute
	public String getDistrict_name(){
		return district_name;
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
	* 设置城市编码
	* @param city_code
	*/
	public void setCity_code(String city_code){
		this.city_code=city_code;
	}

	/**	获取城市编码	*/
	 @XmlAttribute
	public String getCity_code(){
		return city_code;
	}

	/**
	* 设置城市名称
	* @param city_name
	*/
	public void setCity_name(String city_name){
		this.city_name=city_name;
	}

	/**	获取城市名称	*/
	 @XmlAttribute
	public String getCity_name(){
		return city_name;
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

