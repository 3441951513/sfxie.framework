package com.sfxie.netty.springmvc;

import javax.servlet.ServletException;

import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import netty4.sfxie.TaskRunner;



public class SpringNettyInitializer extends XmlWebApplicationContext{
	

	private static SpringNettyInitializer _instance;
	
	private DispatcherServlet dispatcherServlet;
	/**
	 * 双重检查锁来实现单例类<br>
	 * An implementation of double checked locking of Singleton.<br>
	 * Intention is to minimize cost of synchronization and improve performance,
	 * by only locking critical section of code, the code which creates instance
	 * of Singleton class. By the way this is still broken, if we don't make
	 * _instance volatile, as another thread can see a half initialized instance
	 * of Singleton.
	 */
	
	private SpringNettyInitializer(){}

	public static SpringNettyInitializer getInstance() {
		if (_instance == null) {
			synchronized (TaskRunner.class) {
				if (_instance == null) {
					_instance = new SpringNettyInitializer();
				}
			}
		}
		return _instance;
	}
	
	public void start(String contextConfigLocation,String mvcConfigLocation){
		SpringNettyInitializer.getInstance().initNettyServer(contextConfigLocation,mvcConfigLocation);
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		SpringMvcServer springMvcServer = (SpringMvcServer) this.getBean("springMvcServer");
		try {
			springMvcServer.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initNettyServer(String contextConfigLocation,String mvcConfigLocation){
		MockServletContext servletContext = new MockServletContext();
    	MockServletConfig servletConfig = new MockServletConfig(servletContext);
    	
    	servletConfig.addInitParameter("contextConfigLocation",contextConfigLocation);
    	servletConfig.addInitParameter("dispatchOptionsRequest", "true");
    	
    	servletContext.addInitParameter("contextConfigLocation",contextConfigLocation);
        
    	//AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
        ContextLoaderListener listener = new ContextLoaderListener();
        
        listener.initWebApplicationContext(servletContext);

        //ClassPathXmlApplicationContext wac = new ClassPathXmlApplicationContext();
		this.setServletContext(servletContext);
		this.setServletConfig(servletConfig);
		this.setConfigLocation(mvcConfigLocation);
    	//wac.register(WebConfig.class);
		dispatcherServlet = new DispatcherServlet(SpringNettyInitializer.getInstance());
		try {
			dispatcherServlet.init(SpringNettyInitializer.getInstance().getServletConfig());
		} catch (ServletException e) {
			e.printStackTrace();
		}
		afterPropertiesSet();
	}
	public static void main(String[] args) {
		SpringNettyInitializer.getInstance().start("classpath:config/extension/spring/xml/applicationContext-service-test.xml","classpath:config/soa/project/spring-mvc-config.xml" );
	}
	
	public DispatcherServlet getDispatcherServlet(){
		return dispatcherServlet;
	}
	
}
