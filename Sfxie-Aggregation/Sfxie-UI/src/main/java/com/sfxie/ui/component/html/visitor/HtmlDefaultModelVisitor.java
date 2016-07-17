package com.sfxie.ui.component.html.visitor;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.html.model.HtmlModel;
import com.sfxie.ui.component.html.tool.TagHelper;

public class HtmlDefaultModelVisitor implements HtmlModelVisitor {

	@Override
	public String visit(HtmlModel model) {
		String result = visitMode(model);
		return result;
	}

	
	/**
	 * 访问HtmlModel并且生成html标签字符串
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:21:34 2015年9月18日
	 * @param model
	 * @return	
	 *
	 */
	protected String visitMode(HtmlModel model){
		HtmlTag htmlTag = model.getClass().getAnnotation(HtmlTag.class);
		String tagName = null;
		if(null!=htmlTag)
			tagName = htmlTag.name();
//		if(tagName.equals("")){
//			tagName =  model.getTagName();
//		}
		StringBuffer sb = new StringBuffer();
		if(null!=htmlTag)
			TagHelper.appendTagStartName(sb,tagName,model.attributes());
		sb.append(model.content());
		if(null!=htmlTag)
			TagHelper.appendTagEndName(sb,tagName);
		return sb.toString();
	}
}
