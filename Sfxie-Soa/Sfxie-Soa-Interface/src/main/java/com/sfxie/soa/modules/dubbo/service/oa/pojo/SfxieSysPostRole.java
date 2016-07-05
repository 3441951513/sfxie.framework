package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysPostRole 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_post_role")
public class SfxieSysPostRole extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	上一级公司	*/
	@ColumnName(field="owner_company_code")
	private String owner_company_code;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	岗位代码	*/
	@ColumnName(field="post_code")
	private String post_code;

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
	* 设置岗位代码
	* @param post_code
	*/
	public void setPost_code(String post_code){
		this.post_code=post_code;
	}

	/**	获取岗位代码	*/
	 @XmlAttribute
	public String getPost_code(){
		return post_code;
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

