package com.sfxie.extension.jasperreport6.struts2;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;










import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.jasperreports.JasperReportConstants;

import com.sfxie.advert.common.base.BaseAction;
import com.sfxie.advert.common.util.JsonUtils;
/**
 * 报表模块处理类
 *
 */
public class ReportAction extends BaseAction{
	
	private static final long serialVersionUID = -4746302951981941466L;
	
	/** 获取注册配置文件  */
	private static String propertyFileName = "com.sfxie.report.report-register";
	private static ResourceBundle resourceBundle = null;
	/**	对ireport报表执行时的一些参数设置	*/
	private IReportEntity ireportEntity;
	/** 前台传参数到后台的参数map对象*/
	private Map<String, String> paramMap;
	/** 前端easyui的datagrid控件传过来的当前页数		*/
	private Integer pageNumber;
	/**	前端easyui的datagrid控件传过来的每页记录数	*/
	private Integer pageSize;
	/**	数据导出文档类型:(pdf,doc,docx,xls,xlsx等)*/
	private String exportDataType;
	
	/** key名称对应jasper中的parameter参数名*/
	private Map<String, Object> reportParamMap = new HashMap<String, Object>();
	/**	ireport模板数据源是javabean collection类型时设置的数据集合	*/
	private Collection<?> collectionDataSource;
	
	/**
     * 此次下载标记,从前端传过来的参数,用于获取下载状态
     */
    private String downloadTag;
	
	static{
		resourceBundle = ResourceBundle.getBundle(propertyFileName);
	}
	/** 处理类注册名	*/
	private String register; 
	
	/** 报表模块统一处理入口 */
	public String report(){
		
		try {
			if(null!=downloadTag)
				setStatusMsg("0");
			if(null==paramMap)
				paramMap = new HashMap<String, String>();
			if(StringUtils.isEmpty(register)){
				if(null!=downloadTag)
					setStatusMsg("1");
				return "reportPage";
			}
			//从配置文件中获取
			String className = resourceBundle.getString(register);
			if(null==ireportEntity)
				ireportEntity = new IReportEntity();
			if(null != paramMap.get("exportFileType"))
				ireportEntity.setFormat(paramMap.get("exportFileType").toUpperCase());
			else
				ireportEntity.setFormat(JasperReportConstants.FORMAT_HTML);
			
			//使用jdbc连接时，在具体的报表处理类中设置此项，如使用javabean数据源则不需要设置
			String reportName = paramMap.get("reportName");
			if(null!=reportName){
				ireportEntity.setFileName(reportName);
				//公共设置报表文件，可在预处理类中覆盖
				ireportEntity.setLocation(reportName+".jasper");
			}
			ireportEntity.setReportParameters("reportParamMap");
			//设计report的返回类型(pdf,html,xlsx,docx等)
			if (null != paramMap.get("exportFileType"))
				ireportEntity.setFormat(paramMap.get("exportFileType").toUpperCase());
			Class<?> cls = Class.forName(className);
			IReportPreDealer reportPreDealer = (IReportPreDealer) cls.newInstance();
			reportPreDealer.preDeal(this);
			if(null == collectionDataSource)
				ireportEntity.setConnectionDataSource("staticDataSource");
			reportParamMap.put("rp_exportFileType", paramMap.get("exportFileType"));
		}  catch (Exception e) {
			e.printStackTrace();
			if(null!=downloadTag)
				setStatusMsg("1");
		}
		String contextPath = this.getRequest().getContextPath();
		//把系统根路径放入ireport环境中
		reportParamMap.put("RP_CTX", contextPath);
		//把查询参数放入ireport环境中
		reportParamMap.put("RP_QUERYSTRING", "?"+filterQueryString(this.getRequest()));
		return "jasper";
	}
	
	private String filterQueryString(HttpServletRequest request){
		Map<String, String[]> params = request.getParameterMap();  
		String jspName = params.get("paramMap.jspName")[0];
		int p = jspName.indexOf("?");
		if(p>0)
			jspName = jspName.substring(0, jspName.indexOf("?"));
		String prefix = "jjjjj";
        String queryString = "";  
        for (String key : params.keySet()) {
        	if(judgeIsRetrunPageParameters(key)){
        		//已经存在的父页面查询参数处理
        		if(key.indexOf(prefix)==0){
        			String[] values = params.get(key);  
        			String value = values[0];  
        			queryString += key + "=" + value + "&";
        		}
        		//本级页面的查询参数处理
        		else{
        			String[] values = params.get(key);  
            		/*for (int i = 0; i < values.length; i++) {  
            			String value = values[i];  
            			queryString += prefix+jspName+"."+key + "=" + value + "&";  
            		}*/
            		String value = values[0];  
        			queryString += prefix+jspName+"."+key + "=" + value + "&";  
        		}
        		 
        	}
        }  
        // 去掉最后一个空格  
        queryString = queryString.substring(0, queryString.length() - 1);  
		return queryString;//"isIgnorePage=true&pageSize=10&pageNumber=1&exportDataType=single&exportFileType=html&register=DemoReportDealer&name=&code=&paramMap.formParameter=%257B%2522name%2522%3A%2522%2522%2C%2522code%2522%3A%2522%2522%257D&paramMap.exportFileType=html&paramMap.isIgnorePage=true&_=1438752375509";
	}
	/**
	 * 判断是否是返回页面的查询参数
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午11:06:41 2015年8月6日
	 * @param paramName
	 * @return	
	 *
	 */
	private boolean judgeIsRetrunPageParameters(String paramName){
		if(paramName.equals("isRetrunPage")){
			return false;
		}else if(paramName.equals("paramMap.jspName")){
			return false;
		}else if(paramName.equals("paramMap.exportFileType")){
			return false;
		}else if(paramName.equals("paramMap.isIgnorePage")){
			return false;
		}else if(paramName.equals("formParameter")){
			return false;
		}else if(paramName.equals("isIgnorePage")){
			return false;
		}else if(paramName.equals("exportFileType")){
			return false;
		}else if(paramName.equals("exportDataType")){
			return false;
		}else if(paramName.equals("register")){
			return false;
		}else if(paramName.equals("paramMap.formParameter")){
			return false;
		}else{
			return true;
		}
	}
	public void status() throws Exception {
		HttpSession  session  = ServletActionContext.getRequest().getSession();
		ReportDownloadStatus reportDownloadStatus = (ReportDownloadStatus) session.getAttribute(downloadTag);
		String status = "" ;
		status = JsonUtils.toJson(reportDownloadStatus);
		if(null!=reportDownloadStatus && reportDownloadStatus.getState().equals("2")){
			session.removeAttribute(downloadTag);
		}
    	write(status);
    }
	private void write(String fileUploadStatus) throws IOException{
    	this.getResponse().setCharacterEncoding("UTF-8");
		// 设置页面不缓存  
		this.getResponse().setHeader("Cache-Control", "no-cache");  
		this.getResponse().setHeader("Cache-Control", "no-store");  
		this.getResponse().setHeader("Pragma", "no-cache");  
		this.getResponse().setDateHeader("Expires", 0);  
		this.getResponse().getWriter().write(fileUploadStatus);
    }
	/** 
     *  
     * 错误信息的处理 
     *  
     * @param request 
     * @param error: 1-错误;0-正常;2-下传完成
     * @param message 
     */  
    private void setStatusMsg(String state) {  
    	HttpSession  session  = ServletActionContext.getRequest().getSession();
    	ReportDownloadStatus reportDownloadStatus = (ReportDownloadStatus) session.getAttribute(downloadTag);  
    	if(null== reportDownloadStatus){
    		reportDownloadStatus = new ReportDownloadStatus();
    		session.setAttribute(downloadTag,reportDownloadStatus);
    	}
    	reportDownloadStatus.setState(state);  
    }
	
	public void setRegister(String register) {
		this.register = register;
	}

	public IReportEntity getIreportEntity() {
		return ireportEntity;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Map<String, Object> getReportParamMap() {
		return reportParamMap;
	}

	public void setReportParamMap(Map<String, Object> reportParamMap) {
		this.reportParamMap = reportParamMap;
	}

	public String getExportDataType() {
		return exportDataType;
	}

	public void setExportDataType(String exportDataType) {
		this.exportDataType = exportDataType;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取此次获取数据列表的开始位置
	 * xsf
	 * 2015年6月10日上午9:49:47
	 * TODO
	 * Integer
	 */
	public Integer calculateStartIndex(){
		return (pageNumber-1)*pageSize;
	}
	/**
	 * 获取此次获取数据列表的结束位置
	 * xsf
	 * 2015年6月10日上午9:51:24
	 * TODO
	 * Integer
	 */
	public Integer calculateEndIndex(Integer total){
		if((pageNumber*pageSize)<=total){
			return (pageNumber*pageSize)-1;
		}else{
			return total-1;
		}
	}

	public Collection<?> getCollectionDataSource() {
		return collectionDataSource;
	}

	public void setCollectionDataSource(Collection<?> collectionDataSource) {
		this.collectionDataSource = collectionDataSource;
		if(null!=this.collectionDataSource)
			ireportEntity.setDataSource("collectionDataSource");
		
	}
	public String getDownloadTag() {
		return downloadTag;
	}
	public void setDownloadTag(String downloadTag) {
		this.downloadTag = downloadTag;
	}
}
