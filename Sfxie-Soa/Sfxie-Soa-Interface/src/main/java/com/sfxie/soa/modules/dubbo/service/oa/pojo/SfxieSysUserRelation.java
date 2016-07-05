package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysUserRelation 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_user_relation")
public class SfxieSysUserRelation extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	用户代码	*/
	@ColumnName(field="user_id")
	private String user_id;

	/**	用户职位	*/
	@ColumnName(field="user_title")
	private String user_title;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	最后修改时间	*/
	@ColumnName(field="update_time")
	private Date update_time;

	/**	最后修改人	*/
	@ColumnName(field="update_user")
	private String update_user;

	/**	记录创建人	*/
	@ColumnName(field="create_user")
	private String create_user;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

	/**	email	*/
	@ColumnName(field="email")
	private String email;

	/**	手机号	*/
	@ColumnName(field="phone")
	private String phone;

	/**	用户中文名	*/
	@ColumnName(field="user_name_cn")
	private String user_name_cn;

	/**	用户英文名称	*/
	@ColumnName(field="user_name_en")
	private String user_name_en;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	用户类型	*/
	@ColumnName(field="user_type")
	private String user_type;

	/**	是否默认	*/
	@ColumnName(field="is_default")
	private String is_default;

	/**	公司代码	*/
	@ColumnName(field="company_code")
	private String company_code;

	/**	岗位代码	*/
	@ColumnName(field="post_code")
	private String post_code;

	/**	部门代码	*/
	@ColumnName(field="department_code")
	private String department_code;

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
	* 设置用户职位
	* @param user_title
	*/
	public void setUser_title(String user_title){
		this.user_title=user_title;
	}

	/**	获取用户职位	*/
	 @XmlAttribute
	public String getUser_title(){
		return user_title;
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
	* 设置email
	* @param email
	*/
	public void setEmail(String email){
		this.email=email;
	}

	/**	获取email	*/
	 @XmlAttribute
	public String getEmail(){
		return email;
	}

	/**
	* 设置手机号
	* @param phone
	*/
	public void setPhone(String phone){
		this.phone=phone;
	}

	/**	获取手机号	*/
	 @XmlAttribute
	public String getPhone(){
		return phone;
	}

	/**
	* 设置用户中文名
	* @param user_name_cn
	*/
	public void setUser_name_cn(String user_name_cn){
		this.user_name_cn=user_name_cn;
	}

	/**	获取用户中文名	*/
	 @XmlAttribute
	public String getUser_name_cn(){
		return user_name_cn;
	}

	/**
	* 设置用户英文名称
	* @param user_name_en
	*/
	public void setUser_name_en(String user_name_en){
		this.user_name_en=user_name_en;
	}

	/**	获取用户英文名称	*/
	 @XmlAttribute
	public String getUser_name_en(){
		return user_name_en;
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
	* 设置用户类型
	* @param user_type
	*/
	public void setUser_type(String user_type){
		this.user_type=user_type;
	}

	/**	获取用户类型	*/
	 @XmlAttribute
	public String getUser_type(){
		return user_type;
	}

	/**
	* 设置是否默认
	* @param is_default
	*/
	public void setIs_default(String is_default){
		this.is_default=is_default;
	}

	/**	获取是否默认	*/
	 @XmlAttribute
	public String getIs_default(){
		return is_default;
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

