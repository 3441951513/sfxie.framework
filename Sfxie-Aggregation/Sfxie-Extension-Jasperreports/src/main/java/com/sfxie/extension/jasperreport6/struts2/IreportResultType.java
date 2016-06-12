package com.sfxie.extension.jasperreport6.struts2;


/**
 * strus返回处理
 */
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;








import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.views.jasperreports.JasperReportConstants;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sfxie.advert.common.spring.datasource.multy.DBContextHolder;
import com.sfxie.advert.common.util.JsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public class IreportResultType extends CmimsJasperReportsResult{

	private static final long serialVersionUID = 7069627427377445753L;

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1) throws Exception {
		
		ReportAction action = (ReportAction)arg1.getAction();
		
		ActionContext actionContext =  arg1.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST); 
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		
		IReportEntity iReportEntity = action.getIreportEntity();
		
		if (null == action.getIreportEntity().getFormat())
			setFormat(JasperReportConstants.FORMAT_HTML);
		else
			setFormat(action.getIreportEntity().getFormat());
//		setDataSource( null != iReportEntity.getDataSource() ? iReportEntity.getDataSource() : "dataSource");
		setExportParameters(iReportEntity.getExportParameters());
		setReportParameters(iReportEntity.getReportParameters());
		
		arg1.getStack().set("fileName",iReportEntity.getFileName());
		//如果设置是jdbc数据源，则设置数据源有效，之前设置的java list数据源无效
		if(null != iReportEntity.getConnectionDataSource()){
			setConnection("ireport_connection");
			arg1.getStack().set("ireport_connection", DataSourceUtils.getConnection(
					((DataSource)webApplicationContext.getBean(iReportEntity.getConnectionDataSource()))));
		}else{
			setDataSource("ireport_datasource");
			Object data = arg1.getStack().findValue(null!=iReportEntity.getDataSource()?iReportEntity.getDataSource():"collectionDataSource");
			arg1.getStack().set("ireport_datasource", data);
		}
		try{
			super.doExecute(iReportEntity.getLocation(), arg1);
			DBContextHolder.clearDbType();
			if(null!=action.getDownloadTag() && !action.getDownloadTag().equals("0")){
				downloadStatus(action,"2",arg1);
			}
		}catch(Exception e){
			if(null!=action.getDownloadTag() ){
				downloadStatus(action,"1",arg1);
			}
			e.printStackTrace();
		}
	}
	/**
	 * 回写下载状态
	 * xsf
	 * 2015年7月7日上午10:44:58
	 * TODO
	 * void
	 */
	private void downloadStatus(ReportAction action,String status,ActionInvocation invocation) throws Exception {
		HttpSession  session  = ServletActionContext.getRequest().getSession();
		String downloadTag = action.getDownloadTag();
		ReportDownloadStatus reportDownloadStatus = (ReportDownloadStatus) session.getAttribute(downloadTag);
		reportDownloadStatus.setState(status);
    }
	protected void setHtmlExportParameterMap(ActionInvocation invocation,JRExporter exporter){
		ReportAction action = (ReportAction)invocation.getAction();
		exporter.setParameter(JRExporterParameter.PAGE_INDEX, Integer.valueOf(2));
	}
	
	protected void setPdfExportParameterMap(ActionInvocation invocation,JRExporter exporter){
	}
}
