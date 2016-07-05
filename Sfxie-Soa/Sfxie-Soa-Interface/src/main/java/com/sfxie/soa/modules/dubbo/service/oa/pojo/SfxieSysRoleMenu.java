package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysRoleMenu 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_role_menu")
public class SfxieSysRoleMenu extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	上一级公司	*/
	@ColumnName(field="owner_company_code")
	private String owner_company_code;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	公司角色关联表id	*/
	@ColumnName(field="company_role_id")
	private String company_role_id;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

	/**	继承的角色菜单id	*/
	@ColumnName(field="oraginal_role_menu_id")
	private String oraginal_role_menu_id;

	/**	角色代码	*/
	@ColumnName(field="role_code")
	private String role_code;

	/**	菜单代码	*/
	@ColumnName(field="menu_code")
	private String menu_code;

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
	* 设置创建公司
	* @param create_company_id
	*/
	public void setCreate_company_id(String create_company_id){
		this.create_company_id=create_company_id;
	}

	/**	获取创建公司	*/
	 @XmlAttribute
	public String getCreate_company_id(){
		return create_company_id;
	}

	/**
	* 设置继承的角色菜单id
	* @param oraginal_role_menu_id
	*/
	public void setOraginal_role_menu_id(String oraginal_role_menu_id){
		this.oraginal_role_menu_id=oraginal_role_menu_id;
	}

	/**	获取继承的角色菜单id	*/
	 @XmlAttribute
	public String getOraginal_role_menu_id(){
		return oraginal_role_menu_id;
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
	* 设置菜单代码
	* @param menu_code
	*/
	public void setMenu_code(String menu_code){
		this.menu_code=menu_code;
	}

	/**	获取菜单代码	*/
	 @XmlAttribute
	public String getMenu_code(){
		return menu_code;
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

