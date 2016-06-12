package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysAuthorization 实体类
 * Wed Apr 20 13:57:42 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_authorization")
public class SfxieSysAuthorization extends SecurityObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	角色代码	*/
	@ColumnName(field="role_code")
	private String role_code;

	/**	公司代码	*/
	@ColumnName(field="company_code")
	private String company_code;

	/**	部门代码	*/
	@ColumnName(field="department_code")
	private String department_code;

	/**	岗位代码	*/
	@ColumnName(field="post_code")
	private String post_code;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

	/**	记录创建人	*/
	@ColumnName(field="create_user")
	private String create_user;

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
	* 设置公司代码
	* @param company_code
	*/
	public void setCompany_code(String company_code){
		this.company_code=company_code;
	}

	/**	获取公司代码	*/
	 @XmlAttribute
	public String getCompany_code(){
		return company_code;
	}

	/**
	* 设置部门代码
	* @param department_code
	*/
	public void setDepartment_code(String department_code){
		this.department_code=department_code;
	}

	/**	获取部门代码	*/
	 @XmlAttribute
	public String getDepartment_code(){
		return department_code;
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

