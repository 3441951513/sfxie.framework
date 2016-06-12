package com.sfxie.extension.redis.redisson.transaction;

import org.redisson.MyRedisson;

import com.sfxie.extension.spring4.jedis.IJedisTransaction;

public class RedissonTransaction implements IJedisTransaction{

	private MyRedisson redisson;
	
	@Override
	public void rollback() {
	}

	public MyRedisson getRedisson() {
		return redisson;
	}

	public void setRedisson(MyRedisson redisson) {
		this.redisson = redisson;
	}

	@Override
	public boolean isBeginTransaction() {
		return false;
	}

	@Override
	public void clear() {
	}
	
	
}
