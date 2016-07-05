package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysPost 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_post")
public class SfxieSysPost extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	岗位代码	*/
	@ColumnName(field="post_code")
	private String post_code;

	/**	部门主键	*/
	@ColumnName(field="department_id")
	private String department_id;

	/**	岗位名称	*/
	@ColumnName(field="post_name")
	private String post_name;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	岗位级别	*/
	@ColumnName(field="post_level")
	private String post_level;

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

	/**	公司主键	*/
	@ColumnName(field="company_id")
	private String company_id;

	/**	父主键	*/
	@ColumnName(field="parent_id")
	private String parent_id;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

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
	* 设置部门主键
	* @param department_id
	*/
	public void setDepartment_id(String department_id){
		this.department_id=department_id;
	}

	/**	获取部门主键	*/
	 @XmlAttribute
	public String getDepartment_id(){
		return department_id;
	}

	/**
	* 设置岗位名称
	* @param post_name
	*/
	public void setPost_name(String post_name){
		this.post_name=post_name;
	}

	/**	获取岗位名称	*/
	 @XmlAttribute
	public String getPost_name(){
		return post_name;
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
	* 设置岗位级别
	* @param post_level
	*/
	public void setPost_level(String post_level){
		this.post_level=post_level;
	}

	/**	获取岗位级别	*/
	 @XmlAttribute
	public String getPost_level(){
		return post_level;
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
	* 设置公司主键
	* @param company_id
	*/
	public void setCompany_id(String company_id){
		this.company_id=company_id;
	}

	/**	获取公司主键	*/
	 @XmlAttribute
	public String getCompany_id(){
		return company_id;
	}

	/**
	* 设置父主键
	* @param parent_id
	*/
	public void setParent_id(String parent_id){
		this.parent_id=parent_id;
	}

	/**	获取父主键	*/
	 @XmlAttribute
	public String getParent_id(){
		return parent_id;
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

