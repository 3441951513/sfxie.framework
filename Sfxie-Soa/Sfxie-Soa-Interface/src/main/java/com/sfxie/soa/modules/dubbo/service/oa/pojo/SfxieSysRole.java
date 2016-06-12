package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysRole 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_role")
public class SfxieSysRole extends SecurityObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	角色代码	*/
	@ColumnName(field="role_code")
	private String role_code;

	/**	角色名称	*/
	@ColumnName(field="role_name")
	private String role_name;

	/**	描述	*/
	@ColumnName(field="description")
	private String description;

	/**	角色英文名称	*/
	@ColumnName(field="role_name_en")
	private String role_name_en;

	/**	最后修改时间	*/
	@ColumnName(field="update_time")
	private Date update_time;

	/**	最后修改人	*/
	@ColumnName(field="update_user")
	private String update_user;

	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	记录创建人	*/
	@ColumnName(field="create_user")
	private String create_user;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

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
	* 设置角色名称
	* @param role_name
	*/
	public void setRole_name(String role_name){
		this.role_name=role_name;
	}

	/**	获取角色名称	*/
	 @XmlAttribute
	public String getRole_name(){
		return role_name;
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
	* 设置角色英文名称
	* @param role_name_en
	*/
	public void setRole_name_en(String role_name_en){
		this.role_name_en=role_name_en;
	}

	/**	获取角色英文名称	*/
	 @XmlAttribute
	public String getRole_name_en(){
		return role_name_en;
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

