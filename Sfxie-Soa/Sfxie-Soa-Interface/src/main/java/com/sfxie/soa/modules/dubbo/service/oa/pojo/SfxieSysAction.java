package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysAction 实体类
 * Wed Apr 20 13:57:42 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_action")
public class SfxieSysAction extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	动作名称	*/
	@ColumnName(field="action_name")
	private String action_name;

	/**	动作资源	*/
	@ColumnName(field="action_url")
	private String action_url;

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

	/**	置参数标记	*/
	@ColumnName(field="param_flag")
	private String param_flag;

	/**	菜单代码	*/
	@ColumnName(field="menu_code")
	private String menu_code;

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
	* 设置动作名称
	* @param action_name
	*/
	public void setAction_name(String action_name){
		this.action_name=action_name;
	}

	/**	获取动作名称	*/
	 @XmlAttribute
	public String getAction_name(){
		return action_name;
	}

	/**
	* 设置动作资源
	* @param action_url
	*/
	public void setAction_url(String action_url){
		this.action_url=action_url;
	}

	/**	获取动作资源	*/
	 @XmlAttribute
	public String getAction_url(){
		return action_url;
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
	* 设置置参数标记
	* @param param_flag
	*/
	public void setParam_flag(String param_flag){
		this.param_flag=param_flag;
	}

	/**	获取置参数标记	*/
	 @XmlAttribute
	public String getParam_flag(){
		return param_flag;
	}

	/**
	* 设置菜单代码
	* @param menu_code
	*/
	public void setMenu_code(String menu_code){
		this.menu_code=menu_code;
	}

	/**	获取菜单代码	*/
	 @XmlAttribute
	public String getMenu_code(){
		return menu_code;
	}
}

