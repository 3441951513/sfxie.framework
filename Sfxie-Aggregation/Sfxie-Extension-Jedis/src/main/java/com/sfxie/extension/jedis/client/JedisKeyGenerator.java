package com.sfxie.extension.jedis.client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import com.sfxie.extension.jedis.annotation.RedisKey;
import com.sfxie.extension.jedis.annotation.RedisParent;
import com.sfxie.extension.jedis.annotation.RedisTransient;
import com.sfxie.extension.jedis.entity.JedisFieldRedisParentEntity;
import com.sfxie.extension.jedis.entity.JedisPersistentObject;
import com.sfxie.extension.jedis.entity.SaveType;
import com.sfxie.extension.redis.exception.JedisParentEmptyException;
import com.sfxie.utils.ReflectUtils;
import com.sfxie.utils.SerializeUtil;

/**
 * 主键生成器
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午10:22:47
 */
public class JedisKeyGenerator {
	
	private static Object empty = new Object();
	/**
	 * 保存对象自己的数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午10:37:10 2015-8-3
	 * @param jedisPersistentObject
	 * @param jedisCommands
	 * @return	
	 *
	 */
	public static void saveSelfObject (JedisPersistentObject jedisPersistentObject,Object jedisCommands){
		Map<String,Object> excludeSaveMap = new HashMap<String,Object>();
		saveObject(jedisPersistentObject,jedisCommands,excludeSaveMap,false);
	}
	/**
	 * 保存对象所有相关的数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午10:37:06 2015-8-3
	 * @param jedisPersistentObject
	 * @param jedisCommands
	 * @return	
	 *
	 */
	public static void saveAllRefrenceObject (JedisPersistentObject jedisPersistentObject,JedisCommands jedisCommands){
		Map<String,Object> excludeSaveMap = new HashMap<String,Object>();
		saveObject(jedisPersistentObject,jedisCommands,excludeSaveMap,true);
	}
	/**
	 * 保存对象到缓存中
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午11:40:06 2015-8-3
	 * @param jedisPersistentObject
	 * @param jedisCommands
	 * @param excludeSaveMap
	 * @param isAll	
	 *
	 */
	private static void saveObject (JedisPersistentObject jedisPersistentObject,Object jedisCommands,Map<String,Object> excludeSaveMap,boolean isAll){
		if(null==jedisPersistentObject){
			return ;
		}
		List<Field> fieldList = new ArrayList<Field>();
		//获取所有字段
		ReflectUtils.getBeanAllFields(fieldList, jedisPersistentObject.getClass(), JedisPersistentObject.class);
		
		List<Field> transientFieldList = new ArrayList<Field>();
		List<JedisFieldRedisParentEntity> redisParentList = new ArrayList<JedisFieldRedisParentEntity>();
		getTransientFieldList(jedisPersistentObject,fieldList,transientFieldList,redisParentList);
		List<String> parentKeys = getKeys(jedisPersistentObject,redisParentList);
		save(jedisPersistentObject,parentKeys,excludeSaveMap,jedisCommands);
		if(isAll){
			for(Field field : transientFieldList){
				JedisPersistentObject jedisPersistentObjectTemp = (JedisPersistentObject)ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject);
				saveObject(jedisPersistentObjectTemp,jedisCommands,excludeSaveMap,isAll);
			}
		}
	}
	public static List<String> getParentKeys(JedisPersistentObject jedisPersistentObject){
		if(null==jedisPersistentObject){
			return null;
		}
		List<Field> fieldList = new ArrayList<Field>();
		//获取所有字段
		ReflectUtils.getBeanAllFields(fieldList, jedisPersistentObject.getClass(), JedisPersistentObject.class);
		
		List<JedisFieldRedisParentEntity> redisParentList = new ArrayList<JedisFieldRedisParentEntity>();
		getTransientFieldList(jedisPersistentObject,fieldList,null,redisParentList);
		List<String> parentKeys = getKeys(jedisPersistentObject,redisParentList);
		return parentKeys;
	}
	/**
	 * 保存数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午10:59:45 2015-8-3
	 * @param jedisPersistentObject
	 * @param parentKeys
	 * @param excludeSaveMap
	 * @param jedisCommands	
	 *
	 */
	private static void save(JedisPersistentObject jedisPersistentObject,List<String> parentKeys,Map<String,Object> excludeSaveMap,Object jedisCommands){
		if(jedisPersistentObject.getSaveType()==SaveType.BYTES){
			saveBytes(jedisPersistentObject,parentKeys,excludeSaveMap,jedisCommands);
		}else{
//			saveString(jedisPersistentObject,parentKeys,excludeSaveMap,jedisCommands);
		}
		try {
			closeJedisCommand(jedisCommands);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
	 * 保存字节数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午10:59:53 2015-8-3
	 * @param jedisPersistentObject
	 * @param parentKeys
	 * @param excludeSaveMap
	 * @param jedisCommands	
	 *
	 */
	private static void saveBytes(JedisPersistentObject jedisPersistentObject,List<String> parentKeys,Map<String,Object> excludeSaveMap,Object jedisCommands){
		if(null!=excludeSaveMap.get(jedisPersistentObject.toString())){
			return ;
		}
		if(null!=parentKeys && parentKeys.size()>0){
			for(String parentKey : parentKeys){
				List<Field> fieldList = new ArrayList<Field>();
				Class pclazz = jedisPersistentObject.getClass();
				ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
				String key = null;
				for(Field field : fieldList){
					RedisKey redisKey = field.getAnnotation(RedisKey.class);
					if(null!=redisKey){
						key = ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject).toString();
						break; //目前只支持单主键
					}
				}
				parentKey = parentKey +":"+ pclazz.getSimpleName()+":"+key;
				System.out.println(parentKey);
				if(JedisCluster.class.isAssignableFrom(jedisCommands.getClass())){
					JedisCluster binaryJedisCluster = (JedisCluster) jedisCommands;
					binaryJedisCluster.set(parentKey.getBytes(), SerializeUtil.serializeByXson(jedisPersistentObject));
				}else{
					Jedis jedis = (Jedis) jedisCommands;
					jedis.set(parentKey.getBytes(), SerializeUtil.serializeByXson(jedisPersistentObject));
				}
				excludeSaveMap.put(jedisPersistentObject.toString(),empty);
			}
		}else{
			List<Field> fieldList = new ArrayList<Field>();
			Class pclazz = jedisPersistentObject.getClass();
			ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
			String key = null;
			for(Field field : fieldList){
				RedisKey redisKey = field.getAnnotation(RedisKey.class);
				if(null!=redisKey){
					key = ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject).toString();
					break; //目前只支持单主键
				}
			}
			if(JedisCluster.class.isAssignableFrom(jedisCommands.getClass())){
				JedisCluster binaryJedisCluster = (JedisCluster) jedisCommands;
				binaryJedisCluster.set(key.getBytes(), SerializeUtil.serializeByXson(jedisPersistentObject));
			}else{
				key = pclazz.getName()+":"+key;
				System.out.println(key);
				Jedis jedis = (Jedis) jedisCommands;
				jedis.set(key.getBytes(), SerializeUtil.serializeByXson(jedisPersistentObject));
			}
			excludeSaveMap.put(jedisPersistentObject.toString(),empty);
		}
	}
	/**
	 * 保存字符串数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @since 	上午11:00:06 2015-8-3
	 * @param jedisPersistentObject
	 * @param parentKeys
	 * @param excludeSaveMap
	 * @param jedisCommands	
	 *
	 */
	/*private static void saveString(JedisPersistentObject jedisPersistentObject,List<String> parentKeys,Map<String,Object> excludeSaveMap,JedisCommands jedisCommands){
		if(null!=excludeSaveMap.get(jedisPersistentObject.toString())){
			return ;
		}
		if(null!=parentKeys && parentKeys.size()>0){
			for(String parentKey : parentKeys){
				List<Field> fieldList = new ArrayList<Field>();
				Class pclazz = jedisPersistentObject.getClass();
				ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
				String key = null;
				for(Field field : fieldList){
					RedisKey redisKey = field.getAnnotation(RedisKey.class);
					if(null!=redisKey){
						key = ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject).toString();
						break; //目前只支持单主键
					}
				}
				parentKey = parentKey +":"+ pclazz.getSimpleName()+":"+key;
				System.out.println(parentKey);
				JedisCluster binaryJedisCluster = (JedisCluster) jedisCommands;
				binaryJedisCluster.set(parentKey, JsonUtil.toJSON(jedisPersistentObject));
				excludeSaveMap.put(jedisPersistentObject.toString(),empty);
			}
		}else{
			List<Field> fieldList = new ArrayList<Field>();
			Class pclazz = jedisPersistentObject.getClass();
			ReflectUtils.getBeanAllFields(fieldList,pclazz , JedisPersistentObject.class);
			String key = null;
			for(Field field : fieldList){
				RedisKey redisKey = field.getAnnotation(RedisKey.class);
				if(null!=redisKey){
					key = ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject).toString();
					break; //目前只支持单主键
				}
			}
			key = pclazz.getName()+":"+key;
			System.out.println(key);
			Jedis jedis = (Jedis) jedisCommands;
			jedis.set(key, JsonUtil.toJSON(jedisPersistentObject));
			excludeSaveMap.put(jedisPersistentObject.toString(),empty);
		}
	}*/
	private static List<String> getKeys( JedisPersistentObject jedisPersistentObject,List<JedisFieldRedisParentEntity> parentFieldList){
		List<String> keys  = new ArrayList<String> ();
		if(null!=parentFieldList && parentFieldList.size()>0){
			for(JedisFieldRedisParentEntity jfrpe : parentFieldList){
				String key = null;
				List<JedisFieldRedisParentEntity> parentRedisParentList = new ArrayList<JedisFieldRedisParentEntity>();
				parentRedisParentList.add(jfrpe);
				getRedisParentList(jfrpe,parentRedisParentList);
				int length = parentRedisParentList.size()-1;
				if(length>=0){
					for(int i=length;i >= 0;i--){
						JedisFieldRedisParentEntity rep = parentRedisParentList.get(i);
						if(i==length){
							key = rep.getRedisParent().parent().getName()+":"+rep.getRedisKey();
						}else{
							key = key+":"+rep.getRedisParent().parent().getSimpleName()+":"+rep.getRedisKey();
						}
					}
					keys.add(key);
				}
			}
		}
		return keys;
	}
	private static void getRedisParentList(JedisFieldRedisParentEntity jfrpe,List<JedisFieldRedisParentEntity> parentRedisParentList) throws JedisParentEmptyException{
		if(null==jfrpe.getObject()){
			throw new JedisParentEmptyException(new Exception("关联的RedisParent对象空异常"));
		}
		RedisParent redisParent = jfrpe.getRedisParent();
		Class<?> pclazz = redisParent.parent();
		List<Field> fieldList = new ArrayList<Field>();
		ReflectUtils.getBeanAllFields(fieldList, pclazz, JedisPersistentObject.class);
		for(Field field: fieldList){
			RedisParent rep = field.getAnnotation(RedisParent.class);
			if(null!=rep){
				String fieldName = field.getName();
				JedisFieldRedisParentEntity  jedisFieldRedisParentEntity = new JedisFieldRedisParentEntity(rep,(JedisPersistentObject)ReflectUtils.getFieldValue(fieldName, jfrpe.getObject()));
				parentRedisParentList.add(jedisFieldRedisParentEntity);
				getRedisParentList(jedisFieldRedisParentEntity,parentRedisParentList);
			}
			RedisKey rek = field.getAnnotation(RedisKey.class);
			if(null!=rek){
				if(JedisPersistentObject.class.isAssignableFrom(jfrpe.getObject().getClass())){
					Object redisKey = ReflectUtils.getFieldValue(field.getName(), jfrpe.getObject());
					jfrpe.setRedisKey(redisKey.toString());
				}else{
					jfrpe.setRedisKey(jfrpe.getObject().toString());
				}
			}
		}
	}
	private static void getTransientFieldList(JedisPersistentObject jedisPersistentObject,List<Field> fieldList,List<Field> transientFieldList,List<JedisFieldRedisParentEntity> parentFieldList){
		for(Field field :fieldList){
			Object obj = ReflectUtils.getFieldValue(field.getName(), jedisPersistentObject);
			if(null!=obj){
				if( null!=transientFieldList && null!=field.getAnnotation(RedisTransient.class)){
					transientFieldList.add(field);
				}
				RedisParent redisParent = field.getAnnotation(RedisParent.class);
				if(null!=redisParent && JedisPersistentObject.class.isAssignableFrom(obj.getClass())){
					parentFieldList.add(new JedisFieldRedisParentEntity(redisParent,(JedisPersistentObject)obj));
				}else if(null!=redisParent){
					parentFieldList.add(new JedisFieldRedisParentEntity(redisParent,obj));
				}
			}
		}
	}
	public static void main(String[] args) {
		/*Toy toy = new Toy();
		toy.setId(1L);
		Children children = new Children();
		children.setId(1L);
//		toy.setOwner(children);
		
		Parent parent = new Parent();
		parent.setId(1L);
		children.setParent(parent);
		
//		toy.setParentId(parent.getId());
		
		
//		saveAllRefrenceObject(toy,null);
		saveSelfObject(toy,null);
		saveSelfObject(children,null);
		saveSelfObject(parent,null);*/
		
		
		
	}

}
