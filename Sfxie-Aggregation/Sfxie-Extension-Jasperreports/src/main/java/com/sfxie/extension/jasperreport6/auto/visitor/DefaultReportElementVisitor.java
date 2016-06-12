package com.sfxie.extension.jasperreport6.auto.visitor;


import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRSection;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.VerticalAlignEnum;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.detailfield.combo.TowRowCDF;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFDate;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFDouble;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFFloat;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFInteger;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFLong;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFRowIndex;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.StateStaticMap;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFString;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.state.CDFIntegerState;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
/**
 * 默认的报表表头和数据区域定义访问者
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:48:33 2015年7月28日	
 *
 */
public class DefaultReportElementVisitor implements ReportElementVisitor {

	@Override
	/**
	 * 访问日期类型
	 */
	public void visit(CDFDate detailField,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailField,xpotition);
			JRDesignTextField  textField  = detailField.getDetailTextField();
			textField.setPattern("yyyy-MM-dd");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	//单位为分的,现在除100化为元
	@Override
	public void visit(CDFFloat detailField,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailField,xpotition);
			JRDesignTextField  textField  = detailField.getDetailTextField();
			JRDesignExpression expression = new JRDesignExpression();
			expression.setText("$F{"+ detailField.getFieldName() +"}/100");
			textField.setExpression(expression);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(CDFLong detailField,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailField,xpotition);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(CDFInteger detailField,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailField,xpotition);
		} catch (JRException e) {
			e.printStackTrace();
		}
		JRDesignTextField  textField  = detailField.getDetailTextField();
		//如果是整形状态类型
		if(CDFIntegerState.class.isAssignableFrom(detailField.getClass())){
			String prefix = detailField.getStatePrefixKeyString();
			detailField.setValueDisplayMap(prefix,StateStaticMap.getStateStaticMap());
			JRDesignExpression expression = new JRDesignExpression();
			expression.setText("com.sfxie.extension.jasperreport6.auto.detailfield.single.StateStaticMap.getStateStaticMap().get(\""+prefix+"\"+$F{"+ detailField.getFieldName() +"})");
			textField.setExpression(expression);
		}
	}

	/**
	 * 访问字符串类型
	 */
	@Override
	public void visit(CDFString detailField,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailField,xpotition);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(CDFDouble detailFieldDefinition,Integer xpotition) {
		try {
			generatedColumnAndDetail(detailFieldDefinition,xpotition);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(ReportDefinition reportDefinition,Integer xpotition) {
		
	}

	@Override
	public void visit(ColumnDetailFieldDefinition detailField,Integer xpotition) {
		try {
			//如果是整形状态类型
			if(CDFRowIndex.class.isAssignableFrom(detailField.getClass())){
				generatedColumnAndDetail(detailField,xpotition);
				JRDesignTextField  detailTextField  = detailField.getDetailTextField();
				JRDesignExpression expression = new JRDesignExpression();
				expression.setText("$V{COLUMN_COUNT}");
				detailTextField.setExpression(expression);
			}else if(TowRowCDF.class.isAssignableFrom(detailField.getClass())){
				TowRowCDF comboDetailFieldDefinition = (TowRowCDF) detailField;
				generatedComboColumnAndDetail(comboDetailFieldDefinition,xpotition);
			}
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	private void generatedComboColumnAndDetail(TowRowCDF comboDetailFieldDefinition,Integer xpotition) throws JRException{
		List<ColumnDetailFieldDefinition> list = comboDetailFieldDefinition.getDetailFieldDefinitionList();
		Integer xpotitionInner = xpotition;
		Integer columnHeight = 0;
		
		for(ColumnDetailFieldDefinition detailFieldDefinition : list){
			detailFieldDefinition.setJasperDesign(comboDetailFieldDefinition.getJasperDesign());
			detailFieldDefinition.setReportDefinition(comboDetailFieldDefinition.getReportDefinition());
			generatedColumnAndDetail(detailFieldDefinition, xpotitionInner);
			columnHeight = detailFieldDefinition.getColumnHeight();
			detailFieldDefinition.getHeaderTextField().setHeight(columnHeight);
			detailFieldDefinition.getHeaderTextField().setY(columnHeight);
			xpotitionInner = xpotitionInner+detailFieldDefinition.getColumnWidth();
		}
		
		JRDesignStaticText staticText = new JRDesignStaticText();
		staticText.setText(comboDetailFieldDefinition.getColumnName());
		staticText.setHeight(comboDetailFieldDefinition.getColumnHeight()-columnHeight);
		staticText.setWidth(comboDetailFieldDefinition.getColumnWidth());
		staticText.setX(xpotition);
		staticText.setY(0);
		staticText.setVerticalAlignment(VerticalAlignEnum.MIDDLE);
		staticText.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
		staticText.setStyleNameReference("name");
		JRDesignBand columnHeader = (JRDesignBand) comboDetailFieldDefinition.getJasperDesign().getColumnHeader();
		columnHeader.addElement(staticText);
	}
	
	private void generatedColumnAndDetail(ColumnDetailFieldDefinition detailFieldDefinition,Integer xpotition) throws JRException {
		JasperDesign jasperDesign = detailFieldDefinition.getJasperDesign();
		JRDesignBand columnHeader = (JRDesignBand) jasperDesign.getColumnHeader();
		JRSection jrSection = jasperDesign.getDetailSection();
		JRDesignBand detailBand = (JRDesignBand) ((JRDesignSection)jrSection).getBands()[0];
		// add column headers
		JRDesignStaticText staticText = new JRDesignStaticText();
		staticText.setText(detailFieldDefinition.getColumnName());
//		staticText.setFontSize(columnHeaderfontSize);
		staticText.setHeight(detailFieldDefinition.getColumnHeight());
		staticText.setWidth(detailFieldDefinition.getColumnWidth());
		staticText.setX(xpotition);
		staticText.setVerticalAlignment(VerticalAlignEnum.MIDDLE);
		staticText.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
		staticText.setStyleNameReference("name");
//		staticText.setStyle(thStyle);
		columnHeader.addElement(staticText);
		detailFieldDefinition.setHeaderTextField(staticText);
		if(CDFRowIndex.class.isAssignableFrom(detailFieldDefinition.getClass())){
			;
		}else{
			JRDesignField field = new JRDesignField();
			field.setName(detailFieldDefinition.getFieldName());
			field.setValueClass(detailFieldDefinition.getClazz());
			jasperDesign.addField(field);
		}
	   
		JRDesignTextField textField = new JRDesignTextField();
		detailFieldDefinition.setDetailTextField(textField);
		JRDesignExpression expression = new JRDesignExpression();
		expression.setText("$F{" + detailFieldDefinition.getFieldName() + "}");
		expression.setValueClass(detailFieldDefinition.getClazz());
		textField.setExpression(expression);
//		textField.setFontSize(fontSize);
		textField.setHeight(detailFieldDefinition.getReportDefinition().getDetailHeight());
		textField.setWidth(detailFieldDefinition.getColumnWidth());
		textField.setX(xpotition);
		textField.setVerticalAlignment(VerticalAlignEnum.MIDDLE);
		textField.setHorizontalAlignment(HorizontalAlignEnum.CENTER);
//		textField.setStyle(thStyle);
		textField.setStyleNameReference("name");
		detailBand.addElement(textField);
	   
	   //设置x坐标位置
//		xpotition = xpotition+detailFieldDefinition.getColumnWidth();
		System.out.println(xpotition);
	}

}
