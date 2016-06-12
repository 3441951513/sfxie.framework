package com.sfxie.extension.jasperreport6.struts2.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * ireprot报表和easyui表格datagrid控件结合使用的标签
 * @TODO 
 * @author xsf
 * 2015年6月30日下午4:01:56
 * {@link com.sfxie.report.tag.IReportTag}
 */
public class IReportTag extends ComponentTagSupport {
	private static final long serialVersionUID = 432308349113743852L;

	/**	查询条件表单id	*/
	private String queryFormId;
	/**	报表模块的处理前的处理接口 ({@link com.sfxie.report.IReportPreDealer})*/
	private String reportDealer;
	/**	页面北边区域的style属性	*/
	private String northStyle;
	/**	页面北边区域内查询区域的style属性	*/
	private String queryAreaStyle;
	/**	页面北边区域内分页栏区域的style属性	*/
	private String paginationAreaStyle;
	
	/**	页面北边区域内分页栏区域的style属性	*/
	private String autoQuery;
    
	private String retrunPageUrl;
	
	public Component getBean(ValueStack arg0, HttpServletRequest arg1,
			HttpServletResponse arg2) {
		String contextPath = arg1.getContextPath();
		IReportComponent reportComponent = new IReportComponent(arg0);
		reportComponent.setContextPath(contextPath);
		reportComponent.setQueryFormId(queryFormId);
		reportComponent.setReportDealer(reportDealer);
		reportComponent.setQueryAreaStyle(queryAreaStyle);
		reportComponent.setNorthStyle(northStyle);
		reportComponent.setPaginationAreaStyle(paginationAreaStyle);
		reportComponent.setAutoQuery(autoQuery);
		reportComponent.setRetrunPageUrl(retrunPageUrl);
		return reportComponent;
	}
	
    protected void populateParams() {
        super.populateParams();

    }

	public String getQueryFormId() {
		return queryFormId;
	}

	public void setQueryFormId(String queryFormId) {
		this.queryFormId = queryFormId;
	}

	public String getReportDealer() {
		return reportDealer;
	}

	public void setReportDealer(String reportDealer) {
		this.reportDealer = reportDealer;
	}

	public String getNorthStyle() {
		return northStyle;
	}

	public void setNorthStyle(String northStyle) {
		this.northStyle = northStyle;
	}

	public String getQueryAreaStyle() {
		return queryAreaStyle;
	}

	public void setQueryAreaStyle(String queryAreaStyle) {
		this.queryAreaStyle = queryAreaStyle;
	}

	public String getPaginationAreaStyle() {
		return paginationAreaStyle;
	}

	public void setPaginationAreaStyle(String paginationAreaStyle) {
		this.paginationAreaStyle = paginationAreaStyle;
	}

	public String getAutoQuery() {
		return autoQuery;
	}

	public void setAutoQuery(String autoQuery) {
		this.autoQuery = autoQuery;
	}

	public String getRetrunPageUrl() {
		return retrunPageUrl;
	}

	public void setRetrunPageUrl(String retrunPageUrl) {
		this.retrunPageUrl = retrunPageUrl;
	}
    
}