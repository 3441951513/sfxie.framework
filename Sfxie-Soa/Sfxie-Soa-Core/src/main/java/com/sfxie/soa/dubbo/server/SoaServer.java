package com.sfxie.soa.dubbo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sfxie.extension.logger.LoggerUtil;

public class SoaServer {
	
	private static final SoaServer INSTANCE = new SoaServer();
	
	private static String classPath;
	
	private static String catalinaHome;
	
	private SoaServer(){}
	
	/**
	 * 启动服务器
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:18:27 2016年4月22日
	 * @example	
	 *
	 */
	public void start(){
		try {
			if(null==System.getProperty("catalina.home")){
				if(null!=SoaServer.catalinaHome){
					System.setProperty("catalina.home", SoaServer.catalinaHome);
				}else{
					System.setProperty("catalina.home", "D:\\workspace\\sfxie\\workspace");
				}
			}
			if(null==classPath){
				throw new Exception("请设置spring加载的classPathXml文件......");
			}
			new ClassPathXmlApplicationContext (classPath);
			while(true){
				Thread.sleep(300 * 1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.system(SoaServer.class, "startup error");
			System.exit(-1);
		}
	}
	
	public static SoaServer getInstance(){
		return INSTANCE;
	}
	/**
	 * 设置spring加载的classPathXml文件
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:18:11 2016年4月22日
	 * @example
	 * @param classPath	
	 *
	 */
	public void setClassPath(String classPath){
		SoaServer.classPath = classPath;
	}
	/**
	 * 设置log4j配置文件的${catalina.home}<br>
	 * 如果不是在tomcat中运行此程序的,需要设置此属性
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:15:35 2016年4月22日
	 * @example
	 * @param catalinaHome	
	 *
	 */
	public void setCatalinaHome(String catalinaHome){
		SoaServer.catalinaHome = catalinaHome;
	}
	
}
