package com.sfxie.extension.jasperreport6.auto.struts2;

import java.util.List;

import com.sfxie.advert.common.base.BaseAction;
import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.DefaultReportElementVisitor;
/**
 * 拥有根据数据和报表定义自动生成报表的action
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:50:10 2015年7月27日	
 *
 */
public class AutoJasperAction  extends BaseAction {
	
	private Boolean exportAll;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**	数据列表	*/
	private List<?> autoJasperDataList ;
	/**	报表表头定义列表	*/
	private List<ColumnDetailFieldDefinition> autoJasperDetailFieldList ;
	/**	报表定义	*/
	private ReportDefinition autoJasperReportDefinition;
	
	private DefaultReportElementVisitor reportElementVisitor;
	
	public List<?> getAutoJasperDataList() {
		return autoJasperDataList;
	}
	public void setAutoJasperDataList(List<?> autoJasperDataList) {
		this.autoJasperDataList = autoJasperDataList;
	}
	public List<ColumnDetailFieldDefinition> getAutoJasperDetailFieldList() {
		return autoJasperDetailFieldList;
	}
	public void setAutoJasperDetailFieldList(
			List<ColumnDetailFieldDefinition> autoJasperDetailFieldList) {
		this.autoJasperDetailFieldList = autoJasperDetailFieldList;
	}
	public ReportDefinition getAutoJasperReportDefinition() {
		return autoJasperReportDefinition;
	}
	public void setAutoJasperReportDefinition(
			ReportDefinition autoJasperReportDefinition) {
		this.autoJasperReportDefinition = autoJasperReportDefinition;
	}
	public DefaultReportElementVisitor getReportElementVisitor() {
		if(null==reportElementVisitor)
			reportElementVisitor = new DefaultReportElementVisitor();
		return reportElementVisitor;
	}
	public void setReportElementVisitor(
			DefaultReportElementVisitor reportElementVisitor) {
		this.reportElementVisitor = reportElementVisitor;
	}
	public Boolean getExportAll() {
		return exportAll;
	}
	public void setExportAll(Boolean exportAll) {
		this.exportAll = exportAll;
	}
	
	
}
