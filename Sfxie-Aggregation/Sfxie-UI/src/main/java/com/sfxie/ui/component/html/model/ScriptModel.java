package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;

/**
 * script标签实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:17:34 2015年9月17日
 * @example		
 *
 */
public class ScriptModel extends HtmlModel {

	private String src;
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	
	@Override
	public String defaultClass() {
		return null;
	}	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
