package com.sfxie.extension.upload.document.excel.visitor;

import com.sfxie.extension.upload.document.excel.CellValueEntity;

/**
 * 被访问者接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:50:29 2015年8月21日
 * @example		
 *
 */
public interface IHeaderDefVisitable {
	/**
	 * 接受访问者的访问
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:15 2015年7月27日
	 * @param visitor	
	 *
	 */
	public String accept(IHeaderDefVisitor visitor);
	/**
	 * 验证单元格值
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:53:31 2015年8月17日
	 * @param visitor
	 * @return	
	 *
	 */
	public boolean validateValue(IHeaderDefVisitor visitor,CellValueEntity cellValueEntity);
}
