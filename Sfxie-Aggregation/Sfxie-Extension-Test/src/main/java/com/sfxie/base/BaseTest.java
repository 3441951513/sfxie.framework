package com.sfxie.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
        "classpath*:config/extension/spring/xml/applicationContext-service-test.xml"
        })
public abstract class BaseTest<T> extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**	范型的真实类型	*/
	private Class<? extends T> clazz ;
	
	@SuppressWarnings("unchecked")
	public BaseTest() {
		super();
		clazz = getGenericType(0);
	}
	/**
	 * 获取范型的真实类型
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Class getGenericType(int index) {
		Type genType = getClass().getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
    @Override
    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
    /**
     * 根据名称获取spring注册的bean
     * @param name
     * @return
     */
    @SuppressWarnings({ "unchecked"})
	protected  <C> C getBeanByName(String name){
    	return (C) applicationContext.getBean(name);
    }

    /**
     * 获取范型对应类型的spring注册的service
     * @return T
     */
    protected T getService(){
    	return  (T) applicationContext.getBean(clazz);
    }
}
