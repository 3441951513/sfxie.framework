package com.sfxie.extension.memcached;


import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;

import com.sfxie.core.server.IResourceReflesh;
import com.sfxie.core.server.IServerInitCall;
import com.sfxie.extension.memcached.exception.MemcachedAddException;
import com.sfxie.extension.memcached.exception.MemcachedDeleteException;
import com.sfxie.extension.memcached.exception.MemcachedGetException;
import com.sfxie.extension.spring4.mvc.context.Context;

/**	Api模块缓存管理器	*/
public class ApiMemcachedManager {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**	获取memcached缓存管理客户端	*/
	public static CacheApiImpl getCacheApi(){
		return (CacheApiImpl) Context.getBeanByName("cacheApi");
	}
	/**
	 * 自增操作
	 * @TODO	
	 * @param key
	 * 			关键字
	 * @param expire
	 * 			有效时间,0表示断电前永久保存
	 * @param obj
	 * @throws MemcachedAddException	
	 *
	 */
	public static long incr(String key, long value) throws MemcachedAddException{
		try {
			return ApiMemcachedManager.getCacheApi().incr(key, value);
		} catch (Exception e) {
			throw new MemcachedAddException("缓存操作(添加)异常");
		} 
	}
	/**
	 * 添加数据到缓存
	 * @TODO	
	 * @param key
	 * 			关键字
	 * @param expire
	 * 			有效时间,0表示断电前永久保存
	 * @param obj
	 * @throws MemcachedAddException	
	 *
	 */
	public static void add(String key, int expire, Object obj) throws MemcachedAddException{
		try {
			ApiMemcachedManager.getCacheApi().add(key, expire, obj);
		} catch (Exception e) {
			throw new MemcachedAddException("缓存操作(添加)异常");
		} 
	}
	/**
	 * 从memcached缓存获取数据
	 * @TODO	
	 * @param key
	 * 			关键字
	 * @return
	 * @throws MemcachedGetException	
	 *
	 */
	public static Object get(String key) throws MemcachedGetException{
		try {
			return ApiMemcachedManager.getCacheApi().get(key);
		} catch (Exception e) {
			throw new MemcachedAddException("缓存操作(查询)异常");
		} 
	}
	/**
	 * 从memcached缓存删除数据
	 * @TODO	
	 * @param key
	 * 			关键字
	 * @return
	 * @throws MemcachedDeleteException	
	 *
	 */
	public static boolean delete(String key) throws MemcachedDeleteException{
		try {
			return ApiMemcachedManager.getCacheApi().delete(key);
		} catch (Exception e) {
			throw new MemcachedAddException("缓存操作(删除)异常");
		} 
	}
    public static boolean replace(String key, int expire, Object obj) throws MemcachedException, TimeoutException, InterruptedException {
        return getCacheApi().replace(key, expire, obj);
    }
	/**
	 * 调用实现了{@link com.sfxie.core.server.IResourceReflesh}类的刷新操作
	 * @TODO	
	 * @param refleshClassName
	 * 			spring注册类的名称(已注册到spring环境中),<br>
	 * 			此类实现了{@link com.sfxie.core.server.IResourceReflesh}接口
	 * @return	
	 *
	 */
	public static <T> T reflesh( String refleshClassName){
		return ((IResourceReflesh) Context.getBeanByName(refleshClassName)).reflesh();
	}
	/**
	 * 调用实现了{@link com.sfxie.core.server.IServerInitCall}类的初始化操作
	 * @TODO	
	 * @param serverInitCallClassName
	 * 			spring注册类的名称(已注册到spring环境中),<br>
	 * 			此类实现了{@link com.sfxie.core.server.IServerInitCall}接口
	 * @return	
	 *
	 */
	public static <T> T init( String serverInitCallClassName){
		return ((IServerInitCall) Context.getBeanByName(serverInitCallClassName)).init();
	}
}
