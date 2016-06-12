package com.sfxie.extension.jedis.transaction;

import java.util.HashMap;
import java.util.Map;

public class JedisThreadLocalSnapshot {
	
	private static JedisThreadLocalSnapshot instance;
	
	private JedisThreadLocalSnapshot(){}
	
	public static JedisThreadLocalSnapshot getInstance(){
		if(null==instance){
			instance = new JedisThreadLocalSnapshot();
		}
		return instance;
	}
	
	private ThreadLocal<Map<Object,Object>> oldCacheMap = new ThreadLocal<Map<Object,Object>>();
	
	private ThreadLocal<Boolean> beginTransaction = new ThreadLocal<Boolean>();
	
	public static Map<Object,Object> getOldCacheMap(){
		if(null==getInstance().oldCacheMap.get())
			getInstance().oldCacheMap.set(new HashMap<Object,Object>());
		return getInstance().oldCacheMap.get();
	}
	
	public static void toOldCacheMap(Object key , Object value){
		getOldCacheMap().put(key, value);
	}
	
	public static void beginTransaction() {
		getInstance().beginTransaction.set(true);
	}
	/**
	 * 设置当前操作jedis线程启动异常回滚事务
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午3:59:27 2015-7-30
	 * @return	
	 *
	 */
	public static boolean isBeginTransaction() {
		Boolean isTransaction = getInstance().beginTransaction.get();
		if(null!=isTransaction && isTransaction){
			return true;
		}
		return false;
	}
	/**
	 * 释放当前jedis用于异常回滚数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	下午4:00:27 2015-7-30	
	 *
	 */
	public static void release(){
		if(JedisThreadLocalSnapshot.isBeginTransaction() && null!=getInstance().oldCacheMap.get() && getInstance().oldCacheMap.get().size()>0){
			getInstance().oldCacheMap.get().clear();
		}
		getInstance().oldCacheMap.remove();
	}
}
