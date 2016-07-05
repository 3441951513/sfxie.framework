package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysDepartment 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_department")
public class SfxieSysDepartment extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	部门代码	*/
	@ColumnName(field="department_code")
	private String department_code;

	/**	部门名称	*/
	@ColumnName(field="department_name")
	private String department_name;

	/**	记录创建人	*/
	@ColumnName(field="create_user")
	private String create_user;

	/**	创建时间	*/
	@ColumnName(field="create_time")
	private Date create_time;

	/**	最后修改人	*/
	@ColumnName(field="update_user")
	private String update_user;

	/**	最后修改时间	*/
	@ColumnName(field="update_time")
	private Date update_time;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	父主键	*/
	@ColumnName(field="parent_id")
	private String parent_id;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

	/**	公司代码	*/
	@ColumnName(field="company_code")
	private String company_code;

	/**	 父节点代码	*/
	@ColumnName(field="parent_code")
	private String parent_code;

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
	* 设置部门名称
	* @param department_name
	*/
	public void setDepartment_name(String department_name){
		this.department_name=department_name;
	}

	/**	获取部门名称	*/
	 @XmlAttribute
	public String getDepartment_name(){
		return department_name;
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
	* 设置 父节点代码
	* @param parent_code
	*/
	public void setParent_code(String parent_code){
		this.parent_code=parent_code;
	}

	/**	获取 父节点代码	*/
	 @XmlAttribute
	public String getParent_code(){
		return parent_code;
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

