package com.sfxie.extension.jasperreport6.auto.detailfield.single;

import java.util.Date;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;


public class CDFDate extends ColumnDetailFieldDefinition{

	public CDFDate(String columnName, String fieldName,
			int columnWidth, int columnHeight) {
		super(columnName, fieldName, columnWidth, columnHeight, Date.class);
	}

	@Override
	public void accept(ReportElementVisitor visitor,Integer xpotition) {
		visitor.visit(this,xpotition);
	}
}
