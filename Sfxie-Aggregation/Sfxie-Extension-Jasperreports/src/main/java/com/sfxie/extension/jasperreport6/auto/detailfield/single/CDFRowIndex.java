package com.sfxie.extension.jasperreport6.auto.detailfield.single;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * Integer类型的报表表头和数据区域定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:01:43 2015年7月27日	
 *
 */
public class CDFRowIndex extends ColumnDetailFieldDefinition {

	public CDFRowIndex(String columnName, String fieldName,
			int columnWidth, int columnHeight) {
		super(columnName, fieldName, columnWidth, columnHeight, Integer.class);
	}

	@Override
	public void accept(ReportElementVisitor visitor,Integer xpotition) {
		visitor.visit(this,xpotition);
	}
}
