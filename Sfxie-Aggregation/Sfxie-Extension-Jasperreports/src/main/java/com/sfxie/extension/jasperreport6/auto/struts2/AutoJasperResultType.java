package com.sfxie.extension.jasperreport6.auto.struts2;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportAutoGenerator;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
import com.opensymphony.xwork2.ActionInvocation;
/**
 * 自定义的struts2的result类型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午9:11:40 2015年7月28日	
 *
 */
public class AutoJasperResultType extends StrutsResultSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		List<?> autoJasperDataList = (List<?>) invocation.getStack().findValue("autoJasperDataList");
		List<ColumnDetailFieldDefinition> autoJasperDetailFieldList = (List<ColumnDetailFieldDefinition>) invocation.getStack().findValue("autoJasperDetailFieldList");
		ReportDefinition autoJasperReportDefinition = (ReportDefinition) invocation.getStack().findValue("autoJasperReportDefinition");
		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		AutoJasperAction action = (AutoJasperAction) invocation.getAction();
		ReportAutoGenerator.generatedReport(response, autoJasperReportDefinition, autoJasperDetailFieldList, autoJasperDataList,action.getReportElementVisitor());
	}

}
