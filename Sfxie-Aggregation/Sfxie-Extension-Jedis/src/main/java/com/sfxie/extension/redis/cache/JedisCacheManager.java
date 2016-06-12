package com.sfxie.extension.redis.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.redisson.MyRedisson;
import org.redisson.Redisson;
import org.springframework.beans.factory.InitializingBean;



import com.sfxie.extension.redis.exception.JedisCacheInitException;
import com.sfxie.extension.redis.exception.JedisCacheRefleshException;
//import com.sfxie.extension.jedis.client.IJedisOperator;
import com.sfxie.extension.redis.redisson.RedissonManager;
import com.sfxie.extension.spring4.mvc.context.SpringContextHolder;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.LoggerUtil;
/**
 * 
 * @TODO	初始化时加载缓存抽象类
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:20:51 2015-7-29
 * @example	其子类只需要继承它并且注册到spring环境中即可	
 *
 */
public abstract class JedisCacheManager implements InitializingBean{
//	@Resource
//	private IJedisOperator jedisOperator;
//	@Resource
	private RedissonManager redissonManager;
	/**		保存一份JedisCacheManager,以便可以刷新缓存	*/
	private static Map<Class<?>,JedisCacheManager> JedisCacheLoaderMap = new HashMap<Class<?>,JedisCacheManager>();
	@Override
	public void afterPropertiesSet() throws Exception {
//		try{
//			IJedisOperator jedisOperator = (IJedisOperator) SpringContextHolder.getBeanByClass(IJedisOperator.class);
//			if(null!=jedisOperator){
//				this.jedisOperator = jedisOperator;
//			}
//		}catch(Exception e){
//		}
		try{
			RedissonManager redissonManager = (RedissonManager) SpringContextHolder.getBeanByClass(RedissonManager.class);
			if(null!=redissonManager){
				this.redissonManager = redissonManager;
			}
		}catch(Exception e){
		}
		try{
			Date startTime = new Date();
			LoggerUtil.instance(JedisCacheManager.class).info(this.getClass().getName()+"[开始载入缓存.......]");
			initCache();
			LoggerUtil.instance(JedisCacheManager.class).info(this.getClass().getName()+"[结束载入缓存.......]");
			Date endTime = new Date();
			LoggerUtil.instance(JedisCacheManager.class).info(this.getClass().getName()+"[载入缓存总共花费的时间: "+DateHelper.getCompareString(startTime,endTime)+"]");
			JedisCacheLoaderMap.put(this.getClass(), this);
		}catch(Exception e){
			throw new JedisCacheInitException(e);
		}
	}

	/**
	 * 初始化缓存
	 * @TODO		
	 * @author 	xieshengfeng
	 * @since 	下午1:34:21 2015-7-29
	 * @return	返回自身,以便给全局缓存管理器管理
	 *
	 */
	public abstract void initCache();
	/**	重新加载缓存	*/
	public abstract void refleshCache();
	/***
	 * 
	 * @TODO	刷新特定子类的缓存(通用调用子类的refleshCache方法)
	 * @author 	xieshengfeng
	 * @since 	下午1:29:26 2015-7-29
	 * @param Class<?>...
	 * 			JedisCacheLoader的子类
	 *
	 */
	public static void refleshCache(Class<?>... jedisCacheLoaders)throws JedisCacheRefleshException {
		try{
			for(Class<?> cls : jedisCacheLoaders){
				Date startTime = new Date();
				LoggerUtil.instance(JedisCacheManager.class).info(cls.getName()+"[开始刷新缓存.......]");
				JedisCacheLoaderMap.get(cls).refleshCache();
				LoggerUtil.instance(JedisCacheManager.class).info(cls.getName()+"[结束刷新缓存.......]");
				Date endTime = new Date();
				LoggerUtil.instance(JedisCacheManager.class).info(cls.getName()+"[刷新缓存总共花费的时间: "+DateHelper.getCompareString(startTime,endTime)+"]");
			}
		}catch(Exception e){
			throw new JedisCacheRefleshException(e);
		}
	}

//	public IJedisOperator getJedisOperator() {
//		return jedisOperator;
//	}
	public MyRedisson getRedisson() {
		return redissonManager.getRedisson();
	}

	
	/*public static void destoreCaches(){
		
	}*/
	
}
