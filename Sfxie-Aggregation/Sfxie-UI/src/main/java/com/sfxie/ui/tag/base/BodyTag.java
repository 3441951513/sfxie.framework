package com.sfxie.ui.tag.base;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.sfxie.core.context.Context;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.html.model.HtmlModel;
import com.sfxie.ui.component.html.tool.TagHelper;
import com.sfxie.utils.ReflectUtils;

/**
 * 嵌套外层标签抽象基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:53:16 2015年9月25日
 * @example		
 *
 */
public abstract class BodyTag extends BodyTagSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**	模型数据提供者	*/
	private String modelDataProvider;
	/**	模型数据访问者	*/
//	private String htmlModelVisitor;
	/**	模型数据	*/
	protected HtmlModel htmlModel;
	
	/**
	 * @TODO	将所有的tag属性设置到pageContext对象中	
	 *
	 */
	private void setAllSimpleAttributesToPageContext(){
		List<Field> fields = new ArrayList<Field>();
		ReflectUtils.getBeanAllFields(fields, this.getClass(), BodyTag.class);
		for(Field f : fields){
			if(!f.getName().equals("serialVersionUID")){
				pageContext.setAttribute(f.getName(), ReflectUtils.getFieldValue(f.getName(), this));
			}
		}
	}
	
	protected String getContextPath(){
		String contextPath = Context.getContextUrl();
		return contextPath;
	}


	@Override
	public int doStartTag() throws JspException {
		Class<?> cls = null;
		AbstractModelDataProvider dataProvider = null;
//		HtmlModelVisitor modelVisitor = null;
		try {
			cls = Class.forName(modelDataProvider);
			dataProvider = (AbstractModelDataProvider) cls.newInstance();
//			cls = Class.forName(htmlModelVisitor);
//			modelVisitor = (HtmlModelVisitor) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAllSimpleAttributesToPageContext();
		dataProvider.setPageContext(pageContext);
		htmlModel = dataProvider.getModel();
//		if(null!=modelVisitor)
//			htmlModel.setHtmlModelVisitor(modelVisitor);
		Context.setRequest((HttpServletRequest) pageContext.getRequest());
		Context.setResponse((HttpServletResponse) pageContext.getResponse());
		
		try {  
			super.doStartTag();
			HtmlTag htmlTag = htmlModel.getClass().getAnnotation(HtmlTag.class);
			String tagName = htmlTag.name();
			StringBuffer sb = new StringBuffer();
			TagHelper.appendTagStartName(sb,tagName,htmlModel.attributes());
			pageContext.getOut().write(sb.toString());
        } catch (java.io.IOException e) {  
            throw new JspTagException("IO Error: " + e.getMessage());  
        } catch (JspException e) {
			e.printStackTrace();
		}
        return EVAL_BODY_INCLUDE; 
	}
    public int doAfterBody() throws JspTagException {  
		return EVAL_BODY_INCLUDE;  
    }  
  
    public int doEndTag() throws JspTagException {  
        HtmlTag htmlTag = htmlModel.getClass().getAnnotation(HtmlTag.class);
		String tagName = htmlTag.name();
		StringBuffer sb = new StringBuffer();
		TagHelper.appendTagEndName(sb,tagName);
        try {  
        	pageContext.getOut().write(sb.toString()); 
        } catch (java.io.IOException e) {  
            throw new JspTagException("IO Error: " + e.getMessage());  
        }  
        return EVAL_PAGE;  
    }  
	

	/**
	 * 释放资源
	 */
	@Override
	public void release() {
		Context.clearRequestAndResponse();
		super.release();
	}


	public String getModelDataProvider() {
		return modelDataProvider;
	}


	public void setModelDataProvider(String modelDataProvider) {
		this.modelDataProvider = modelDataProvider;
	}

//	public String getHtmlModelVisitor() {
//		return htmlModelVisitor;
//	}
//
//	public void setHtmlModelVisitor(String htmlModelVisitor) {
//		this.htmlModelVisitor = htmlModelVisitor;
//	}

	
}
