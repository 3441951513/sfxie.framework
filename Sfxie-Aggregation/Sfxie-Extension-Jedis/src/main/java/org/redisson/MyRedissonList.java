package org.redisson;

import io.netty.util.concurrent.Future;

import java.util.Collection;

import org.redisson.CommandExecutor;
import org.redisson.RedissonList;

import com.sfxie.extension.redis.redisson.transaction.IRedissonTransactionOperator;

public class MyRedissonList<V> extends RedissonList<V> {
	
	public IRedissonTransactionOperator redissonTransactionOperator;
	
	
	protected MyRedissonList(CommandExecutor commandExecutor, String name) {
		super(commandExecutor, name);
	}

	@Override
	public void add(int index, V element) {
		super.add(index, element);
	}

	@Override
	public boolean add(V e) {
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends V> c) {
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends V> arg1) {
		return super.addAll(arg0, arg1);
	}

	@Override
	public Future<Boolean> addAllAsync(Collection<? extends V> c) {
		return super.addAllAsync(c);
	}

	@Override
	public Future<Boolean> addAsync(V e) {
		return super.addAsync(e);
	}

	@Override
	public V remove(int index) {
		return super.remove(index);
	}

	@Override
	protected boolean remove(Object o, int count) {
		return super.remove(o, count);
	}

	@Override
	public boolean remove(Object o) {
		return super.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	@Override
	public Future<Boolean> removeAllAsync(Collection<?> c) {
		return super.removeAllAsync(c);
	}

	@Override
	protected Future<Boolean> removeAsync(Object o, int count) {
		return super.removeAsync(o, count);
	}

	@Override
	public Future<Boolean> removeAsync(Object o) {
		return super.removeAsync(o);
	}

	@Override
	public V set(int index, V element) {
		return super.set(index, element);
	}

	@Override
	public Future<V> setAsync(int index, V element) {
		return super.setAsync(index, element);
	}

	public IRedissonTransactionOperator getRedissonTransactionOperator() {
		return redissonTransactionOperator;
	}

	public void setRedissonTransactionOperator(
			IRedissonTransactionOperator redissonTransactionOperator) {
		this.redissonTransactionOperator = redissonTransactionOperator;
	}

	
	
}
