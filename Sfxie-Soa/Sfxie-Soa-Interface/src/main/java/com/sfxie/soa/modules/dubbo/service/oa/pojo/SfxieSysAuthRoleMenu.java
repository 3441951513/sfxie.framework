package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysAuthRoleMenu 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_auth_role_menu")
public class SfxieSysAuthRoleMenu extends SecurityObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	角色菜单关联表id	*/
	@ColumnName(field="role_menu_id")
	private String role_menu_id;

	/**	数据权限表id	*/
	@ColumnName(field="auth_data_id")
	private String auth_data_id;

	/**	上一级公司	*/
	@ColumnName(field="owner_company_code")
	private String owner_company_code;

	/**	公司角色关联表id	*/
	@ColumnName(field="company_role_id")
	private String company_role_id;

	/**	分区字段	*/
	@ColumnName(field="partition_company")
	@PartitionField
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
	* 设置角色菜单关联表id
	* @param role_menu_id
	*/
	public void setRole_menu_id(String role_menu_id){
		this.role_menu_id=role_menu_id;
	}

	/**	获取角色菜单关联表id	*/
	 @XmlAttribute
	public String getRole_menu_id(){
		return role_menu_id;
	}

	/**
	* 设置数据权限表id
	* @param auth_data_id
	*/
	public void setAuth_data_id(String auth_data_id){
		this.auth_data_id=auth_data_id;
	}

	/**	获取数据权限表id	*/
	 @XmlAttribute
	public String getAuth_data_id(){
		return auth_data_id;
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
	* 设置公司角色关联表id
	* @param company_role_id
	*/
	public void setCompany_role_id(String company_role_id){
		this.company_role_id=company_role_id;
	}

	/**	获取公司角色关联表id	*/
	 @XmlAttribute
	public String getCompany_role_id(){
		return company_role_id;
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

