package com.sfxie.extension.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.springframework.stereotype.Service;

import com.sfxie.extension.memcached.service.ICacheApi;

import java.util.concurrent.TimeoutException;


/**
 * User: wquan
 * Date: 13-6-20
 * Time: 下午4:53
 */
@Service
public class CacheApiImpl implements ICacheApi {
    private MemcachedClient memcachedClient;


    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    @Override
    public boolean add(String key, int expire, Object obj) throws MemcachedException, TimeoutException, InterruptedException {
        return memcachedClient.set(key, expire, obj);
    }

    @Override
    public Object get(String key) throws MemcachedException, TimeoutException, InterruptedException {
        return memcachedClient.get(key);
    }

    @Override
    public boolean delete(String key) throws MemcachedException, TimeoutException, InterruptedException {
        return memcachedClient.delete(key);
    }

    @Override
    public boolean replace(String key, int expire, Object obj) throws MemcachedException, TimeoutException, InterruptedException {
        return memcachedClient.replace(key, expire, obj);
    }

    @Override
    public void removeAll() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.flushAll();
    }

    @Override
    public Object getAndTouch(String key, int expire) throws InterruptedException, MemcachedException, TimeoutException {
        return memcachedClient.getAndTouch(key, expire);
    }

    @Override
    public boolean touch(String key, int expire) throws InterruptedException, MemcachedException, TimeoutException {
        return memcachedClient.touch(key, expire);
    }
    @Override
    public long incr(String key,long value) throws MemcachedException, TimeoutException, InterruptedException {
        return memcachedClient.incr(key, value);
    }

}
