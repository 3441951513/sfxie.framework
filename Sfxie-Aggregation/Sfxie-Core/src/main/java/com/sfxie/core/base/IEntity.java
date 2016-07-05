package com.sfxie.core.base;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

public interface IEntity {
	/**
	* 设置创建时间
	* @param create_time
	*/
	public void setCreate_time(Date create_time);

	/**	获取创建时间	*/
	 @XmlAttribute
	public Date getCreate_time();

	/**
	* 设置记录创建人
	* @param create_user
	*/
	public void setCreate_user(String create_user);

	/**	获取记录创建人	*/
	 @XmlAttribute
	public String getCreate_user();

	/**
	* 设置最后修改人
	* @param update_user
	*/
	public void setUpdate_user(String update_user);
	/**	获取最后修改人	*/
	 @XmlAttribute
	public String getUpdate_user();

	/**
	* 设置最后修改时间
	* @param update_time
	*/
	public void setUpdate_time(Date update_time);

	/**	获取最后修改时间	*/
	 @XmlAttribute
	public Date getUpdate_time();
	 
}
