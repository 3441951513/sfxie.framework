package com.sfxie.extension.jedis.client;

import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;

import com.sfxie.extension.jedis.query.JedisVagueQuyerEnum;
import com.sfxie.utils.SerializeUtil;
import com.sfxie.utils.XmlUtils;




public class JedisSingleOperator extends AbstractJedisOperator{

	private JedisPool jedisPool;
	
	private void init(){
		
	}
	
	
	@Override
	public JedisCommands getJedisCommands(){
		return jedisPool.getResource();
	}
	
	@Override
	public <T> T getJsonPojo(String key,Class<T> Clazz ) {
		
		return null;
	}

	@Override
	public void setSerializePojo(String fieldName, Object pojo, Integer seconds) {
		
		
	}

	@Override
	public <T> T getSerializePojo(String key,Class<T> Clazz) {
		
		return null;
	}

	@Override
	public <T> List<T> vagueQueryPojo(Class<T> clazz, String key, JedisVagueQuyerEnum sfxieJedisVagueQuyerEnum) {
		
		return null;
	}

	@Override
	public void hsetPojo(String key, Object pojo,String field, Long time) {
		
		
	}
	private Jedis getJedis(){
		return (Jedis) getJedisCommands();
	}

	public void savePojoString(String key, Object pojo){
		Jedis jedis = getJedis();
		String value = getPojoString(pojo);
		jedis.set(key, value);
		close(jedis);
	}
	public void saveSerializePojo(String key, Object pojo){
		Jedis jedis = getJedis();
		jedis.set(key.getBytes(), getSerializeBytes(pojo));
		close(jedis);
	}
	/**
	 * 获取pojo的字符串
	 * @param pojo
	 * @return
	 * @throws  
	 * @throws Exception 
	 */
	private String getPojoString(Object pojo)  {
		String value = null;
		XmlRootElement xmlRootElement = pojo.getClass().getAnnotation(XmlRootElement.class);
		//保存xml字符串
		if(null!=xmlRootElement){
			try {
				value = XmlUtils.serializerXmlString(pojo);
			} catch (JAXBException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		}else{
			
		}
		return value;
	}
	/**
	 * 获取pojo的字符串
	 * @param pojo
	 * @return
	 */
	private byte[] getSerializeBytes(Object pojo){
		return SerializeUtil.serialize(pojo);
	}
	/**
	 * 关闭连接
	 * @param jedis
	 */
	private void close(Jedis jedis){
		jedis.close();
	}
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	
}
