package com.sfxie.soa.modules.dubbo.service.app.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.core.base.IEntity;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.TableName;
import com.sfxie.soa.common.request.Request;
import com.sfxie.soa.common.request.SecurityUser;

/**
 * 栏位实体类
 * @author xiesf
 *
 */
@XmlRootElement
@TableName(value="sfxie_app_bar")
public class SfxieAppBar extends PageBaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**	记录主键	*/
	@ColumnName(field="id_" ,isKey=true)
	private Long id_;
	
	/**	栏位名称	*/
	@ColumnName(field="name")
	private String name;
	/**	栏位url	*/
	@ColumnName(field="bar_url")
	private String bar_url;
	/**	是否有效	*/
	@ColumnName(field="validable")
	private String validable;
	/**	数据库分区字段	*/
	@ColumnName(field="db_partition_number")
	private String db_partition_number;

	public Long getId_() {
		return id_;
	}

	public void setId_(Long id_) {
		this.id_ = id_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBar_url() {
		return bar_url;
	}

	public void setBar_url(String bar_url) {
		this.bar_url = bar_url;
	}

	public String getValidable() {
		return validable;
	}

	public void setValidable(String validable) {
		this.validable = validable;
	}

	public String getDb_partition_number() {
		return db_partition_number;
	}

	public void setDb_partition_number(String db_partition_number) {
		this.db_partition_number = db_partition_number;
	}
	
	

	
	
}
