package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysSystem 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_system")
public class SfxieSysSystem extends SecurityObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	系统代码	*/
	@ColumnName(field="system_code")
	private String system_code;

	/**	系统名称	*/
	@ColumnName(field="system_name")
	private String system_name;

	/**	描述	*/
	@ColumnName(field="description")
	private String description;

	/**	sys_url	*/
	@ColumnName(field="sys_url")
	private String sys_url;

	/**	sys_inner_url	*/
	@ColumnName(field="sys_inner_url")
	private String sys_inner_url;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

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
	* 设置记录主键
	* @param id_
	*/
	public void setId_(String id_){
		this.id_=id_;
	}

	/**	获取记录主键	*/
	 @XmlAttribute
	public String getId_(){
		return id_;
	}

	/**
	* 设置系统代码
	* @param system_code
	*/
	public void setSystem_code(String system_code){
		this.system_code=system_code;
	}

	/**	获取系统代码	*/
	 @XmlAttribute
	public String getSystem_code(){
		return system_code;
	}

	/**
	* 设置系统名称
	* @param system_name
	*/
	public void setSystem_name(String system_name){
		this.system_name=system_name;
	}

	/**	获取系统名称	*/
	 @XmlAttribute
	public String getSystem_name(){
		return system_name;
	}

	/**
	* 设置描述
	* @param description
	*/
	public void setDescription(String description){
		this.description=description;
	}

	/**	获取描述	*/
	 @XmlAttribute
	public String getDescription(){
		return description;
	}

	/**
	* 设置sys_url
	* @param sys_url
	*/
	public void setSys_url(String sys_url){
		this.sys_url=sys_url;
	}

	/**	获取sys_url	*/
	 @XmlAttribute
	public String getSys_url(){
		return sys_url;
	}

	/**
	* 设置sys_inner_url
	* @param sys_inner_url
	*/
	public void setSys_inner_url(String sys_inner_url){
		this.sys_inner_url=sys_inner_url;
	}

	/**	获取sys_inner_url	*/
	 @XmlAttribute
	public String getSys_inner_url(){
		return sys_inner_url;
	}

	/**
	* 设置排序字段
	* @param sequence_no
	*/
	public void setSequence_no(Double sequence_no){
		this.sequence_no=sequence_no;
	}

	/**	获取排序字段	*/
	 @XmlAttribute
	public Double getSequence_no(){
		return sequence_no;
	}

	/**
	* 设置是否有效
	* @param is_valid
	*/
	public void setIs_valid(String is_valid){
		this.is_valid=is_valid;
	}

	/**	获取是否有效	*/
	 @XmlAttribute
	public String getIs_valid(){
		return is_valid;
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
}

