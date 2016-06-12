package com.sfxie.extension.jasperreport6.struts2.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Map;

import org.apache.struts2.components.Component;

import com.sfxie.advert.common.tag.struts.security.SecurityElementTag;
import com.sfxie.advert.common.util.HttpRequestUtil;
import com.sfxie.advert.common.util.JsonUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class IReportComponent extends Component {
	
	private String contextPath;
	
	private String queryFormId;
	
	private String reportDealer;
	
	private String northStyle;
	
	private String queryAreaStyle;
	
	private String paginationAreaStyle;
	
	private String autoQuery;
	
	private String retrunPageUrl;
	
    public IReportComponent(ValueStack stack) {
        super(stack);
    }


	public boolean start(Writer writer) {
		boolean result = super.start(writer);
//		InputStream InputStream = this.getClass().getResourceAsStream("report.html.txt");
//		String htmlText = FileUtils.readFileToString("report.html.txt", "utf-8");
		try {
//			report.javascript.js
			if(null==northStyle || northStyle.equals("")){
				northStyle = " style=\"height:100px;\"";
			}
			if(null==queryAreaStyle || queryAreaStyle.equals("")){
				queryAreaStyle = " style=\"vertical-align: middle;height: 65%;\"";
			}
			if(null==paginationAreaStyle || paginationAreaStyle.equals("")){
				paginationAreaStyle = " style=\"vertical-align: middle;height: 35%;\"";
			}
			String js = inputStream2String(this.getClass().getResourceAsStream("report.resource.js")).replaceAll("\\$\\{ctx\\}", contextPath);
			writer.write(js.replaceAll("\\$\\{queryFormId\\}", queryFormId)
					       .replaceAll("\\$\\{reportDealer\\}", reportDealer)
					     );
			writer.write(inputStream2String(this.getClass().getResourceAsStream("report.html.txt"))
					      .replaceAll("\\$\\{northStyle\\}", northStyle)
				          .replaceAll("\\$\\{queryAreaStyle\\}", queryAreaStyle)
				          .replaceAll("\\$\\{paginationAreaStyle\\}", paginationAreaStyle)
				          .replaceAll("\\$\\{ctx\\}", contextPath)
				          .replaceAll("\\$\\{returnPagePlaceHolder\\}", getReturnPageBtnText()));
			
			if(null==autoQuery || autoQuery.equals("true")){
				writer.write(getAutoQueryScript());
			}
			if(false){
				Map<String, String> securityMap = SecurityElementTag.getUserRoleMap();
				if(null!=securityMap && securityMap.size()>0){
					String url = HttpRequestUtil.getHttpServletRequest().getRequestURI().toString();
					String url2 = HttpRequestUtil.getHttpServletRequest().getContextPath().toString();
					writer.write(getSecurityBtnScript(securityMap,url.replace(url2, "")));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return result;
    }

	/**
	 * 获取自动查询js代码
	 * xsf
	 * 2015年7月3日下午1:23:26
	 * TODO
	 * String
	 */
	private String getAutoQueryScript(){
		StringBuffer sb = new StringBuffer();
		//点击返回按钮时执行setReturnPageParameters('returnPage')
		sb.append("setReturnPageParameters(\"returnPage\");");
		sb.append("doHtmlReport(\"single\");");
		return getEvalScriptForJqueryOnReady(sb.toString());
	}
	private String getSecurityBtnScript(Map<String, String> securityMap,String url){
		StringBuffer sb = new StringBuffer();
		sb.append("var map = "+JsonUtils.toJson(securityMap)+";");
		sb.append("var url = \""+url +"\";");
		sb.append("securityBtn(map,url);");
		return getEvalScriptForJqueryOnReady(sb.toString());
	}
	private String getReturnPageBtnText(){
		if(null!=retrunPageUrl && !retrunPageUrl.equals("")){
			String btnText = "<td>"
							+"   <a id=\"returnPageBtn\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"javascript:returnParentPageFunc('"+contextPath+retrunPageUrl+"');\" data-options=\"iconCls:'icon-save',plain:true\">返回</a>"
							+"</td>"
							+"<td><div class=\"pagination-btn-separator\"></div>"
							+"</td>";
			return btnText;
		}
		return "";
	}
	/**
	 * 获取返回到前台可自动执行的jquery的 ready内的js代码
	 * @param jsString	自定义可执行的js内容
	 * @return
	 */
	private static String getEvalScriptForJqueryOnReady(String jsString){
		StringBuffer sb = new StringBuffer();
		sb.append(" <script type=\"text/javascript\">")
		  .append("eval('"+"$(document).ready(function(){")
		  .append(jsString)
		  .append("});"+"\');")
		  .append(" </script>");
		return sb.toString();
	}

	public String getContextPath() {
		return contextPath;
	}


	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public static void main(String[] args) {
		String dd = "ddd'${ctx}'";
		System.out.println(dd.replaceAll("\\$\\{ctx\\}", "sss"));;
		
		String ss = "rel()";
		System.out.println(ss.replaceAll("\\(\\)", ""));;
	}


	public String getQueryFormId() {
		return queryFormId;
	}


	public void setQueryFormId(String queryFormId) {
		this.queryFormId = queryFormId;
	}
	
	public String getReportDealer() {
		return reportDealer;
	}


	public void setReportDealer(String reportDealer) {
		this.reportDealer = reportDealer;
	}


	public static String inputStream2String(InputStream is) throws IOException{
	   BufferedReader in = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	   StringBuffer buffer = new StringBuffer();
	   String line = "";
	   while ((line = in.readLine()) != null){
	     buffer.append(line);
	   }
	   return buffer.toString();
	}


	public String getNorthStyle() {
		return northStyle;
	}


	public void setNorthStyle(String northStyle) {
		this.northStyle = northStyle;
	}


	public String getQueryAreaStyle() {
		return queryAreaStyle;
	}


	public void setQueryAreaStyle(String queryAreaStyle) {
		this.queryAreaStyle = queryAreaStyle;
	}


	public String getPaginationAreaStyle() {
		return paginationAreaStyle;
	}


	public void setPaginationAreaStyle(String paginationAreaStyle) {
		this.paginationAreaStyle = paginationAreaStyle;
	}


	public String getAutoQuery() {
		return autoQuery;
	}


	public void setAutoQuery(String autoQuery) {
		this.autoQuery = autoQuery;
	}


	public String getRetrunPageUrl() {
		return retrunPageUrl;
	}


	public void setRetrunPageUrl(String retrunPageUrl) {
		this.retrunPageUrl = retrunPageUrl;
	}

	
}