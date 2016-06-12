package com.sfxie.extension.redis.redisson.transaction;


public class RedissonThreadLocalSnapshot {
	
	private static RedissonThreadLocalSnapshot instance;
	
	private RedissonThreadLocalSnapshot(){}
	
	public static RedissonThreadLocalSnapshot getInstance(){
		if(null==instance){
			instance = new RedissonThreadLocalSnapshot();
		}
		return instance;
	}
	
}
