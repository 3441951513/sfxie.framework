package com.sfxie.soa.modules.dubbo.service.oa.pojo;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.extension.mybatis.annotation.ColumnName;
/**
 * SfxieSysMenu 实体类
 * Wed Apr 20 13:57:43 CST 2016  sfxie
 */
@XmlRootElement
@TableName(value="sfxie_sys_menu")
public class SfxieSysMenu extends OaBaseEntity{

	/**	记录主键	*/
	@ColumnName(field="id_")
	private String id_;

	/**	菜单代码	*/
	@ColumnName(field="menu_code")
	private String menu_code;

	/**	关联system_id	*/
	@ColumnName(field="system_id")
	private String system_id;

	/**	数据权限id	*/
	@ColumnName(field="auth_data_id")
	private String auth_data_id;

	/**	菜单名称	*/
	@ColumnName(field="menu_name")
	private String menu_name;

	/**	资源	*/
	@ColumnName(field="url")
	private String url;

	/**	描述	*/
	@ColumnName(field="description")
	private String description;

	/**	繁体菜单名称	*/
	@ColumnName(field="menu_name_tw")
	private String menu_name_tw;

	/**	网站标识	*/
	@ColumnName(field="webside")
	private String webside;

	/**	排序字段	*/
	@ColumnName(field="sequence_no")
	private Double sequence_no;

	/**	父主键	*/
	@ColumnName(field="parent_id")
	private String parent_id;

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

	/**	是否有效	*/
	@ColumnName(field="is_valid")
	private String is_valid;

	/**	all_parent_id	*/
	@ColumnName(field="all_parent_id")
	private String all_parent_id;

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

	/**
	* 设置关联system_id
	* @param system_id
	*/
	public void setSystem_id(String system_id){
		this.system_id=system_id;
	}

	/**	获取关联system_id	*/
	 @XmlAttribute
	public String getSystem_id(){
		return system_id;
	}

	/**
	* 设置数据权限id
	* @param auth_data_id
	*/
	public void setAuth_data_id(String auth_data_id){
		this.auth_data_id=auth_data_id;
	}

	/**	获取数据权限id	*/
	 @XmlAttribute
	public String getAuth_data_id(){
		return auth_data_id;
	}

	/**
	* 设置菜单名称
	* @param menu_name
	*/
	public void setMenu_name(String menu_name){
		this.menu_name=menu_name;
	}

	/**	获取菜单名称	*/
	 @XmlAttribute
	public String getMenu_name(){
		return menu_name;
	}

	/**
	* 设置资源
	* @param url
	*/
	public void setUrl(String url){
		this.url=url;
	}

	/**	获取资源	*/
	 @XmlAttribute
	public String getUrl(){
		return url;
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
	* 设置繁体菜单名称
	* @param menu_name_tw
	*/
	public void setMenu_name_tw(String menu_name_tw){
		this.menu_name_tw=menu_name_tw;
	}

	/**	获取繁体菜单名称	*/
	 @XmlAttribute
	public String getMenu_name_tw(){
		return menu_name_tw;
	}

	/**
	* 设置网站标识
	* @param webside
	*/
	public void setWebside(String webside){
		this.webside=webside;
	}

	/**	获取网站标识	*/
	 @XmlAttribute
	public String getWebside(){
		return webside;
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
	* 设置all_parent_id
	* @param all_parent_id
	*/
	public void setAll_parent_id(String all_parent_id){
		this.all_parent_id=all_parent_id;
	}

	/**	获取all_parent_id	*/
	 @XmlAttribute
	public String getAll_parent_id(){
		return all_parent_id;
	}
}

