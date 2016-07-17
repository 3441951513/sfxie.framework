/****************************************************************
 ***        Copyright © EASTCOMPEACE        2012.08.22        ***
 ****************************************************************/

package com.sfxie.ui.extjs5.tree;

import com.cniemp.core.base.BaseDTO;



/**
 * 树型节点DTO.
 * 
 * @author XIESHENGFENG
 * @since 2013-06-21
 */
public class TreeNodeDTO extends BaseDTO {
	/**
	 * 节点ID.
	 */
	private Object id;
	
	/**
	 * 节点名称.
	 */
	private String name;
	
	/**
	 * 父节点ID.
	 */
	private Object pid;
	
	/**
	 * 是否父节点.
	 */
	private boolean isParent;

	/**
	 * 获取节点ID.
	 * 
	 * @return 节点ID.
	 */
	public Object getId() {
		return id;
	}

	/**
	 * 设置节点ID.
	 * 
	 * @param id
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * 获取节点名称.
	 * 
	 * @return 节点名称.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置节点名称.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取父节点ID.
	 * 
	 * @return 父节点ID.
	 */
	public Object getPid() {
		return pid;
	}

	/**
	 * 设置父节点ID.
	 * 
	 * @param pid
	 */
	public void setPid(Object pid) {
		this.pid = pid;
	}

	/**
	 * 是否父节点.父节点由程序指定，可以存在没有子节点的父节点.
	 * 
	 * @return 是返回true，否返回false.
	 */
	public boolean getIsParent() {
		return isParent ;
	}
	
	/**
	 * 设置是否父节点.父节点由程序指定，可以存在没有子节点的父节点.
	 * 
	 * @param isParent
	 */
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;//(isParent == 0 ? false : true);
	}
}
