package com.sfxie.extension.spring4.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class SwitchPropertyPlaceholderConfigurer extends MyPropertyPlaceholderConfigurer implements InitializingBean {



	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
	private static Map<String, Object> ctxPropertiesMap;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, Object>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	/**
	 * 获取资源
	 * @TODO	
	 * @param name
	 * @return	
	 *
	 */
	public static Object getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
	/**
	 * 获取资源
	 * @TODO	
	 * @param name
	 * @return	
	 *
	 */
	public static String getProperty(String name) {
		return (String) getContextProperty(name);
	}
}