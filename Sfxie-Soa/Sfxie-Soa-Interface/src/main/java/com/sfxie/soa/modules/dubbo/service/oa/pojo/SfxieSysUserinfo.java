package com.sfxie.soa.modules.dubbo.service.oa.pojo;



import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.data.security.DefaultSqlDecorator;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.SqlDecorator;
import com.sfxie.extension.mybatis.annotation.TableName;
/**
 * SfxieSysUserinfo 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_userinfo")
@SqlDecorator(decorator = DefaultSqlDecorator.class)
public class SfxieSysUserinfo extends OaBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**	用户代码	*/
	@ColumnName(field="user_id",isKey=true)
	private String user_id;

	/**	用户密码	*/
	@ColumnName(field="user_password")
	private String user_password;

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	是否为超级管理员	*/
	@ColumnName(field="is_superman")
	private String is_superman;

	/**	创建公司	*/
	@ColumnName(field="create_company_id")
	private String create_company_id;

	/**	用户性别	*/
	@ColumnName(field="sex")
	private String sex;

	/**	分区字段	*/
	@ColumnName(field="partition_company")
	private String partition_company;

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
	* 设置用户密码
	* @param user_password
	*/
	public void setUser_password(String user_password){
		this.user_password=user_password;
	}

	/**	获取用户密码	*/
	 @XmlAttribute
	public String getUser_password(){
		return user_password;
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
	* 设置是否为超级管理员
	* @param is_superman
	*/
	public void setIs_superman(String is_superman){
		this.is_superman=is_superman;
	}

	/**	获取是否为超级管理员	*/
	 @XmlAttribute
	public String getIs_superman(){
		return is_superman;
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
	* 设置用户性别
	* @param sex
	*/
	public void setSex(String sex){
		this.sex=sex;
	}

	/**	获取用户性别	*/
	 @XmlAttribute
	public String getSex(){
		return sex;
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
	 
	 
	@Override
	public String getUserId() {
		return user_id;
	}

	@Override
	public String getUserPassword() {
		return user_password;
	}
}

