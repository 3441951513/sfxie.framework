package com.sfxie.extension.jasperreport6.auto.detailfield.combo;

import java.util.ArrayList;
import java.util.List;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * 组合报表表头和数据区域定义,两行类型定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:29:43 2015年7月28日	
 *
 */
public class TowRowCDF extends ColumnDetailFieldDefinition {

	
	private List<ColumnDetailFieldDefinition> detailFieldDefinitionList;
	
	@Override
	public void accept(ReportElementVisitor visitor, Integer xpotition) {
		visitor.visit(this, xpotition);
	}

	public TowRowCDF(String columnName,int columnWidth,
			int columnHeight,ColumnDetailFieldDefinition... detailFieldDefinitions){
		this.setColumnName(columnName);
		this.setColumnWidth(columnWidth);
		this.setColumnHeight(columnHeight);
		List<ColumnDetailFieldDefinition> list = getDetailFieldDefinitionList();
		for(ColumnDetailFieldDefinition detailFieldDefinition : detailFieldDefinitions){
			list.add(detailFieldDefinition);
		}
	}

	public List<ColumnDetailFieldDefinition> getDetailFieldDefinitionList() {
		if(null==detailFieldDefinitionList)
			detailFieldDefinitionList = new ArrayList<ColumnDetailFieldDefinition>();
		return detailFieldDefinitionList;
	}

	public void setDetailFieldDefinitionList(
			List<ColumnDetailFieldDefinition> detailFieldDefinitionList) {
		this.detailFieldDefinitionList = detailFieldDefinitionList;
	}
	
	
}
