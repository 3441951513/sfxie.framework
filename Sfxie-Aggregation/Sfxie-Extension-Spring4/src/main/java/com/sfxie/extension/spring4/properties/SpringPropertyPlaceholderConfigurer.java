package com.sfxie.extension.spring4.properties;


/**
 * spring的资源配置管理类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午7:16:01 2015年10月22日
 * @example		
 *
 */
public class SpringPropertyPlaceholderConfigurer{

	/**
	 * 获取资源
	 * @TODO	
	 * @param name
	 * @return	
	 *
	 */
	public static Object getContextProperty(String name) {
		return SwitchPropertyPlaceholderConfigurer.getContextProperty(name);
	}
	/**
	 * 获取资源
	 * @TODO	
	 * @param name
	 * @return	
	 *
	 */
	public static String getProperty(String name) {
		return (String) SwitchPropertyPlaceholderConfigurer.getProperty(name);
	}
}
