package com.sfxie.extension.jasperreport6.struts2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRQuery;
import net.sf.jasperreports.engine.JRQueryChunk;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import ognl.Ognl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.jasperreports.JasperReportConstants;
import org.apache.struts2.views.jasperreports.JasperReportsResult;
import org.apache.struts2.views.jasperreports.ValueStackShadowMap;

import com.sfxie.advert.common.util.DateHelper;
import com.sfxie.advert.common.util.JsonUtils;
import com.sfxie.advert.common.util.SpringPropertyPlaceholderConfigurer;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class CmimsJasperReportsResult extends JasperReportsResult implements JasperReportConstants {
	public static final String FORMAT_DOC = "DOC";
	public static final String FORMAT_DOCX = "DOCX";
	public static final String FORMAT_XLSX = "XLSX";
	private static final long serialVersionUID = -2523174799621182907L;
    private final static Logger LOG = LoggerFactory.getLogger(CmimsJasperReportsResult.class);

    protected void doExecute(String stencilName, ActionInvocation invocation) throws Exception {
        // Will throw a runtime exception if no "datasource" property. TODO Best place for that is...?
    	ReportAction action = (ReportAction)invocation.getAction();
        initializeProperties(invocation);

        format = format.toUpperCase();
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating JasperReport for dataSource = " + dataSource + ", format = " + format);
        }

        HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
//        response.setCharacterEncoding("utf-8");

        String dirPath = request.getSession().getServletContext().getRealPath("/")+SpringPropertyPlaceholderConfigurer.getContextProperty("reportTemplatePath");
        // Handle IE special case: it sends a "contype" request first.
        // TODO Set content type to config settings?
        if ("contype".equals(request.getHeader("User-Agent"))) {
            try {
                response.setContentType("application/pdf");
                response.setContentLength(0);

                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.close();
            } catch (IOException e) {
                LOG.error("Error writing report output", e);
                throw new ServletException(e.getMessage(), e);
            }
            return;
        }

        // Construct the data source for the report.
        ValueStack stack = invocation.getStack();
//        ValueStackDataSource stackDataSource = null;
        JRDataSource jrdataSource = null;

        Connection conn = (Connection) stack.findValue(connection);
        if (conn == null)
//            stackDataSource = new ValueStackDataSource(stack, dataSource);
        	jrdataSource =  new JRBeanCollectionDataSource((Collection<?>) stack.findValue(dataSource));

        // Determine the directory that the report file is in and set the reportDirectory parameter
        // For WW 2.1.7:
        //  ServletContext servletContext = ((ServletConfig) invocation.getInvocationContext().get(ServletActionContext.SERVLET_CONFIG)).getServletContext();
//        ServletContext ervletContext = (ServletContext) invocation.getInvocationContext().get(ServletActionContext.SERVLET_CONTEXT);
//        String systemId = servletContext.getRealPath(finalLocation);
        String systemId = dirPath + stencilName;
        Map parameters = new ValueStackShadowMap(stack);
//        File directory = new File(systemId.substring(0, systemId.lastIndexOf(File.separator)));
        File directory = new File(dirPath);
        parameters.put("reportDirectory", directory);
        parameters.put(JRParameter.REPORT_LOCALE, invocation.getInvocationContext().getLocale());
        parameters.put("SUBREPORT_DIR", dirPath);
        
        //设置是否忽略分页
        if (null!=action.getParamMap().get("isIgnorePage") && new Boolean(action.getParamMap().get("isIgnorePage")) ) {
        	parameters.put("IS_IGNORE_PAGINATION", Boolean.TRUE);
        }
        
        
        // put timezone in jasper report parameter
        if (timeZone != null) {
            timeZone = conditionalParse(timeZone, invocation);
            final TimeZone tz = TimeZone.getTimeZone(timeZone);
            if (tz != null) {
                // put the report time zone
                parameters.put(JRParameter.REPORT_TIME_ZONE, tz);
            }
        }

        // Add any report parameters from action to param map.
        Map reportParams = (Map) stack.findValue(reportParameters);
        if (reportParams != null) {
            if (LOG.isDebugEnabled()) {
        	LOG.debug("Found report parameters; adding to parameters...");
            }
            parameters.putAll(reportParams);
        }

        byte[] output;
        JasperPrint jasperPrint;

        // Fill the report and produce a print object
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(systemId));
        IReportEntity ireportEntity = action.getIreportEntity();
        
        if(null!=conn)
        	generateTotalCount(jasperReport,parameters,ireportEntity,conn); 
        
        if(action.getExportDataType().equals("all")){
        	parameters.put("pagesize",ireportEntity.getTotal() );
        }else{
        	parameters.put("pagesize",action.getPageSize());
        }
        try {
            if (conn == null)
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrdataSource);
            else
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
        } catch (Exception e) {
        	e.printStackTrace();
            LOG.error("Error building report for uri " + systemId, e);
            throw new ServletException(e.getMessage(), e);
        }
        // Export the print object to the desired output format
        try {
            if (contentDisposition != null || documentName != null) {
                final StringBuffer tmp = new StringBuffer();
                tmp.append((contentDisposition == null) ? "inline" : contentDisposition);

                if (documentName != null) {
                    tmp.append("; filename=");
                    tmp.append(documentName);
                    tmp.append(".");
                    tmp.append(format.toLowerCase());
                }

                response.setHeader("Content-disposition", tmp.toString());
            }
            
            String fileName = "";
            if(StringUtils.isNotEmpty(stack.findString("fileName"))){
              /*fileName = 	stack.findString("fileName");
              if(!com.sfxie.advert.common.util.StringUtils.isChinese(fileName)){
            	  fileName = new String(stack.findString("fileName").getBytes("gb2312"), "ISO8859-1"); 
              }
              fileName = fileName +"."+format.toLowerCase();*/
              fileName = new String(stack.findString("fileName").getBytes("gb2312"), "ISO8859-1")+"."+format.toLowerCase(); 
          	  response.setHeader("Content-disposition",
          			  "attachment;filename="+ fileName);
          	  
            }
            
            JRExporter exporter;

            if (format.equals(FORMAT_PDF)) {
                response.setContentType("application/pdf");
                exporter = new JRPdfExporter();
            } else if (format.equals(FORMAT_CSV)) {
                response.setContentType("text/csv");
                exporter = new JRCsvExporter();
            } else if (format.equals(FORMAT_HTML)) {
//                response.setContentType("text/html");
            	response.setContentType("application/json;charset=utf-8");

                // IMAGES_MAPS seems to be only supported as "backward compatible" from JasperReports 1.1.0

                Map imagesMap = new HashMap();
                request.getSession(true).setAttribute("IMAGES_MAP", imagesMap);

//                exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");
//                exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, "");
//                exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
//                exporter.setParameter(JRHtmlExporterParameter.IMAGES_DIR_NAME,outPutDir);
//                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,sourceDir); 
//                System.out.println(request.getContextPath()+": "+request.getContextPath());
                exporter = new JRHtmlExporter();
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + imageServletUrl);

                // Needed to support chart images:
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                if (null==action.getParamMap().get("isIgnorePage") || !new Boolean(action.getParamMap().get("isIgnorePage")) ) {
                	setHtmlExportParameterMap(invocation,exporter);
                }
                request.getSession().setAttribute("net.sf.jasperreports.j2ee.jasper_print", jasperPrint);
            } else if (format.equals(FORMAT_XLS)) {
                response.setContentType("application/x-octet-stream");
                exporter = new JRXlsExporter();
            }else if (format.equals(FORMAT_XLSX)) {
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                exporter = new JRXlsxExporter();
            } else if (format.equals(FORMAT_XML)) {
                response.setContentType("text/xml");
                exporter = new JRXmlExporter();
            } else if (format.equals(FORMAT_RTF)) {
                response.setContentType("application/rtf");
                exporter = new JRRtfExporter();
            } else if(format.equals(FORMAT_DOCX)){
            	exporter = new JRRtfExporter();
            	response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.template");
//        		response.setHeader("Content-disposition", "attachment; filename="
//        				+ fileName.replace(".word", "")+".docx");
            }else if(format.equals(FORMAT_DOC)){
            	exporter = new JRRtfExporter();
            	response.setContentType("application/msword");
//        		response.setHeader("Content-disposition", "attachment; filename="
//        				+ fileName.replace(".word", "")+".doc");
            } else {
                throw new ServletException("Unknown report format: " + format);
            }

            Map exportParams = (Map) stack.findValue(exportParameters);
            if (exportParams != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Found export parameters; adding to exporter parameters...");
                }
                exporter.getParameters().putAll(exportParams);
            }
            
            if(format.equals(FORMAT_HTML)){
            	String data = exportReportToStringBuffer(jasperPrint, exporter);
        		writeReport(format,action,response, data);
            }else{
            	 if(null!=reportParams.get("saveInLocal") && reportParams.get("saveInLocal").equals("true")){
                 	String saveInLocalPath = "D:\\golive\\report\\excel\\";
                 	fileName = 	stack.findString("fileName")+"."+format.toLowerCase();
                 	File fs  = new File(saveInLocalPath+fileName);
                 	output = exportReportToBytes(jasperPrint, exporter);
             	    FileUtils.writeByteArrayToFile(fs, output);
                 }else{
                	 output = exportReportToBytes(jasperPrint, exporter);
                	 try{
                		 writeReport(format,action,response, output);
                	 }catch(Exception e){
                		 e.printStackTrace();
                	 }
                 }
            }
        } catch (JRException e) {
            String message = "Error producing " + format + " report for uri " + systemId;
            LOG.error(message, e);
            e.printStackTrace();
            throw new ServletException(e.getMessage(), e);
        }catch(Exception e){
        	e.printStackTrace();
        }finally{
        	if(conn != null && !conn.isClosed()){
        		try{
        			conn.close();
        			//显示调用内存回收,并不能保证内存回收一定执行
//        			Runtime.getRuntime().gc();
//        			System.gc();
        		}catch(Exception e){
        			e.printStackTrace();
        		}
        	}
        		
        }
    }

    /**
     * Writes report bytes to response output stream.
     *
     * @param response Current response.
     * @param output   Report bytes to write.
     * @throws ServletException on stream IOException.
     */
    private void writeReport(String format,ReportAction action,HttpServletResponse response, Object output) throws ServletException {
        ServletOutputStream outputStream = null;
        try {
            
            if(format.equals(FORMAT_HTML)){
            	Map<String,Object> map = new HashMap<String ,Object>();
            	map.put("success","true");
            	map.put("total", action.getIreportEntity().getTotal());
            	map.put("content",output);
                response.getWriter().write(JsonUtils.toJson(map));
                response.flushBuffer();
                response.getWriter().close();
            }else{
            	outputStream = response.getOutputStream();
                outputStream.write((byte[])output);
                outputStream.flush();
            }
        } catch (IOException e) {
            LOG.error("Error writing report output", e);
            throw new ServletException(e.getMessage(), e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                LOG.error("Error closing report output stream", e);
                throw new ServletException(e.getMessage(), e);
            }
        }
    }

    /**
     * Sets up result properties, parsing etc.
     *
     * @param invocation Current invocation.
     * @throws Exception on initialization error.
     */
    private void initializeProperties(ActionInvocation invocation) throws Exception {
        if (dataSource == null && connection == null) {
            String message = "No dataSource specified...";
            LOG.error(message);
            throw new RuntimeException(message);
        }
        if (dataSource != null)
            dataSource = conditionalParse(dataSource, invocation);

        format = conditionalParse(format, invocation);
        if (StringUtils.isEmpty(format)) {
            format = FORMAT_PDF;
        }

        if (contentDisposition != null) {
            contentDisposition = conditionalParse(contentDisposition, invocation);
        }

        if (documentName != null) {
            documentName = conditionalParse(documentName, invocation);
        }

        reportParameters = conditionalParse(reportParameters, invocation);
        exportParameters = conditionalParse(exportParameters, invocation);
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
    private byte[] exportReportToBytes(JasperPrint jasperPrint, JRExporter exporter) throws JRException {
        byte[] output;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        if (delimiter != null) {
            exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, delimiter);
        }

        exporter.exportReport();

        output = baos.toByteArray();

        return output;
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
    private String exportReportToStringBuffer(JasperPrint jasperPrint, JRExporter exporter) throws JRException {
        StringBuffer sb = new StringBuffer();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sb);
        if (delimiter != null) {
            exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, delimiter);
        }
        exporter.exportReport();
        return sb.toString();
    }
    /**
     * add by xieshengfeng
     * @since 2014-05-21
     */
    private byte[] deractorDocument(byte[] output){
    	ByteArrayInputStream dd = new ByteArrayInputStream(output);
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	Workbook hssfWorkbook = null ;
    	try {
    		try{
    			hssfWorkbook = new XSSFWorkbook(dd);
    		}catch(Exception E){
    			dd = new ByteArrayInputStream(output);
    			hssfWorkbook = new HSSFWorkbook(dd);
    		}
			// 循环工作表Sheet
		    for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
		      Sheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);
		      if(hssfSheet == null){
		        continue;
		      }
		      
		      // 循环行Row 
		      for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
		    	Row hssfRow = hssfSheet.getRow( rowNum);
		        if(hssfRow == null){
		          continue;
		        }
		        
		        // 循环列Cell  
		        for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){
		          Cell hssfCell = hssfRow.getCell( cellNum);
		          if(hssfCell == null){
		            continue;
		          }
		          System.out.print("    " + getValue( hssfCell));
		        }
		      }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			hssfWorkbook.write(baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
    }
    
    @SuppressWarnings("static-access")  
	private String getValue(Cell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
    /**
     * 导出word
     * @author xieshengfeng
     * @param jasperPrint
     * @param defaultFilename
     * @param request
     * @param response
     * @throws JRException
     * @throws IOException
     */
    private static void exportWord(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/msword;charset=utf-8");
		String defaultname = null;
		if (defaultFilename.trim() != null && defaultFilename != null) {
			defaultname = defaultFilename + ".doc";
		} else {
			defaultname = "export.doc";
		}
		String fileName = new String(defaultname.getBytes("GBK"), "utf-8");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		JRExporter exporter = new JRRtfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response
				.getOutputStream());
		exporter.exportReport();
	}
    
    protected void setHtmlExportParameterMap(ActionInvocation invocation,JRExporter exporter){
    	
    }
    protected Map getExcelReportParameter(ActionInvocation invocation){
    	return null;
	}
	protected void setPdfExportParameterMap(ActionInvocation invocation,JRExporter exporter){
	}
	/**
	 * 如果主报表的query是sql类型,则设置总记录到IReportEntity中
	 * xsf
	 * 2015年7月3日下午4:56:22
	 * TODO
	 * void
	 */
	private void generateTotalCount(JasperReport jasperReport,Map<String,Object> parameters,IReportEntity ireportEntity,Connection conn) throws SQLException{
        JRQuery  jjj = jasperReport.getQuery();
        if(jjj.getLanguage().toUpperCase().equals("SQL")){
        	JRQueryChunk[] jrQueryChunkArray = jjj.getChunks();
        	if(null!=jrQueryChunkArray && jrQueryChunkArray.length>0){
        		List<Object> paramList = new ArrayList<Object>();
        		StringBuffer sb = new StringBuffer();
        		JRParameter[] jrp = jasperReport.getParameters();
        		Map<String,JRParameter> jrParameterMap = new HashMap<String,JRParameter>();
        		for(JRParameter jRParameter : jrp){
        			jrParameterMap.put(jRParameter.getName(), jRParameter);
        		}
        		for(int i=0;i<jrQueryChunkArray.length;i++){
        			JRQueryChunk jrQueryChunk = jrQueryChunkArray[i];
        			int type = jrQueryChunk.getType();
        			String text = jrQueryChunk.getText();
        			if(type == 1){
        				if(text.toUpperCase().contains("LIMIT")){
        					text = text.replaceAll("(?i)limit", "");
        					sb.append(text);
        					break;
        				}else{
        					sb.append(text);
        				}
        			}else if(type == 2){
        				Class<?> clazz = jrParameterMap.get(text).getValueClass();
        				Object value = parameters.get(text);
        				if(null!=value){
        					paramList.add(transformParameter(value.toString(),clazz));
        				}else{
        					paramList.add(value);
        				}
        				sb.append(" ? ");
        			}
        		}
        		int totalCount = queryTotalCount("SELECT count(*) FROM ( "+sb.toString()+" ) a",conn,paramList);
        		ireportEntity.setTotal(totalCount);
        	}
        }
	}
	private Object transformParameter(String text,Class<?> clazz){
		Object value = null;
		if(clazz.isAssignableFrom(String.class)){
			value = text;
		}else if(clazz.isAssignableFrom(Integer.class)){
			value = Integer.parseInt(text);
		}else if(clazz.isAssignableFrom(Long.class)){
			value = Long.parseLong(text);
		}else if(clazz.isAssignableFrom(Double.class)){
			value = Double.parseDouble(text);
		}else if(clazz.isAssignableFrom(Float.class)){
			value = Float.parseFloat(text);
		}else if(clazz.isAssignableFrom(Date.class)){
			value = DateHelper.parseDate(text);
		}
		return value;
	}
	
	private int queryTotalCount(String sql,Connection conn,List<Object> paramList) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i=0;i< paramList.size();i++){
			Object obj = paramList.get(i);
			ps.setObject(i+1, obj);
		}
		ResultSet rs = ps.executeQuery();
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
        }
		rs.close();
		ps.close();
		return count;
	}
	
}

