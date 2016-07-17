package com.sfxie.ui.tag.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.html.model.HtmlModel;
import com.sfxie.utils.ReflectUtils;

public abstract class SimpleTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	/** 模型数据提供者 */
	private String modelDataProvider;
	/** 模型数据访问者 */
	private String htmlModelVisitor;
	/** 模型数据 */
	protected HtmlModel htmlModel;

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().write(html());
		} catch (Exception e) {
			e.printStackTrace();
			return super.doStartTag();
		}
		return super.doEndTag();
	}

	/**
	 * @TODO 将所有的tag属性设置到pageContext对象中
	 *
	 */
	private void setAllSimpleAttributesToPageContext() {
		List<Field> fields = new ArrayList<Field>();
		ReflectUtils.getBeanAllFields(fields, this.getClass(), SimpleTag.class);
		for (Field f : fields) {
			if (!f.getName().equals("serialVersionUID")) {
				pageContext.setAttribute(f.getName(),
						ReflectUtils.getFieldValue(f.getName(), this));
			}
		}
	}

	public abstract String html() throws Exception;

	protected String getContextPath() {
//		String contextPath = Context.getContextUrl();
		String contextPath = "";
		return contextPath;
	}

	@Override
	public int doStartTag() throws JspException {
		Class<?> cls = null;
		AbstractModelDataProvider dataProvider = null;
		HtmlModelVisitor modelVisitor = null;
		try {
			cls = Class.forName(modelDataProvider);
			dataProvider = (AbstractModelDataProvider) cls.newInstance();
			cls = Class.forName(htmlModelVisitor);
			modelVisitor = (HtmlModelVisitor) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAllSimpleAttributesToPageContext();
		dataProvider.setPageContext(pageContext);
		htmlModel = dataProvider.getModel();
		if (null != modelVisitor)
			htmlModel.setHtmlModelVisitor(modelVisitor);
		Context.setRequest((HttpServletRequest) pageContext.getRequest());
		Context.setResponse((HttpServletResponse) pageContext.getResponse());
		// System.out.println(Thread.currentThread());
		return super.doStartTag();
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

	public String getHtmlModelVisitor() {
		return htmlModelVisitor;
	}

	public void setHtmlModelVisitor(String htmlModelVisitor) {
		this.htmlModelVisitor = htmlModelVisitor;
	}

}
