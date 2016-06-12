package com.sfxie.extension.jedis.client;

import java.util.List;

import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.query.JedisVagueQuyerEnum;

/**
 * 操作jedis的接口,以便统一管理单节点和集群两种模式的redis操作
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月21日上午10:45:42
 */
public interface IJedisOperator {
	
	/**	获取操作redis的具体实现类*/
	public Object getJedisCommands();

	/**
	 * 存储对象的json格式字符串
	 * @param pojo
	 * @param fieldName
	 */
	public abstract void setJsonPojo(String key,Object pojo);

	/**
	 * 获取json字符串对象
	 * @param Clazz<T>
	 * @param fieldName
	 * @param keyValue
	 * @return	<T>
	 */
	public abstract <T> T getJsonPojo(String key,Class<T> Clazz);

	/**
	 * 存储对象的序列化值
	 * @param pojo
	 * @param fieldName
	 * @param seconds
	 */
	public abstract void setSerializePojo(String key, Object pojo,
			Integer seconds);

	/**
	 * 获取序列化对象
	 * @param Clazz<T>
	 * @param fieldName
	 * @param keyValue
	 * @return <T>
	 */
	public abstract <T> T getSerializePojo(String key, Class<T> Clazz);

	/**
	 * 从集群中模糊查询所有符合条件的结果
	 * @param clazz<T>
	 * @param fieldName
	 * @param keyValue
	 * @param sfxieJedisVagueQuyerEnum
	 * @return List<T>
	 */
	public abstract <T> List<T> vagueQueryPojo(Class<T> clazz,
			String fieldName,
			JedisVagueQuyerEnum sfxieJedisVagueQuyerEnum);

	public abstract void hsetPojo(String key, Object pojo, String field,
			Long time);
	
	/**
	 * 存储对象的json格式字符串
	 * @param pojo
	 * @param fieldName
	 */
	public abstract void savePojo(JedisPersistentObject pojo);
	
	/**
	 * 存储对象的json格式字符串
	 * @param pojo
	 * @param fieldName
	 */
	public abstract void getPojo(JedisPersistentObject pojo);
}
