package com.sfxie.soa.modules.dubbo.service.geo.pojo;

import com.sfxie.soa.common.request.SecurityObject;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieGeoCity 实体类
 * Sun Jul 17 21:18:25 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_geo_city")
public class SfxieGeoCity extends SecurityObject{

	/**	主键	*/
	@ColumnName(field="id_",isKey=true)
	private Integer id_;

	/**	城市编码	*/
	@ColumnName(field="city_code")
	private String city_code;

	/**	城市名称	*/
	@ColumnName(field="city_name")
	private String city_name;

	/**	记录创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	邮编编码	*/
	@ColumnName(field="mail_code")
	private String mail_code;

	/**	省份编码	*/
	@ColumnName(field="province_code")
	private String province_code;

	/**	省份名称	*/
	@ColumnName(field="province_name")
	private String province_name;

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
	* 设置邮编编码
	* @param mail_code
	*/
	public void setMail_code(String mail_code){
		this.mail_code=mail_code;
	}

	/**	获取邮编编码	*/
	 @XmlAttribute
	public String getMail_code(){
		return mail_code;
	}

	/**
	* 设置省份编码
	* @param province_code
	*/
	public void setProvince_code(String province_code){
		this.province_code=province_code;
	}

	/**	获取省份编码	*/
	 @XmlAttribute
	public String getProvince_code(){
		return province_code;
	}

	/**
	* 设置省份名称
	* @param province_name
	*/
	public void setProvince_name(String province_name){
		this.province_name=province_name;
	}

	/**	获取省份名称	*/
	 @XmlAttribute
	public String getProvince_name(){
		return province_name;
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

