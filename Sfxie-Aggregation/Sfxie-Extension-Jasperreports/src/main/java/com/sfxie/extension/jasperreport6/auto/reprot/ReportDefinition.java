package com.sfxie.extension.jasperreport6.auto.reprot;

import net.sf.jasperreports.engine.design.JasperDesign;

import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitable;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * 报表定义类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:50:01 2015年7月28日	
 *
 */
public class ReportDefinition implements ReportElementVisitable{
	/**	导出文档的名称		*/
	private String exportName;
	/**	导出文档的类型:doc,docx,xls,xlsx,pdf等*/
	private String format;
	/**	报表对象	*/
	private JasperDesign jasperDesign;
	/**	是否自动生成序号	*/
	private boolean rowIndex;
	/**	数据列区域高度*/
	private Integer detailHeight;
	
	/**
	 * 报表边距:上,右,下,左<br>
	 * 默认都为0
	 */
	private Integer [] margin = new Integer[]{0,0,0,0};

	
	
	public ReportDefinition(String exportName, String format) {
		this.exportName = exportName;
		this.format = format;
	}
	public ReportDefinition(String exportName, String format,int detailHeight) {
		this.exportName = exportName;
		this.format = format;
		this.detailHeight = detailHeight;
	}
	public ReportDefinition(String exportName, String format,boolean rowIndex) {
		this.exportName = exportName;
		this.format = format;
		this.rowIndex = rowIndex;
	}
	public ReportDefinition(String exportName, String format,int detailHeight ,boolean rowIndex) {
		this.exportName = exportName;
		this.format = format;
		this.rowIndex = rowIndex;
		this.detailHeight = detailHeight;
	}
	public String getExportName() {
		return exportName;
	}

	public void setExportName(String exportName) {
		this.exportName = exportName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer[] getMargin() {
		return margin;
	}

	public void setMargin(Integer[] margin) {
		this.margin = margin;
	}

	public JasperDesign getJasperDesign() {
		return jasperDesign;
	}

	public void setJasperDesign(JasperDesign jasperDesign) {
		this.jasperDesign = jasperDesign;
	}

	@Override
	public void accept(ReportElementVisitor visitor,Integer xpotition) {
		visitor.visit(this,xpotition);
	}

	public boolean isRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(boolean rowIndex) {
		this.rowIndex = rowIndex;
	}
	public Integer getDetailHeight() {
		if(null==detailHeight)
			detailHeight = 20;
		return detailHeight;
	}
	public void setDetailHeight(Integer detailHeight) {
		this.detailHeight = detailHeight;
	}
	
	
}
