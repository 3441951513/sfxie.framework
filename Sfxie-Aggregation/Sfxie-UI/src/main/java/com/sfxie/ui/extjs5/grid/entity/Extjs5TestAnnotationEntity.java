package com.sfxie.ui.extjs5.grid.entity;

import java.util.Date;

import org.cniemp.core.condition.Condition;

import com.cniemp.extension.mybatis.annotation.ColumnName;
import com.cniemp.extension.mybatis.annotation.NotDBField;
import com.cniemp.extension.mybatis.annotation.TableName;
import com.sfxie.ui.extjs5.annotation.ExtjsGridFormSubmitUrl;
import com.sfxie.ui.extjs5.annotation.I18nRefrencePropertity;

@TableName(value="sfxie_collection_bug")
@ExtjsGridFormSubmitUrl(submitUrl="http://localhost:8081/Extjs5/springmvc/SfxieCollectionController.do?method=newSfxieCollectionBug&treeId=dddd")
public class Extjs5TestAnnotationEntity implements Condition{
	@I18nRefrencePropertity(property="SfxieCollectionBug.id")
	@ColumnName(field="id_")
	private Long id;
	@I18nRefrencePropertity(property="SfxieCollectionBug.code")
	@ColumnName(field="code_")
	private String code;
	@I18nRefrencePropertity(property="SfxieCollectionBug.name")
	@ColumnName(field="name_")
	private String name;
	
	@ColumnName(field="content_")
	private String content;
	
	@ColumnName(field="type_")
	private String type;
	
	@ColumnName(field="create_time")
	private Date createTime;
	
	@ColumnName(field="create_user_id")
	private String createUserId;
	
	@ColumnName(field="ip_")
	private String ip;
	
	@NotDBField
	private String notDbField;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
