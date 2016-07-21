package com.sfxie.soa.modules.common.context;

import com.sfxie.extension.spring4.properties.SwitchPropertyPlaceholderConfigurer;

public class Properties {

	/**
	 * 获取配置信息
	 * @param name
	 * @return
	 */
	public static String getProperty(String name){
		return null!=SwitchPropertyPlaceholderConfigurer.getProperty(name)?SwitchPropertyPlaceholderConfigurer.getProperty(name):name;
	}
}
