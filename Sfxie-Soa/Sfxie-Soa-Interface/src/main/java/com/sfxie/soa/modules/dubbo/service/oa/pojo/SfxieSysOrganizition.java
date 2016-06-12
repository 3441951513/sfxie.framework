package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.common.request.SecurityObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysOrganizition 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_organizition")
public class SfxieSysOrganizition extends SecurityObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	无效时间	*/
	@ColumnName(field="invalid_date")
	private Date invalid_date;

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

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	公司代码	*/
	@ColumnName(field="company_code")
	private String company_code;

	/**	公司代码	*/
	@ColumnName(field="parent_company_code")
	private String parent_company_code;

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
	* 设置无效时间
	* @param invalid_date
	*/
	public void setInvalid_date(Date invalid_date){
		this.invalid_date=invalid_date;
	}

	/**	获取无效时间	*/
	 @XmlAttribute
	public Date getInvalid_date(){
		return invalid_date;
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
	* 设置公司代码
	* @param parent_company_code
	*/
	public void setParent_company_code(String parent_company_code){
		this.parent_company_code=parent_company_code;
	}

	/**	获取公司代码	*/
	 @XmlAttribute
	public String getParent_company_code(){
		return parent_company_code;
	}
}

