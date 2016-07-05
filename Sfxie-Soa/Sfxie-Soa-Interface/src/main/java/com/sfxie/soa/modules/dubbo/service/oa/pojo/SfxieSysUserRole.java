package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysUserRole 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_user_role")
public class SfxieSysUserRole extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	用户代码	*/
	@ColumnName(field="user_id")
	private String user_id;

	/**	上一级公司	*/
	@ColumnName(field="owner_company_code")
	private String owner_company_code;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	用户关联表id	*/
	@ColumnName(field="user_info_relation_id")
	private String user_info_relation_id;

	/**	角色代码	*/
	@ColumnName(field="role_code")
	private String role_code;

	/**	分区字段	*/
	@ColumnName(field="partition_company")
	private String partition_company;

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
	* 设置用户代码
	* @param user_id
	*/
	public void setUser_id(String user_id){
		this.user_id=user_id;
	}

	/**	获取用户代码	*/
	 @XmlAttribute
	public String getUser_id(){
		return user_id;
	}

	/**
	* 设置上一级公司
	* @param owner_company_code
	*/
	public void setOwner_company_code(String owner_company_code){
		this.owner_company_code=owner_company_code;
	}

	/**	获取上一级公司	*/
	 @XmlAttribute
	public String getOwner_company_code(){
		return owner_company_code;
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
	* 设置用户关联表id
	* @param user_info_relation_id
	*/
	public void setUser_info_relation_id(String user_info_relation_id){
		this.user_info_relation_id=user_info_relation_id;
	}

	/**	获取用户关联表id	*/
	 @XmlAttribute
	public String getUser_info_relation_id(){
		return user_info_relation_id;
	}

	/**
	* 设置角色代码
	* @param role_code
	*/
	public void setRole_code(String role_code){
		this.role_code=role_code;
	}

	/**	获取角色代码	*/
	 @XmlAttribute
	public String getRole_code(){
		return role_code;
	}

	/**
	* 设置分区字段
	* @param partition_company
	*/
	public void setPartition_company(String partition_company){
		this.partition_company=partition_company;
	}

	/**	获取分区字段	*/
	 @XmlAttribute
	public String getPartition_company(){
		return partition_company;
	}
}

