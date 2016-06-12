package com.sfxie.extension.jedis.entity;

import com.sfxie.extension.jedis.annotation.RedisParent;


public class JedisFieldRedisParentEntity {

	private RedisParent redisParent;
	

	private Object object;

	private String redisKey;

	public JedisFieldRedisParentEntity(RedisParent redisParent ,Object object) {
		this.redisParent = redisParent;
		this.object = object;
	}


	public RedisParent getRedisParent() {
		return redisParent;
	}

	public void setRedisParent(RedisParent redisParent) {
		this.redisParent = redisParent;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}


	public String getRedisKey() {
		return redisKey;
	}


	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}
	
}
