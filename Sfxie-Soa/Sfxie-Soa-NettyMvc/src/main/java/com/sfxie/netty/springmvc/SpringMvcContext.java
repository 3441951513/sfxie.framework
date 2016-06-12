package com.sfxie.netty.springmvc;

import netty4.sfxie.TaskRunner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringMvcContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	private static SpringMvcContext _instance;
	
	private SpringMvcContext(){}

	/**
	 * 双重检查锁来实现单例类<br>
	 * An implementation of double checked locking of Singleton.<br>
	 * Intention is to minimize cost of synchronization and improve performance,
	 * by only locking critical section of code, the code which creates instance
	 * of Singleton class. By the way this is still broken, if we don't make
	 * _instance volatile, as another thread can see a half initialized instance
	 * of Singleton.
	 */

	public static SpringMvcContext getInstance() {
		if (_instance == null) {
			synchronized (TaskRunner.class) {
				if (_instance == null) {
					_instance = new SpringMvcContext();
				}
			}
		}
		return _instance;
	}

	/*
	 * 
	 * 实现了ApplicationContextAware 接口，必须实现该方法；
	 * 
	 * 通过传递applicationContext参数初始化成员变量applicationContext
	 */

	public void setApplicationContext(ApplicationContext applicationContext1)
			throws BeansException {
		applicationContext = applicationContext1;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

}