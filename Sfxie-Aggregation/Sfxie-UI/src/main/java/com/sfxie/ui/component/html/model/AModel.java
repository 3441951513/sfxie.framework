package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;

/**
 * 对应html的a标签实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:08:32 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="a")
public class AModel extends HtmlModel{

	
	private String href;
	
	@HtmlAttribute(value="#")
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
