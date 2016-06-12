package com.sfxie.extension.redis.redisson.proxy;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class RedissonProxy implements MethodInterceptor {
	
	private Object proxyObject;

	/**
	 * 
	 * 方法名 ：getInstance<br>
	 * 方法描述 ：创建代理对象<br>
	 * 创建者 ：Andy.wang<br>
	 * 创建时间 ：2013-8-26下午03:47:36 <br>
	 * 
	 * @param proxyObject
	 * @return 返回类型 ：Object
	 */
	public Object getInstance(Object proxyObject) {
		this.proxyObject = proxyObject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.proxyObject.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}
	 /**
     * 创建代理对象方法
     *
     * @param target        代理对象
     * @param args          对应的构造器参数类型
     *
     *                          例：有构造器如下
     *                          public Person(name,age){...} name为String.class age为int.class
     *                          写入name的类型与age的类型
     *
     *                          则：new Class[]{String.class,int.class}
     *
     * @param argsValue     对应的构造器参数值
     *
     *                          例:如此创建对象 new Person("name",23) 用以下方式传入：new Object[]{"name",23}
     *
     * @param <T>           <泛型方法>
     * @return              返回跟代理对象类型
     */
    @SuppressWarnings("unchecked")
	public <T> T getInstance(T target,Class<?>[] args,Object[] argsValue){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create(args,argsValue);
    }
 
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
//		System.out.println("事物开始");
		Object returnValue = proxy.invokeSuper(obj, args);
//		System.out.println("事物结束");
		return returnValue;
	}

}
