package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysAuthData 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_auth_data")
public class SfxieSysAuthData extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	角色主键	*/
	@ColumnName(field="role_id")
	private String role_id;

	/**	资源名称	*/
	@ColumnName(field="resource_name")
	private String resource_name;

	/**	资源代码	*/
	@ColumnName(field="resource_code")
	private String resource_code;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

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

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	上一级公司	*/
	@ColumnName(field="owner_company_code")
	private String owner_company_code;

	/**	数据权限sql查询语句	*/
	@ColumnName(field="sql_")
	private String sql_;

	/**	角色菜单关联表id	*/
	@ColumnName(field="role_menu_id")
	private String role_menu_id;

	/**	java处理类	*/
	@ColumnName(field="dealer_class")
	private String dealer_class;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

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
	* 设置角色主键
	* @param role_id
	*/
	public void setRole_id(String role_id){
		this.role_id=role_id;
	}

	/**	获取角色主键	*/
	 @XmlAttribute
	public String getRole_id(){
		return role_id;
	}

	/**
	* 设置资源名称
	* @param resource_name
	*/
	public void setResource_name(String resource_name){
		this.resource_name=resource_name;
	}

	/**	获取资源名称	*/
	 @XmlAttribute
	public String getResource_name(){
		return resource_name;
	}

	/**
	* 设置资源代码
	* @param resource_code
	*/
	public void setResource_code(String resource_code){
		this.resource_code=resource_code;
	}

	/**	获取资源代码	*/
	 @XmlAttribute
	public String getResource_code(){
		return resource_code;
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
	* 设置数据权限sql查询语句
	* @param sql_
	*/
	public void setSql_(String sql_){
		this.sql_=sql_;
	}

	/**	获取数据权限sql查询语句	*/
	 @XmlAttribute
	public String getSql_(){
		return sql_;
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
	* 设置java处理类
	* @param dealer_class
	*/
	public void setDealer_class(String dealer_class){
		this.dealer_class=dealer_class;
	}

	/**	获取java处理类	*/
	 @XmlAttribute
	public String getDealer_class(){
		return dealer_class;
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

