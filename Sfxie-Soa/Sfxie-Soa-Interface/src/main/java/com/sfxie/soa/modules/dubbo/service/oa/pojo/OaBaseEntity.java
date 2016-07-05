package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.core.base.IEntity;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.soa.common.request.SecurityObject;

public class OaBaseEntity extends SecurityObject implements IEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;
	/**	记录创建人	*/
	@ColumnName(field="create_user")
	private String create_user;

	/**	最后修改时间	*/
	@ColumnName(field="update_time")
	private Date update_time;

	/**	最后修改人	*/
	@ColumnName(field="update_user")
	private String update_user;
	
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
	* 设置记录创建人
	* @param create_user
	*/
	public void setCreate_user(String create_user){
		this.create_user=create_user;
	}

	/**	获取记录创建人	*/
	 @XmlAttribute
	public String getCreate_user(){
		return create_user;
	}

	/**
	* 设置最后修改人
	* @param update_user
	*/
	public void setUpdate_user(String update_user){
		this.update_user=update_user;
	}

	/**	获取最后修改人	*/
	 @XmlAttribute
	public String getUpdate_user(){
		return update_user;
	}

	/**
	* 设置最后修改时间
	* @param update_time
	*/
	public void setUpdate_time(Date update_time){
		this.update_time=update_time;
	}

	/**	获取最后修改时间	*/
	 @XmlAttribute
	public Date getUpdate_time(){
		return update_time;
	}

}
