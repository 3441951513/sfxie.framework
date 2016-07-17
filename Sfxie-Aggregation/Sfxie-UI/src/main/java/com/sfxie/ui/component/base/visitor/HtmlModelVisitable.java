package com.sfxie.ui.component.base.visitor;


public interface HtmlModelVisitable {
	/**
	 * 
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:46:09 2015年9月17日
	 * @param visitor
	 * @return	
	 * 		返回组装后的html字符串
	 *
	 */
	public String accept(HtmlModelVisitor visitor);
}
