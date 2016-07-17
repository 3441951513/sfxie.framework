package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;


/**
 * 对应html的p标签实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:08:32 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="p")
public class PModel extends HtmlModel{

	@Override
	public String defaultClass() {
		return null;
	}	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
