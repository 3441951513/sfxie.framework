package com.sfxie.extension.spring4.properties;

import java.io.IOException;
import java.net.URI;
import java.util.Properties;

public interface IPropertiesFileFilter {

	/**
	 * 过滤配置文件,返回真则通过验证
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:09:39 2016年3月23日
	 * @example
	 * @param preProperties
	 * 			前置配置文件
	 * @param uri
	 * 			被过滤的配置文件uri
	 * @return	
	 *
	 */
	public boolean filter(Properties preProperties,String path)throws IOException ;
	/**
	 * 前置配置文件路径
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:09:21 2016年3月23日
	 * @example
	 * @return	
	 *
	 */
	public String  loadPrePropertiesPath();
	/**
	 * 验证配置文件是否正确,验证不通过则抛出IOException异常
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:08:59 2016年3月23日
	 * @example
	 * @param preProperties
	 * @throws IOException	
	 *
	 */
	public void validate(Properties preProperties) throws IOException;
}
