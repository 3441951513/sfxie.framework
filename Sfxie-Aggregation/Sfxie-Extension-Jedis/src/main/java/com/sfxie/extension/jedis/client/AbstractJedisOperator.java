package com.sfxie.extension.jedis.client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import com.sfxie.extension.jedis.annotation.RedisKey;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.entity.SaveType;
import com.sfxie.extension.jedis.transaction.JedisThreadLocalSnapshot;
import com.sfxie.utils.ReflectUtils;
import com.sfxie.utils.jacson.codehaus.JsonUtil;

public abstract class AbstractJedisOperator implements IJedisOperator{
	
	/**
	 * 存储JedisPersistentObject对象
	 * @param pojo
	 * 			被存储的JedisPersistentObject对象
	 * @param fieldName
	 */
	public void savePojo(JedisPersistentObject pojo){
		toOldCacheMap(pojo);
		JedisKeyGenerator.saveSelfObject(pojo, getJedisCommands());
	}
	
	/**
	 * 存储对象的json格式字符串
	 * @param pojo
	 * 			已经设置了主键的JedisPersistentObject对象
	 * @param fieldName
	 */
	public void getPojo(JedisPersistentObject pojo){
		
	}
	/**
	 * 缓存本次操作的对应key的数据,以便异常时进行数据回滚
	 * @TODO	如果用JedisThreadLocalSnapshot开启了异常回滚,则出异常时系统会进行数据恢复操作
	 * @author 	xieshengfeng
	 * @since 	下午1:33:07 2015-7-30
	 * @param key	
	 *
	 */
	protected void toOldCacheMap(String key){
		Object jedisCommand = getJedisCommands();
		if(JedisThreadLocalSnapshot.isBeginTransaction()){
			//JedisCluster操作类的处理
			if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
				JedisThreadLocalSnapshot.toOldCacheMap(key, ((JedisCluster)jedisCommand).get(key));
			}
			//对Jedis操作类的处理
			else{
				JedisThreadLocalSnapshot.toOldCacheMap(key, ((Jedis)jedisCommand).get(key));
			}
		}
		try {
			closeJedisCommand(jedisCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭redis连接
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午9:29:29 2015-8-4
	 * @param jedisCommands
	 * @throws IOException	
	 *
	 */
	private static void closeJedisCommand(Object jedisCommands) throws IOException{
		if(JedisCluster.class.isAssignableFrom(jedisCommands.getClass())){
			JedisCluster binaryJedisCluster = (JedisCluster) jedisCommands;
			binaryJedisCluster.close();
		}else{
			Jedis jedis = (Jedis) jedisCommands;
			jedis.close();
		}
	}
	/**
	 * 缓存本次操作的对应key的数据,以便异常时进行数据回滚
	 * @TODO	如果用JedisThreadLocalSnapshot开启了异常回滚,则出异常时系统会进行数据恢复操作
	 * @author 	xieshengfeng
	 * @since 	下午1:33:07 2015-7-30
	 * @param key	
	 *
	 */
	protected void toOldCacheMap(JedisPersistentObject pojo){
		List<String> parentKeys = JedisKeyGenerator.getParentKeys(pojo);
		Object jedisCommand = getJedisCommands();
		if(null!=parentKeys && parentKeys.size()>0){
			for(String parentKey : parentKeys){
				List<Field> fieldList = new ArrayList<Field>();
				Class pclazz = pojo.getClass();
				ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
				String key = null;
				for(Field field : fieldList){
					RedisKey redisKey = field.getAnnotation(RedisKey.class);
					if(null!=redisKey){
						key = ReflectUtils.getFieldValue(field.getName(), pojo).toString();
						break; //目前只支持单主键
					}
				}
				parentKey = parentKey +":"+ pclazz.getSimpleName()+":"+key;
				if(JedisThreadLocalSnapshot.isBeginTransaction()){
					if(pojo.getSaveType() == SaveType.BYTES){
						//JedisCluster操作类的处理
						if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
							JedisThreadLocalSnapshot.toOldCacheMap(parentKey.getBytes(), ((JedisCluster)jedisCommand).get(parentKey.getBytes()));
						}
						//对Jedis操作类的处理
						else{
							JedisThreadLocalSnapshot.toOldCacheMap(parentKey.getBytes(), ((Jedis)jedisCommand).get(parentKey.getBytes()));
						}
					}else {
						//JedisCluster操作类的处理
						if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
							JedisThreadLocalSnapshot.toOldCacheMap(parentKey, ((JedisCluster)jedisCommand).get(parentKey));
						}
						//对Jedis操作类的处理
						else{
							JedisThreadLocalSnapshot.toOldCacheMap(parentKey, ((Jedis)jedisCommand).get(parentKey));
						}
					}
				}
			}
		}else{
			List<Field> fieldList = new ArrayList<Field>();
			Class pclazz = pojo.getClass();
			ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
			String key = null;
			for(Field field : fieldList){
				RedisKey redisKey = field.getAnnotation(RedisKey.class);
				if(null!=redisKey){
					key = ReflectUtils.getFieldValue(field.getName(), pojo).toString();
					break; //目前只支持单主键
				}
			}
			key = pclazz.getName()+":"+key;
			if(JedisThreadLocalSnapshot.isBeginTransaction()){
				if(pojo.getSaveType() == SaveType.BYTES){
					//BinaryJedisCluster操作类的处理
					if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
						JedisThreadLocalSnapshot.toOldCacheMap(key.getBytes(), ((JedisCluster)jedisCommand).get(key.getBytes()));
					}
					//对Jedis操作类的处理
					else{
						JedisThreadLocalSnapshot.toOldCacheMap(key.getBytes(), ((Jedis)jedisCommand).get(key.getBytes()));
					}
				}else {
					//BinaryJedisCluster操作类的处理
					if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
						JedisThreadLocalSnapshot.toOldCacheMap(key, ((JedisCluster)jedisCommand).get(key));
					}
					//对Jedis操作类的处理
					else{
						JedisThreadLocalSnapshot.toOldCacheMap(key, ((Jedis)jedisCommand).get(key));
					}
				}
			}
		}
		try {
			closeJedisCommand(jedisCommand);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 存储对象的json格式字符串
	 * xsf
	 * 2015年7月1日下午2:56:42
	 * TODO
	 * void
	 */
	@Override
	public void setJsonPojo(String key ,Object pojo){
//		String tempKey = pojo.getClass().getName()+"."+fieldName+":"+ReflectUtils.getFieldValue(fieldName, pojo);
		toOldCacheMap(key);
		String jsonPojo = JsonUtil.toJSON(pojo);
		Object jedisCommand = getJedisCommands();
		//BinaryJedisCluster操作类的处理
		if(JedisCluster.class.isAssignableFrom(getJedisCommands().getClass())){
			((JedisCluster)jedisCommand).set(key,jsonPojo);
		}
		//对Jedis操作类的处理
		else{
			((Jedis)jedisCommand).set(key,jsonPojo);
		}
		try {
			closeJedisCommand(jedisCommand);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	/**
	 * 获取json字符串对象
	 * xsf
	 * 2015年7月1日下午2:57:16
	 * TODO
	 * T
	 */
	@Override
	public <T> T getJsonPojo(String key ,Class<T> Clazz){
		//BinaryJedisCluster操作类的处理
		String pojo;
		if(JedisCluster.class.isAssignableFrom(getJedisCommands().getClass())){
			pojo = ((JedisCluster)getJedisCommands()).get(key);
		}
		//对Jedis操作类的处理
		else{
			pojo = ((Jedis)getJedisCommands()).get(key);
		}
		return (T) JsonUtil.fromJSON(pojo,Clazz);
	}
}
