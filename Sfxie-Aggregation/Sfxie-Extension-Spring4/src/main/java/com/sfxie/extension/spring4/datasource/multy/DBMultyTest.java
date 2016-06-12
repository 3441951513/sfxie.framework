package com.sfxie.extension.spring4.datasource.multy;
import static org.junit.Assert.*;
import java.sql.DatabaseMetaData;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBMultyTest {
	/*private ApplicationContext context;
    //三个数据源的URL
    private String dataSource1_URL = "jdbc:mysql://183.60.142.163:3306/golivetest?Unicode=true&characterEncoding=utf-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull";
    private String dataSource2_URL = "jdbc:mysql://183.60.142.163:3306/golivetest21?Unicode=true&characterEncoding=utf-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull";
    private SessionFactory mysqlSessionFactory;
    
    
    @Before
    public void setUp() throws Exception {
        // 选择数据源初始化spring
    	DBContextHolder.setDbType(DBType.dataSource);
        //
        String[] xmlFiles = new String[] { 
                "config/spring/applicationContext.xml",
                "applicationContext-hibernate.xml",
                "applicationContext-spring.xml" };
        //
        context = new ClassPathXmlApplicationContext(xmlFiles);
        //
        mysqlSessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }

    @Test
    public void mysqlDataSourceTest() {
        try {

            Session mysqlSession = mysqlSessionFactory.openSession();
            // 获得数据库元数据
            DatabaseMetaData meatData = mysqlSession.connection().getMetaData();

            // 默认启动数据源 dataSource1
            //断言当前数据源URL是否是dataSource1的URL
            String url = meatData.getURL();
            assertEquals(dataSource1_URL, url);

            // 切换到数据源 dataSource2
            DBContextHolder.setDbType(DBType.staticDataSource);
            mysqlSession = mysqlSessionFactory.openSession();
            meatData = mysqlSession.connection().getMetaData();
            //断言当前数据源URL是否是dataSource2的URL
            url = meatData.getURL();
            assertEquals(dataSource2_URL, url );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
