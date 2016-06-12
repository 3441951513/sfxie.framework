package com.sfxie.cache;



import com.sfxie.base.BaseTest;
import com.sfxie.extension.memcached.service.ICacheApi;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: wquan
 * Date: 13-7-31
 * Time: 下午3:47
 */
public class CacheApiImplTest extends BaseTest {
    private ICacheApi cacheApi;
    @Resource(name = "cacheApi")
    public void setCacheApi(ICacheApi cacheApi) {
        this.cacheApi = cacheApi;
    }

    @Test
    public void removeAll()throws Exception{
        cacheApi.removeAll();
    }
    @Test
    public void add()throws Exception{
        cacheApi.add("a",0,"aaaaa");
        System.out.println(cacheApi.get("a")+"======");
        System.out.println(cacheApi.get("a")+"======");
        System.out.println(cacheApi.get("a")+"======");
        System.out.println(cacheApi.get("a")+"======");
    }

}
