package com.sfxie.ui.extjs5.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sfxie.ui.extjs5.tree.TreeNodeDTO;
import com.sfxie.ui.extjs5.tree.UITreeNode;
import com.sfxie.ui.extjs5.tree.UITreeNodeDecorator;

/**
 * UI组件工具类,用于操作UI组件的数据转换
 * @author xieshengfeng
 * @since 2013-06-21
 */
public class UIComponentUtil {
	/**
	 * 顶层节点标志
	 */
	public static final String ROOT_FLAG = "0"; 
	
//	public static final String PID_FLAG = "0000";
	
	public static final String [] PID_ARRAY = {"0000","0"};
	
	/**
	 * 用于把java树数据对象转化成json树数据对象<br>
	 * @param treeNodeDTOS 树节点list对象,其它默认实现类是UserTreeNodeDTO<br>
	 * @return 返回json对象,用于前台接收<br>
	 */
	/*public static Object transformJavaObjectToJsonObject(List<TreeNodeDTO> treeNodeDTOS){
		Map<String,List<TreeNode>> perParentChildNodes = new HashMap<String,List<TreeNode>> ();				//所有父节点的子节点集合
		Map<String,TreeNode> parentNodes = new HashMap<String,TreeNode> ();									//所有父节点集合
		List<TreeNode> result = new ArrayList<TreeNode>();
		for(TreeNodeDTO treeNodeDTO : treeNodeDTOS){
			if(null==perParentChildNodes.get(treeNodeDTO.getPid())){										 //初始化父节点
				perParentChildNodes.put(treeNodeDTO.getPid(), new ArrayList<TreeNode>());
			}
			TreeNode treeNode = new TreeNode();
			treeNode.setName(treeNodeDTO.getName());
			treeNode.setId(treeNodeDTO.getId());
			treeNode.setPid(treeNodeDTO.getPid());
			treeNode.getInfos().put("email", ((UserTreeNodeDTO)treeNodeDTO).getEmail());  
			if(treeNodeDTO.isParent()){								 									      //获取所有父节点	
				treeNode.setParent(true);
				treeNode.setNocheck(true);
				parentNodes.put(treeNodeDTO.getId(), treeNode);												  //保存父类节点
			}else{
				perParentChildNodes.get(treeNodeDTO.getPid()).add(treeNode);
			}
		}
		for(String p : parentNodes.keySet()){
			if(null!=parentNodes.get(p).getPid() && !(TreeNode.ROOT_FLAG.equals(parentNodes.get(p).getPid()))){
				parentNodes.get(p).addChildren(perParentChildNodes.get(p) == null?new ArrayList<TreeNode>(): perParentChildNodes.get(p));
				if(null!=parentNodes.get(parentNodes.get(p).getPid())){
					parentNodes.get(parentNodes.get(p).getPid())
				    .getChildren().add(parentNodes.get(p));
				}
				
			}else{
				parentNodes.get(p).addChildren(perParentChildNodes.get(p) == null?new ArrayList<TreeNode>(): perParentChildNodes.get(p));
				result.add(parentNodes.get(p));
			}
		}
		return JsonTransformer.transformListToJSONArray(result);
	}*/
	/**
	 * 构造树形结构<br>
	 * @param uITreeNodeDecorator	树节点装潢实现类<br>
	 * @param treeNodeDTOS				树节点数据传输对象<br>
	 * @return
	 */
	public static List<Object> createTree(UITreeNodeDecorator uITreeNodeDecorator,List<TreeNodeDTO> treeNodeDTOS){
		//所有父节点的子节点集合
		Map<String,List<UITreeNode>> perParentChildNodes = new LinkedHashMap<String,List<UITreeNode>> ();		
		//所有父节点集合
		Map<String,UITreeNode> parentNodes = new LinkedHashMap<String,UITreeNode> ();									
		List<Object> result = new ArrayList<Object>();
		for(TreeNodeDTO treeNodeDTO : treeNodeDTOS){
			//初始化父节点
			if(null==perParentChildNodes.get(treeNodeDTO.getPid())){										 
				perParentChildNodes.put(String.valueOf((treeNodeDTO.getPid())), new ArrayList<UITreeNode>());
			}
			UITreeNode treeNode = new UITreeNode();
			treeNode.setText(treeNodeDTO.getName());
			treeNode.setId(String.valueOf(treeNodeDTO.getId()));
			treeNode.setPid(String.valueOf(treeNodeDTO.getPid()));
			//装饰树节点的一些属性，让其具有自己的特点。
			if(null!=uITreeNodeDecorator){
				treeNode = uITreeNodeDecorator.decoracteTreeNode(treeNode,treeNodeDTO);  
			}
			//treeNode.getAttributes().put("email", treeNodeDTO.getEmail());  
			 //获取所有父节点	
			if(treeNodeDTO.getIsParent()){								 									     
				treeNode.setIsParent(true);
				 //保存父类节点
				parentNodes.put(String.valueOf(treeNodeDTO.getId()), treeNode);												 
			}else{
				treeNode.setIsParent(false);
				perParentChildNodes.get(String.valueOf(treeNodeDTO.getPid())).add(treeNode);
			}
			
		}
		for(String p : parentNodes.keySet()){
			if(null!=parentNodes.get(p).getPid() && !(ROOT_FLAG.equals(parentNodes.get(p).getPid()))){
				parentNodes.get(p).getChildren().addAll(perParentChildNodes.get(p) == null?new ArrayList<UITreeNode>(): perParentChildNodes.get(p));
				if(null!=parentNodes.get(parentNodes.get(p).getPid())){
					parentNodes.get(parentNodes.get(p).getPid()).getChildren().add(parentNodes.get(p));
				}
			}else{
				parentNodes.get(p).addChildren(perParentChildNodes.get(p) == null?new ArrayList<UITreeNode>(): perParentChildNodes.get(p));
				result.add(parentNodes.get(p));
			}
		}
		//如果节点全部为父节点时
		if(result.size()<=0){
			for(String p : parentNodes.keySet())
				for(String pid :PID_ARRAY){
					if(parentNodes.get(p).getPid().equals(pid)){
						if(result.contains(parentNodes.get(p)))
							result.remove(parentNodes.get(p));
						result.add(parentNodes.get(p));
						break;
					}
				}
		}
		return result;
	}
	/**
	 * 用于把java树数据对象转化成json树数据对象<br>
	 * @param treeNodeDTOS 树节点list对象,其它默认实现类是UserTreeNodeDTO<br>
	 * @return 返回json对象,用于前台接收<br>
	 */
	public static Object transformJavaObjectToJsonObjectForEasyUITree(UITreeNodeDecorator uITreeNodeDecorator,List<TreeNodeDTO> treeNodeDTOS){
		return JsonTransformer.transformListToJSONArray(createTree(uITreeNodeDecorator,treeNodeDTOS));
	}
	/**
	 * 用于把java树数据对象转化成json树数据对象<br>
	 * @param treeNodeDTOS 树节点list对象,其它默认实现类是UserTreeNodeDTO<br>
	 * @return 返回json对象,用于前台接收<br>
	 */
	public static Object transformJavaObjectToJsonObjectForExtjs4UITree(UITreeNodeDecorator uITreeNodeDecorator,List<TreeNodeDTO> treeNodeDTOS){
		return JsonTransformer.transformListToJSONArray(createTree(uITreeNodeDecorator,treeNodeDTOS));
	}
	/**
	 * 返回具有树形结构的对象
	 * @param uITreeNodeDecorator
	 * @param treeNodeDTOS
	 * @return
	 */
	public static Object createReturnTree(UITreeNodeDecorator uITreeNodeDecorator,List<TreeNodeDTO> treeNodeDTOS){
		return createTree(uITreeNodeDecorator,treeNodeDTOS);
	}
}
