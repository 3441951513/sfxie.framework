package com.sfxie.soa.modules.dubbo.service.oa.pojo;

import com.sfxie.soa.dubbo.pojo.SerializableObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysCompany 实体类
 * Wed Apr 20 13:57:42 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_company")
public class SfxieSysCompany extends SerializableObject{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	公司代码	*/
	@ColumnName(field="company_code")
	private String company_code;

	/**	公司中文名称	*/
	@ColumnName(field="company_name_cn")
	private String company_name_cn;

	/**	公司英文名称	*/
	@ColumnName(field="company_name_en")
	private String company_name_en;

	/**	公司地址	*/
	@ColumnName(field="address")
	private String address;

	/**	公司电话	*/
	@ColumnName(field="tel")
	private String tel;

	/**	公司传真	*/
	@ColumnName(field="fax")
	private String fax;

	/**	主页URL	*/
	@ColumnName(field="url")
	private String url;

	/**	email	*/
	@ColumnName(field="email")
	private String email;

	/**	备注	*/
	@ColumnName(field="remark")
	private String remark;

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

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	公司中文名称简称	*/
	@ColumnName(field="short_name_cn")
	private String short_name_cn;

	/**	公司英文名称简称	*/
	@ColumnName(field="short_name_en")
	private String short_name_en;

	/**	公司级别	*/
	@ColumnName(field="company_level")
	private Double company_level;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

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
	* 设置公司中文名称
	* @param company_name_cn
	*/
	public void setCompany_name_cn(String company_name_cn){
		this.company_name_cn=company_name_cn;
	}

	/**	获取公司中文名称	*/
	 @XmlAttribute
	public String getCompany_name_cn(){
		return company_name_cn;
	}

	/**
	* 设置公司英文名称
	* @param company_name_en
	*/
	public void setCompany_name_en(String company_name_en){
		this.company_name_en=company_name_en;
	}

	/**	获取公司英文名称	*/
	 @XmlAttribute
	public String getCompany_name_en(){
		return company_name_en;
	}

	/**
	* 设置公司地址
	* @param address
	*/
	public void setAddress(String address){
		this.address=address;
	}

	/**	获取公司地址	*/
	 @XmlAttribute
	public String getAddress(){
		return address;
	}

	/**
	* 设置公司电话
	* @param tel
	*/
	public void setTel(String tel){
		this.tel=tel;
	}

	/**	获取公司电话	*/
	 @XmlAttribute
	public String getTel(){
		return tel;
	}

	/**
	* 设置公司传真
	* @param fax
	*/
	public void setFax(String fax){
		this.fax=fax;
	}

	/**	获取公司传真	*/
	 @XmlAttribute
	public String getFax(){
		return fax;
	}

	/**
	* 设置主页URL
	* @param url
	*/
	public void setUrl(String url){
		this.url=url;
	}

	/**	获取主页URL	*/
	 @XmlAttribute
	public String getUrl(){
		return url;
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
	* 设置备注
	* @param remark
	*/
	public void setRemark(String remark){
		this.remark=remark;
	}

	/**	获取备注	*/
	 @XmlAttribute
	public String getRemark(){
		return remark;
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
	* 设置公司中文名称简称
	* @param short_name_cn
	*/
	public void setShort_name_cn(String short_name_cn){
		this.short_name_cn=short_name_cn;
	}

	/**	获取公司中文名称简称	*/
	 @XmlAttribute
	public String getShort_name_cn(){
		return short_name_cn;
	}

	/**
	* 设置公司英文名称简称
	* @param short_name_en
	*/
	public void setShort_name_en(String short_name_en){
		this.short_name_en=short_name_en;
	}

	/**	获取公司英文名称简称	*/
	 @XmlAttribute
	public String getShort_name_en(){
		return short_name_en;
	}

	/**
	* 设置公司级别
	* @param company_level
	*/
	public void setCompany_level(Double company_level){
		this.company_level=company_level;
	}

	/**	获取公司级别	*/
	 @XmlAttribute
	public Double getCompany_level(){
		return company_level;
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
}

