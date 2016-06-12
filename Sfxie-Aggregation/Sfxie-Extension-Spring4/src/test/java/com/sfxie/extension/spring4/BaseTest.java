package com.sfxie.extension.spring4;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * spring测试基础类
 * @author xieshengfeng
 * @since 2015-07-08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/extension/spring/xml/applicationContext-zk.xml"
//        "classpath:config/spring/ad/applicationContextActions.xml",
//        "classpath:config/spring/ad/applicationContextDaos.xml",
//        "classpath:config/spring/ad/applicationContextServices.xml"
//        "classpath:config/extension/spring/xml/extension-spring.xml"
})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
    
}
