package com.sfxie.ui.extjs5.tree;



/**
 * 树节点菜单装潢类，主要是为了满足不同树形结构根据各自的特点要求来设置树节点的样式
 *
 * @author XIESHENGFENG <br>
 * @since 2013-06-21
 *
 */
public interface UITreeNodeDecorator {

	/**
	 * 设置树形结构节点样式的方法，实现类必须实现此方法。
	 * @param uiTreeNode
	 */
	public UITreeNode decoracteTreeNode(UITreeNode uiTreeNode,TreeNodeDTO userTreeNodeDTO);
}
