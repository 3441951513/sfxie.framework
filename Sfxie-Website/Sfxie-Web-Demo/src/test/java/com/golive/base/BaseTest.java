package com.sfxie.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * User: wquan
 * Date: 13-6-21
 * Time: 下午4:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
//        "classpath:config/extension/spring/xml/applicationContext.xml"
        "classpath:config/extension/spring/xml/applicationContext-service-test.xml"
//        "classpath:config/extension/memcached/memcache.xml"
        })
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}
