package com.sfxie.extension.jedis.transaction;

import java.io.IOException;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import com.sfxie.extension.jedis.client.JedisOperatorFactory;
import com.sfxie.extension.spring4.jedis.IJedisTransaction;

/**
 * 事务管理器
 * @TODO	用于管理事务,主要是通过还原旧对象数据来实现
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:52:22 2015-7-29
 * @example		
 *
 */
public class JedisTransaction implements IJedisTransaction{
	
	private JedisOperatorFactory jedisOperatorFactory;
	
	@Override
	public void rollback(){
		Map<Object,Object> oldDataMap = JedisThreadLocalSnapshot.getOldCacheMap();
		Object jedisCommand = getJedisCommands();
		if(JedisThreadLocalSnapshot.isBeginTransaction() && oldDataMap.size()>0){
			for(Object key : oldDataMap.keySet()){
				Object value = oldDataMap.get(key);
				//对字节进行处理
				if(value.getClass().toString().equals("class [B")){
					if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
						((JedisCluster)jedisCommand).set((byte[])key,(byte[])value );
					}else{
						((Jedis)jedisCommand).set((byte[])key,(byte[])value );
					}
				}
				//对字符串进行处理
				else{
					if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
						((JedisCluster)jedisCommand).set(key.toString(), oldDataMap.get(key).toString() );
					}else{
						((Jedis)jedisCommand).set(key.toString(), oldDataMap.get(key).toString() );
					}
				}
			}
			clear();
			try {
				closeJedisCommand(jedisCommand);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void closeJedisCommand(Object jedisCommand) throws IOException{
		if(JedisCluster.class.isAssignableFrom(jedisCommand.getClass())){
			JedisCluster binaryJedisCluster = (JedisCluster) jedisCommand;
			binaryJedisCluster.close();
		}else{
			Jedis jedis = (Jedis) jedisCommand;
			jedis.close();
		}
	}
	@Override
	public boolean isBeginTransaction() {
		return JedisThreadLocalSnapshot.isBeginTransaction();
	}

	public Object getJedisCommands() {
		return jedisOperatorFactory.getJedisOperator().getJedisCommands();
	}

	public JedisOperatorFactory getJedisOperatorFactory() {
		return jedisOperatorFactory;
	}

	public void setJedisOperatorFactory(JedisOperatorFactory jedisOperatorFactory) {
		this.jedisOperatorFactory = jedisOperatorFactory;
	}

	@Override
	public void clear() {
		JedisThreadLocalSnapshot.release();
	}

	public static void main(String[] args) {
		Object dd = "dd".getBytes();
		System.out.println(dd.getClass().toString().equals("class [B"));
		System.out.println(Byte.class.isAssignableFrom(dd.getClass()));
	}
	
}
