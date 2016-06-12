package com.sfxie.core.base;

import java.io.Serializable;

import com.sfxie.utils.StringUtils;




/**
 * 实体基类.
 * 
 * @author XIESHENGFENG
 * @since 2013-06-25
 */
@SuppressWarnings("serial")
public class BaseEntity extends BaseDataObject implements Serializable {
	/**
	 * 实体ID.
	 */
//	private String id;

	/**
	 * 获取实体ID.
	 * 
	 * @return 实体ID.
	 */
//	public String getId() {
//		return this.id;
//	}

	/**
	 * 设置实体ID.
	 * 
	 * @param id 实体ID.
	 */
//	public void setId(String id) {
//		this.id = id;
//	}
	
	/**
	 * 获取实体ID.
	 * 
	 * @return 实体ID.
	 */
//	public int getIdAsInteger() {
//		return StringUtils.toInteger(this.id);
//	}

	/**
	 * 设置实体ID.
	 * 
	 * @param id 实体ID.
	 */
//	public void setId(int id) {
//		this.id = StringUtils.toString(id);
//	}
//	
//	public BaseEntity() {
//		this.id = StringUtils.getUUID();
//	}
	protected String getUUID(){
		return StringUtils.getUUID();
	}
}
