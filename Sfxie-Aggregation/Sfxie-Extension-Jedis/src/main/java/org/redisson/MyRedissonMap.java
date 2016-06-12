package org.redisson;

import io.netty.util.concurrent.Future;

import java.util.Map;

public class MyRedissonMap<K, V> extends RedissonMap<K, V> {

	protected MyRedissonMap(CommandExecutor commandExecutor, String name) {
		super(commandExecutor, name);
	}

	@Override
	public V remove(Object key) {
		
		return super.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		
		super.putAll(map);
	}

	@Override
	public V putIfAbsent(K key, V value) {
		
		return super.putIfAbsent(key, value);
	}

	@Override
	public Future<V> putIfAbsentAsync(K key, V value) {
		
		return super.putIfAbsentAsync(key, value);
	}

	@Override
	public boolean remove(Object key, Object value) {
		
		return super.remove(key, value);
	}

	@Override
	public Future<Long> removeAsync(Object key, Object value) {
		
		return super.removeAsync(key, value);
	}

	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		
		return super.replace(key, oldValue, newValue);
	}

	@Override
	public Future<Boolean> replaceAsync(K key, V oldValue, V newValue) {
		
		return super.replaceAsync(key, oldValue, newValue);
	}

	@Override
	public V replace(K key, V value) {
		
		return super.replace(key, value);
	}

	@Override
	public Future<V> replaceAsync(K key, V value) {
		
		return super.replaceAsync(key, value);
	}

	@Override
	public Future<V> putAsync(K key, V value) {
		
		return super.putAsync(key, value);
	}

	@Override
	public Future<V> removeAsync(K key) {
		
		return super.removeAsync(key);
	}

	@Override
	public Future<Boolean> fastPutAsync(K key, V value) {
		
		return super.fastPutAsync(key, value);
	}

	@Override
	public boolean fastPut(K key, V value) {
		
		return super.fastPut(key, value);
	}

	@Override
	public Future<Long> fastRemoveAsync(K... keys) {
		
		return super.fastRemoveAsync(keys);
	}

	@Override
	public long fastRemove(K... keys) {
		
		return super.fastRemove(keys);
	}

	@Override
	public V addAndGet(K key, Number value) {

		return super.addAndGet(key, value);
	}

	@Override
	public Future<V> addAndGetAsync(K key, Number value) {
		
		return super.addAndGetAsync(key, value);
	}

	
	
}
