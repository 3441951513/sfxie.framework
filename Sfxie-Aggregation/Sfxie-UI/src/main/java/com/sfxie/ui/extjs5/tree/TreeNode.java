package com.sfxie.ui.extjs5.tree;
import java.util.ArrayList;   
import java.util.HashMap;
import java.util.List;   
import java.util.Map;
/**
 * 树节点类,主要用于树节点生成
 * @author xieshengfeng
 * @since 2013-06-21
 *
 */
public class TreeNode { 
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
     * 节点显示图标
     */
    private String icon;
    /**
     * 节点关闭图标
     */
    private String iconClose;
    /**
     * 节点展开图标
     */
    private String iconOpen;
    /**
     * 节点自定义样式
     */
    private String iconSkin;
    /**
     * 单击节点的链接地址
     */
    private String url;
    /**
     * 单击节点的链接地址的显示区域
     */
    private String target;
    /**
     * 节点是否打开
     */
    private boolean open;
    /**
     * 节点是否可用checkbox
     */
    private boolean checked = false;
    /**
     * 节点是否显示checkbox框
     */
    private boolean nocheck = false;
    /**
     * 子节点
     */
    List<TreeNode> children = new ArrayList<TreeNode>();   
    /**
     * 节点添加的其它信息 
     */
    public Map<Object,Object> infos = new HashMap<Object,Object>();
	
	public TreeNode() {   
    }   
    public TreeNode(String id,String name,String pid,boolean isParent) {   
    	this.id = id;
    	this.name = name;
    	this.pid = pid;
    	this.isParent = isParent;
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
    public void setId(String id) {   
        this.id = id;   
    }   
    public String getId() {   
        return id;   
    }   
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconClose() {
		return iconClose;
	}
	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}
	public String getIconOpen() {
		return iconOpen;
	}
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	public String getIconSkin() {
		return iconSkin;
	}
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean isNocheck() {
		return nocheck;
	}
	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}
	public void addChildren(List<TreeNode> children) {
		this.children = children;
	}   
    public List<TreeNode> getChildren() {   
        return this.children;   
    }   
	public Map<Object, Object> getInfos() {
		return infos;
	}
	public void setInfos(Map<Object, Object> infos) {
		this.infos = infos;
	}
} 
