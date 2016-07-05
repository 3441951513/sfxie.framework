package com.sfxie.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sfxie.core.base.IEntity;
import com.sfxie.core.service.IBaseService;
import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.utils.jacson.fasterxml.JsonUtil;

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
public abstract class BaseTest<Service,Entity> extends AbstractTransactionalJUnit4SpringContextTests {
	
	/**	范型的真实类型	*/
	private Class<? extends Service> serviceClass ;
	
	/**	范型的真实类型	*/
//	private Class<? extends Service> entityClass ;
	
	@SuppressWarnings("unchecked")
	public BaseTest() {
		super();
		serviceClass = getGenericType(0);
//		entityClass = getGenericType(1); 
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
    protected Service getService(){
    	return  (Service) applicationContext.getBean(serviceClass);
    }
    
    protected String getUUID(){
    	return UUID.randomUUID().toString();
    }
    /**	生成插入测试实体	*/
    protected abstract Entity getInsertEntity();
    /**	生成更新测试实体	*/
    protected abstract Entity getUpdateEntity();
    
    @Rollback(true)
    @Test
    public void testInsert(){
    	IEntity entity = (IEntity) getInsertEntity() ;
    	if(null!=entity){
    		entity.setCreate_time(new Date());
    		entity.setCreate_user("tester");
    		IBaseService service = (IBaseService) getService();
    		service.insertEntity(entity);
    		LoggerUtil.instance(BaseTest.class).info("成功插入实体："+JsonUtil.toJson(entity));
    	}
    }
    
    @Rollback(true)
    @Test
    public void testUpdate(){
    	IEntity entity = (IEntity) getUpdateEntity() ;
    	if(null!=entity){
    		entity.setCreate_time(new Date());
    		entity.setCreate_user("tester");
    		IBaseService service = (IBaseService) getService();
    		service.insertEntity(entity);
    		LoggerUtil.instance(BaseTest.class).info("成功更新实体："+JsonUtil.toJson(entity));
    	}
    }
}
