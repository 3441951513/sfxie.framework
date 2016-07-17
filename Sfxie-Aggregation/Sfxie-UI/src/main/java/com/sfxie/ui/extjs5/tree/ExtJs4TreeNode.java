package com.sfxie.ui.extjs5.tree;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author XIESHENGFENG
 * @since 2013-06-21
 */
public class ExtJs4TreeNode extends UITreeNode{
	
	
	private ExtJs4TreeNode root;
	
	private Map<String,Object> attributes = new HashMap<String,Object>();

	private boolean leaf ;

	
	private Object checked = null;
	
	private String cls;
		
	private boolean expanded;
	
	private String icon;
	
	private String iconCls;
		
	public ExtJs4TreeNode getRoot() {
//		if(null==root)
//			this.root =   new ExtJs4TreeNode();
		return root;
	}

	public void setRoot(ExtJs4TreeNode root) {
		this.root = root;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Object isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}
