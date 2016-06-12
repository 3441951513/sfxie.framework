package com.sfxie.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import com.sfxie.utils.ExceptionUtil;
import com.sfxie.utils.FileUtils;
import com.sfxie.utils.LoggerUtil;
import com.sfxie.utils.Tool;
import com.sfxie.utils.XmlUtils;

/**
 * Controller测试的基础类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:49:11 2015年9月6日
 * @example		
 *
 */
public class BaseControllerTest {
	
	private String xmlParamFilePath;
	
	private String xmlParamFileRootPath;
	
	private Map<String,String> parameterMap ;
	
	protected String rootUrl;

	/**	被测试controller的名称	*/
	protected String contollerName;
	protected Object jaxbObject;
	/**	被测试controller的方法*/
	protected String contollerMethod;
	/**	postXML方法的请求参数	*/
	protected String xmlParam;
	
	/**	postString方法的请求参数	*/
	protected String stringParam;
	
	/**	以post方式请求XML参数的url	*/
	public String postXML(){
		String rootUrl = getRootUrl();
		String contollerName = getContollerName();
		String xmlParam = getXmlParam();
		try {
			String response ;
			generateXmlParam();
//			System.out.println("contollerMethod: "+getContollerMethod());
			if(null!=contollerMethod){
				response = Tool.postMethod(getXmlParam(), getRootUrl()+getContollerName()+".do?method="+getContollerMethod(), "text/xml");
			}else{
//				System.out.println(getRootUrl()+getContollerName());
				response = Tool.postMethod(getXmlParam(), getRootUrl()+getContollerName(), "application/xml");
			}
			clear();
			return response;
		} catch (Exception e) {
			StringBuffer sb = new StringBuffer();
			sb.append("错误请求url：").append(rootUrl+contollerName).append("\r\n")
			  .append("请求参数：").append(xmlParam).append("\r\n")
			  .append("错误信息：").append(ExceptionUtil.getExceptionMsg(e)).append("\r\n");
			LoggerUtil.instance(BaseControllerTest.class).info(sb.toString());;
		}
		return null;
	}
	/**	以post方式请求字符串参数的url	*/
	public String postString(){
		try {
			String response ; 
			response = Tool.httpPost(getStringParam(), getRootUrl()+getContollerName(), "application/x-www-form-urlencoded");
			clear();
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void clear(){
		this.rootUrl = null;
		this.jaxbObject = null;
		this.contollerMethod = null;
		this.contollerName = null;
		this.xmlParam = null;
	}
	/**
	 * 将jaxb对象转化为xml字符串
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:31:22 2015年9月6日
	 * @param jaxbObject
	 * @return	
	 *
	 */
	public String toXmlString(Object jaxbObject){
		try {
			return XmlUtils.serializerXmlString(jaxbObject);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		};
		return null;
	}
	/**
	 * 将xml字符串转化为jaxb对象
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:31:59 2015年9月6日
	 * @param clazz
	 * @param xml
	 * @return	
	 *
	 */
	public static <T> T toObject(Class<T> clazz,String xml) {
		try {
			return XmlUtils.unserializer(clazz, xml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getJaxbObject() {
		return jaxbObject;
	}

	public void setJaxbObject(Object jaxbObject) {
		this.jaxbObject = jaxbObject;
	}
	public String getContollerName() {
		return contollerName;
	}
	/**
	 * 设置被测试的contoller名称
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:49:32 2015年9月6日
	 * @return	
	 *
	 */
	public void setContollerName(String contollerName) {
		this.contollerName = contollerName;
	}

	public String getContollerMethod() {
		return contollerMethod;
	}

	/**
	 * 设置被测试的contoller方法名
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:49:46 2015年9月6日
	 * @param contollerName	
	 *
	 */
	public void setContollerMethod(String contollerMethod) {
		this.contollerMethod = contollerMethod;
	}

	public String getRootUrl() {
		return null==rootUrl?"http://localhost:8088/GoLiveLhq3/springmvc":rootUrl;
	}

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}

	public String getXmlParam() {
		return xmlParam;
	}
	private void generateXmlParam() throws Exception{
		if(null==getXmlParam()){
			if(null!=getXmlParamFilePath()){
				String p = FileUtils.loadAFileToStringDE3(new File(null!=getXmlParamFileRootPath()?getXmlParamFileRootPath():""+getXmlParamFilePath()));
				if(null!=parameterMap){
					for(String key : parameterMap.keySet()){
						p = p.replaceAll("#"+key+"#", parameterMap.get(key));
					}
				}
				System.out.println(p);
				setXmlParam(p);
			}
		}
	}
	/**
	 * 设置postXML方法的请求参数
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午10:50:21 2015年9月6日
	 * @param xmlParam	
	 *
	 */
	public void setXmlParam(String xmlParam) {
		this.xmlParam = xmlParam;
	}
	public String getStringParam() {
		if(null!=contollerMethod && !contollerMethod.equals("")){
			return "method="+getContollerMethod()+"&"+stringParam;
		}
		return ""+stringParam;
	}
	public void setStringParam(String stringParam) {
		this.stringParam = stringParam;
	}
	public String getXmlParamFilePath() {
		return xmlParamFilePath;
	}
	/**	设置xml参数文件路径(对应前台页面的参数获取文件路径)*/
	public void setXmlParamFilePath(String xmlParamFilePath) {
		this.xmlParamFilePath = xmlParamFilePath;
	}
	/**	设置xml参数文件路径的根目录(对应前台页面的参数获取文件路径)*/
	public void setXmlParamFileRootPath(String xmlParamFileRootPath) {
		this.xmlParamFileRootPath = xmlParamFileRootPath;
	}
	
	public String getXmlParamFileRootPath() {
		return xmlParamFileRootPath;
	}
	public Map<String, String> getParameterMap() {
		if(null==parameterMap){
			parameterMap = new HashMap<String, String>();
		}
		return parameterMap;
	}
	public void setParameterMap(Map<String, String> parameterMap) {
		this.parameterMap = parameterMap;
	}
	public static void main(String[] args) {
		try {
			Tool.postMethod("", "http://192.168.10.112:8080/GoLiveFramework/springmvc/ApiMemcachedManagerController.do?method=refleshRecommendPurchaseList ", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
