package com.sfxie.ui.component.base.model;

import javax.servlet.ServletContext;
import javax.servlet.jsp.PageContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 标签数据提供者抽象类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:47:10 2015年9月25日
 * @example		
 *
 */
public abstract class AbstractModelDataProvider implements IModelDataProvider{
	
	protected PageContext pageContext ;

	/**
	 * 
	 * @TODO  获取tag的属性值	
	 * @param name
	 * @return	
	 *
	 */
	protected Object getAttribute(String name){
		return pageContext.getAttribute(name);
	}
	protected PageContext getPageContext() {
		return pageContext;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
	/**
	 * 获取spring上下文
	 * @TODO	
	 * @return	
	 *
	 */
	protected WebApplicationContext getWebApplicationContext(){
		ServletContext servletContext = pageContext.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext); 
		return wac;
	}

	/**
	 * 获取spring上下文的bean
	 * @param name
	 * @return	
	 *
	 */
	protected Object getBeanByName(String name){
		return getWebApplicationContext().getBean(name);
	}
	/**
	 * 获取spring上下文的bean
	 * @param clazz
	 * @return	
	 *
	 */
	protected <T> Object getBeanByClass(Class<T> clazz){
		return getWebApplicationContext().getBean(clazz);
	}
}
