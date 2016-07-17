package com.sfxie.ui.component.html.model;

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
public class StringModel extends HtmlModel{
	public StringModel( ){
	}
	public StringModel(String content){
		this.setContent(content);
	}
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
