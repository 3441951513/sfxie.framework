package com.sfxie.extension.spring4.mvc.context;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Context implements ApplicationContextAware,InitializingBean{
	
	protected static final Log logger = LogFactory.getLog(Context.class);
	
	public static String enviroment = null;
	
	private ApplicationContext webApplicationContext;
	
	private static Context instance;
	
	/**
	 * 保存HttpServletResponse的线程局部变量.
	 */
	private static final ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();
	/**
	 * 保存HttpServletRequest的线程局部变量.
	 */
	private static final ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();
	
	private Context() {
	}
	
	public static void setRequest(HttpServletRequest request){
		requestThreadLocal.set(request);
	}
	/**	获取当前请求的url字符串		*/
	public static String getUrl(){
		return requestThreadLocal.get().getRequestURL().toString();
	}
	/**
	 * 得到当前线程中的HttpServletRequest对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return requestThreadLocal.get();
	}
	public static void setResponse(HttpServletResponse response){
		responseThreadLocal.set(response);
	}
	/**
	 * 得到当前线程中的HttpServletResponse对象
	 * 
	 * @return
	 */
	public static HttpServletResponse getResponse() {
		return responseThreadLocal.get();
	}
	/**
	 * 清除当前线程的HttpServletRequest对象和HttpServletResponse对象
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:28:33 2015年9月7日	
	 *
	 */
	public static void clearRequestAndResponse(){
		requestThreadLocal.remove();
		responseThreadLocal.remove();
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("afterPropertiesSet");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		getInstance().webApplicationContext = applicationContext;
	}
	/**
	 * 根据给出的beanId来获取在Spring当中配置的bean
	 * 
	 * @param beanId
	 *            给出的beanId
	 * @return 返回找到的bean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getSpringBean(String beanId) {
		return (T) getWebApplicationContext().getBean(beanId);
	}
	/**
	 * 获取bean
	 * @param clsName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBeanByName(String clsName){
		return (T) getInstance().webApplicationContext.getBean(clsName);
	}
	/**
	 * 获取bean
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getBeansOfType(@SuppressWarnings("rawtypes") Class cls){
		return getInstance().webApplicationContext.getBeansOfType(cls);
	}
	/**
	 * 获取bean
	 * @param cls
	 * @return
	 */
	public static Object getBeanByClass(Class<?> cls){
		return getInstance().webApplicationContext.getBean(cls);
	}
	public static ApplicationContext getWebApplicationContext() {
		if(null==getInstance().webApplicationContext){
			getInstance().webApplicationContext = new ClassPathXmlApplicationContext("config/extension/spring/xml/applicationContext.xml");
		}
		return getInstance().webApplicationContext;
	}
	/**
	 * 得到当前线程中的HttpServletResponse对象
	 * 
	 * @return
	 */
	public static String getEnviroment() {
		return enviroment;
	}
	public static Context getInstance(){
		if(null==instance){
			instance = new Context();
		}
		return instance;
	}
}
