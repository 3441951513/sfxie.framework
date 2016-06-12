package com.sfxie.extension.jasperreport6.auto.reprot;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.DefaultReportElementVisitor;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRSection;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseBoxPen;
import net.sf.jasperreports.engine.base.JRBaseLine;
import net.sf.jasperreports.engine.base.JRBaseLineBox;
import net.sf.jasperreports.engine.base.JRBasePrintText;
import net.sf.jasperreports.engine.base.JRBaseStyle;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.type.CalculationEnum;
import net.sf.jasperreports.engine.type.HorizontalAlignEnum;
import net.sf.jasperreports.engine.type.IncrementTypeEnum;
import net.sf.jasperreports.engine.type.LineSpacingEnum;
import net.sf.jasperreports.engine.type.LineStyleEnum;
import net.sf.jasperreports.engine.type.ResetTypeEnum;
import net.sf.jasperreports.engine.type.VerticalAlignEnum;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;

/**
 * 
 *
 */
/**
 * 
 * @TODO	jasperreport报表生成类
 * 			默认字体在src/default.jasperreprots.properties文件中已经设置,如下:
	 				net.sf.jasperreports.default.font.name=\u5B8B\u4F53
					net.sf.jasperreports.default.font.size=10
					net.sf.jasperreports.default.pdf.font.name=STSong-Light
					net.sf.jasperreports.default.pdf.encoding=UniGB-UCS2-H
					net.sf.jasperreports.default.pdf.embedded=true	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:48:03 2015年7月27日	
 *
 */
public class ReportAutoGenerator {
	  public static final java.lang.String FORMAT_PDF = "PDF";
	  public static final java.lang.String FORMAT_XML = "XML";
	  public static final java.lang.String FORMAT_HTML = "HTML";
	  public static final java.lang.String FORMAT_XLS = "XLS";
	  public static final java.lang.String FORMAT_CSV = "CSV";
	  public static final java.lang.String FORMAT_RTF = "RTF";
	  public static final java.lang.String FORMAT_DOC = "DOC";
	  public static final java.lang.String FORMAT_DOCX = "DOCX";
	  public static final java.lang.String FORMAT_XLSX = "XLSX";
	 /** coulumnHeader区域字体大小 */
	  private final static int columnHeaderfontSize = 14;
	 /** detail 区域字体大小 */
	  private final static int fontSize = 12;
	 
	  /**
	   * 生成报表
	   * @TODO	
	   * @author 	xieshengfeng
	   * @email  	xsfcy@126.com
	   * @since 	下午5:48:48 2015年7月27日
	   * @param response
	   * @param reportDefinition
	   * 			主报表定义
	   * @param detailFieldDefinitionList
	   * 			列表头定义
	   * @param dataList
	   * 			数据列表
	   * @throws Exception	
	   *
	   */
	  public static void generatedReport(HttpServletResponse response ,ReportDefinition reportDefinition,List<ColumnDetailFieldDefinition>  detailFieldDefinitionList,
			  List<?> dataList,DefaultReportElementVisitor defaultDetailFieldVisitor) throws Exception{
		String fileName = new String(reportDefinition.getExportName().getBytes("gb2312"), "ISO8859-1")+"."+reportDefinition.getFormat().toLowerCase(); 
      	response.setHeader("Content-disposition","attachment;filename="+ fileName);
		JasperDesign jasperDesign = new JasperDesign();
		initVariables(jasperDesign);
        jasperDesign.setName(reportDefinition.getExportName());
        jasperDesign.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
        Integer[] margin = reportDefinition.getMargin();
//        DefaultReportElementVisitor defaultDetailFieldVisitor = new DefaultReportElementVisitor();
        generatedColumnHeaderAndDetailBand(reportDefinition,jasperDesign,detailFieldDefinitionList,defaultDetailFieldVisitor);
        jasperDesign.setTopMargin(margin[0]);
        jasperDesign.setRightMargin(margin[1]);
        jasperDesign.setBottomMargin(margin[2]);
        jasperDesign.setLeftMargin(margin[3]);
        jasperDesign.setPageWidth(jasperDesign.getPageWidth()+margin[1]+margin[3]);
        jasperDesign.setPageHeight(jasperDesign.getPageHeight()+margin[0]+margin[2]);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JRDataSource dataSource = new JRBeanCollectionDataSource(dataList,false);
        Map<String, Object> parameters = new HashMap<String, Object>();
        JRExporter exporter;
        if (reportDefinition.getFormat().equals(FORMAT_PDF)) {
            response.setContentType("application/pdf");
            exporter = new JRPdfExporter();
        } else if (reportDefinition.getFormat().equals(FORMAT_CSV)) {
            response.setContentType("text/csv");
            exporter = new JRCsvExporter();
        } else if (reportDefinition.getFormat().equals(FORMAT_XLS)) {
            response.setContentType("application/x-octet-stream");
            exporter = new JRXlsExporter();
        }else if (reportDefinition.getFormat().equals(FORMAT_XLSX)) {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            exporter = new JRXlsxExporter();
        } else if (reportDefinition.getFormat().equals(FORMAT_XML)) {
            response.setContentType("text/xml");
            exporter = new JRXmlExporter();
        } else if (reportDefinition.getFormat().equals(FORMAT_RTF)) {
            response.setContentType("application/rtf");
            exporter = new JRRtfExporter();
        } else if(reportDefinition.getFormat().equals(FORMAT_DOCX)){
        	exporter = new JRRtfExporter();
        	response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        }else if(reportDefinition.getFormat().equals(FORMAT_DOC)){
        	exporter = new JRRtfExporter();
        	response.setContentType("application/msword");
        } else {
            throw new ServletException("Unknown report format: " + reportDefinition.getFormat());
        }
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        byte[] output = exportReportToBytes(jasperPrint, exporter);
        writeReport(response,output);
	}
	/**
     * Writes report bytes to response output stream.
     *
     * @param response Current response.
     * @param output   Report bytes to write.
     * @throws ServletException on stream IOException.
     */
    private static void writeReport(HttpServletResponse response, Object output) throws ServletException {
        ServletOutputStream outputStream = null;
        try {
        	outputStream = response.getOutputStream();
            outputStream.write((byte[])output);
            outputStream.flush();
        } catch (IOException e) {
            throw new ServletException(e.getMessage(), e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                throw new ServletException(e.getMessage(), e);
            }
        }
    }
    /**
     * 生成列表头和数据区域
     * @TODO	
     * @author 	xieshengfeng
     * @email  	xsfcy@126.com
     * @since 	下午5:49:42 2015年7月27日
     * @param jasperDesign
     * @param detailFieldDefinitionList
     * @throws JRException	
     *
     */
	private static void generatedColumnHeaderAndDetailBand(ReportDefinition reportDefinition,JasperDesign jasperDesign,List<ColumnDetailFieldDefinition>  detailFieldDefinitionList,
			DefaultReportElementVisitor defaultDetailFieldVisitor) throws JRException{
		//忽略分页
		jasperDesign.setIgnorePagination(true);
		//添加columnHeader区域
		JRDesignBand columnHeader = new JRDesignBand();
		JRDesignBand detailBand = new JRDesignBand();
		jasperDesign.setColumnHeader(columnHeader);
		//添加detail区域
		JRSection jrSection = jasperDesign.getDetailSection();
		((JRDesignSection)jrSection).addBand(detailBand);
		
		JRStyle thStyle = new JRBaseStyle("name");
		Color bgColor = new Color(176,176,176);
		Color foreColor = new Color(111,120,176);
		thStyle.setBackcolor(bgColor);
		thStyle.setForecolor(foreColor);
//		thStyle.setFontName("宋体");
		thStyle.setBold(true);
//		thStyle.setMode(ModeEnum.OPAQUE);
		thStyle.setLineSpacing(LineSpacingEnum.SINGLE);
//		JRBaseLineBox thJRBaseLineBox = new JRBaseLineBox(thStyle);
//		JRBaseBoxPen thJRBaseBoxPen = new JRBaseBoxPen(thJRBaseLineBox);
//		thJRBaseBoxPen.setLineWidth(1l);
		thStyle.getLineBox().getPen().setLineWidth(0.5F);
		thStyle.getLineBox().getPen().setLineStyle(LineStyleEnum.SOLID);
		thStyle.getLineBox().getPen().setLineColor(bgColor);
		jasperDesign.addStyle(thStyle);
		Integer tatolWidth = 0;
		Integer headHeight = 0 ;
//		Integer detailHeight = 0 ;
		Integer xpotition = 0;
		for(ColumnDetailFieldDefinition detailFieldDefinition : detailFieldDefinitionList){
			if(detailFieldDefinition.getColumnHeight()>headHeight){
				headHeight = detailFieldDefinition.getColumnHeight();
			}
//			if(detailFieldDefinition.getColumnHeight()<detailHeight || detailHeight == 0)
//				detailHeight = detailFieldDefinition.getColumnHeight();
			detailFieldDefinition.setReportDefinition(reportDefinition);
			detailFieldDefinition.setJasperDesign(jasperDesign);
			detailFieldDefinition.accept(defaultDetailFieldVisitor,xpotition);
			xpotition = xpotition+detailFieldDefinition.getColumnWidth();
			tatolWidth += detailFieldDefinition.getColumnWidth();
		   //设置x坐标位置
		}
		columnHeader.setHeight(headHeight);
		detailBand.setHeight(reportDefinition.getDetailHeight());
		jasperDesign.setPageWidth(tatolWidth);
	}
	/*private static void resetHeaderHieght(List<DetailFieldDefinition>  detailFieldDefinitionList){
		for(DetailFieldDefinition detailFieldDefinition : detailFieldDefinitionList){
			
		}
	}*/
	private static void initVariables(JasperDesign jasperDesign) throws JRException{
		/*JRDesignVariable variable = new JRDesignVariable();
		variable.setName("ROW_INDEX");
		variable.setIncrementType(IncrementTypeEnum.COLUMN);
		variable.setValueClass(Integer.class);
		variable.setResetType(ResetTypeEnum.NONE);
		variable.setCalculation(CalculationEnum.COUNT);
		JRDesignExpression expression = new JRDesignExpression();
		expression.setText("1");
		expression.setValueClass(Integer.class);
		variable.setInitialValueExpression(expression);
		jasperDesign.addVariable(variable);*/
	}
	public static void main(String[] args) {
		/*try {
			dyncReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	 private static String exportReportToStringBuffer(JasperPrint jasperPrint, JRExporter exporter) throws JRException {
        StringBuffer sb = new StringBuffer();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sb);
        exporter.exportReport();
        return sb.toString();
    }
	 /**
	     * Run a Jasper report to CSV format and put the results in a byte array
	     *
	     * @param jasperPrint The Print object to render as CSV
	     * @param exporter    The exporter to use to export the report
	     * @return A CSV formatted report
	     * @throws net.sf.jasperreports.engine.JRException
	     *          If there is a problem running the report
	     */
    private static byte[] exportReportToBytes(JasperPrint jasperPrint, JRExporter exporter) throws JRException {
        byte[] output;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

        exporter.exportReport();

        output = baos.toByteArray();

        return output;
    }
}
