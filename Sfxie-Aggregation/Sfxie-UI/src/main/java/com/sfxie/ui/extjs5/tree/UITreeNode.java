package com.sfxie.ui.extjs5.tree;
import java.lang.reflect.Field;
import java.util.ArrayList;   
import java.util.HashMap;
import java.util.List;   
import java.util.Map;

import com.cniemp.utils.ReflectUtils;



/**
 * 树节点类,主要用于zTree的树节点生成
 * @author xieshengfeng
 * @since 2013-06-21
 *
 */
public class UITreeNode extends Object{ 
	/**
	 * 顶层节点标志
	 */
	public static final String ROOT_FLAG = "0"; 
	/**
	 * 节点id
	 */
    private String id; 
    /** 
     * 节点显示名称 
     */
    private String name; 
    /**
     * 父节点id
     */
    private String pid; 
    /**
     * 是否有子节点
     */
    
    private boolean isParent;
    /** 
     * 节点显示名称 (客户端可用)
     */
    private String text;
    /**
     * 子节点(客户端可用)
     */
    List<UITreeNode> children = new ArrayList<UITreeNode>();  
    public void addChildren(List<UITreeNode> children) {
		this.children = children;
	}   
    public List<UITreeNode> getChildren() {   
        return this.children;   
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setChildren(List<UITreeNode> children) {
		this.children = children;
	} 
	
	/**
	 * 复制对象属性值，支持不同对象之间的属性值复制.
	 * 
	 * @param src
	 *             复制源.
	 * @param des
	 *             复制目标.
	 */
	public static void copyObjectPropertys(Object src, Object des) {
		//取复制源所有属性字段.
        Field[] srcfields = src.getClass().getDeclaredFields();
        //将复制源的数据复制到复制目标.
		for (Field field : srcfields) {
			final String fieldName = field.getName();
			//复制目标不存在的属性不处理.
			if (!(fieldName.equals("serialVersionUID") || fieldName.equals("ROOT_FLAG"))) {
				Object object = ReflectUtils.getFieldValue(fieldName, src);
				ReflectUtils.setPropertyUtilByName(des, fieldName, object);
			}
		}
	}
} 
