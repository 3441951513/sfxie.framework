package com.sfxie.extension.redis.redisson.transaction;

public interface IRedissonTransactionOperator {

	public void rollbackAction(Object oldValue,Object newValue);
}
