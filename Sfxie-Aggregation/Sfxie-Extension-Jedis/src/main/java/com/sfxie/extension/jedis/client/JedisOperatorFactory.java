package com.sfxie.extension.jedis.client;

/**
 * jedis操作redis的工厂类,用于选择具体的{@link com.sfxie.extension.jedis.client.IJedisOperator}类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:57:39 2015-7-30
 * @example		
 *
 */
public class JedisOperatorFactory {
	
	private IJedisOperator jedisOperator;
	
	public IJedisOperator getJedisOperator(){
		return jedisOperator;
	}


	public void setJedisOperator(IJedisOperator jedisOperator) {
		this.jedisOperator = jedisOperator;
	}
	
}
