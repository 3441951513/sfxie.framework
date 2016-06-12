package com.sfxie.extension.mybatis.multydatasoure.zookeeper;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import static java.lang.reflect.Proxy.newProxyInstance;
import static org.apache.ibatis.reflection.ExceptionUtil.unwrapThrowable;
import static org.mybatis.spring.SqlSessionUtils.closeSqlSession;
import static org.mybatis.spring.SqlSessionUtils.getSqlSession;
import static org.mybatis.spring.SqlSessionUtils.isSqlSessionTransactional;










import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Properties;
import java.util.Random;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent.Type;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.util.Assert;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.spring4.datasource.multy.DBContextHolder;
import com.sfxie.extension.zookeeper.curator.ZookeeperFactoryBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
 
/**
 * 
 * @TODO	用于多数据源却换
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:47:58 2015-7-27	
 *
 */
public class ZookeeperDatasourceSqlSessionTemplate extends SqlSessionTemplate  implements InitializingBean{
	
	private ZookeeperFactoryBean zookeeperFactoryBean;
	
	
//	private String zookeeperPath;
	/**
	 * key  : zookeeper path
	 * value: zookeeper path's data
	 */
	private static Map<String ,ZookeeperDatasourceEntity> dataSourceMap;
 
    private final SqlSessionFactory sqlSessionFactory;
    private final ExecutorType executorType;
    private final SqlSession sqlSessionProxy;
    private final PersistenceExceptionTranslator exceptionTranslator;
 
    private static Map<Object, SqlSessionFactory>  targetSqlSessionFactorys;
    private static List<String> targetSqlSessionFactorysList;
    private SqlSessionFactory defaultTargetSqlSessionFactory;
    
    private static Random random = new Random();
 
    
    public void setTargetSqlSessionFactorys(Map<Object, SqlSessionFactory> targetSqlSessionFactorys1) {
    	targetSqlSessionFactorys = targetSqlSessionFactorys1;
    }
 
    public Map<Object, SqlSessionFactory> getTargetSqlSessionFactorys() {
    	if(null==targetSqlSessionFactorys){
    		targetSqlSessionFactorys = new HashMap<Object, SqlSessionFactory> ();
    	}
		return targetSqlSessionFactorys;
	}

	public void setDefaultTargetSqlSessionFactory(SqlSessionFactory defaultTargetSqlSessionFactory) {
        this.defaultTargetSqlSessionFactory = defaultTargetSqlSessionFactory;
    }
    public ZookeeperDatasourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        this(sqlSessionFactory, sqlSessionFactory.getConfiguration().getDefaultExecutorType());
    }
 
    public ZookeeperDatasourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
        this(sqlSessionFactory, executorType, new MyBatisExceptionTranslator(sqlSessionFactory.getConfiguration()
                .getEnvironment().getDataSource(), true));
    }
 
    public ZookeeperDatasourceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType,
            PersistenceExceptionTranslator exceptionTranslator) {
        super(sqlSessionFactory, executorType, exceptionTranslator);
        
        this.sqlSessionFactory = sqlSessionFactory;
        this.executorType = executorType;
        this.exceptionTranslator = exceptionTranslator;
        
        this.sqlSessionProxy = (SqlSession) newProxyInstance(
                SqlSessionFactory.class.getClassLoader(),
                new Class[] { SqlSession.class }, 
                new SqlSessionInterceptor());
 
        this.defaultTargetSqlSessionFactory = sqlSessionFactory;
    }
 
    @Override
    public SqlSessionFactory getSqlSessionFactory() {
    	SqlSessionFactory targetSqlSessionFactory = null;
    	//动态切换数据源
    	Map<Object, SqlSessionFactory> targetSqlSessionFactorys = getTargetSqlSessionFactorys();
    	List<String> targetSqlSessionFactorysList = getTargetSqlSessionFactorysList();
    	int length = targetSqlSessionFactorysList.size();
    	if(length > 0){
//    		LoggerUtil.instance(ZookeeperDatasourceSqlSessionTemplate.class).debug("切换数据源开始.....	");
    		targetSqlSessionFactory = targetSqlSessionFactorys.get(targetSqlSessionFactorysList.get(random.nextInt(length)));
    		if (targetSqlSessionFactory != null) {
    			return targetSqlSessionFactory;
    		} else if (defaultTargetSqlSessionFactory != null) {
    			return defaultTargetSqlSessionFactory;
    		} else {
    			Assert.notNull(targetSqlSessionFactorys, "Property 'targetSqlSessionFactorys' or 'defaultTargetSqlSessionFactory' are required");
    			Assert.notNull(defaultTargetSqlSessionFactory, "Property 'defaultTargetSqlSessionFactory' or 'targetSqlSessionFactorys' are required");
    		}
    	}
        return this.sqlSessionFactory;
    }
 
    @Override
    public Configuration getConfiguration() {
        return this.getSqlSessionFactory().getConfiguration();
    }
 
    public ExecutorType getExecutorType() {
        return this.executorType;
    }
 
    public PersistenceExceptionTranslator getPersistenceExceptionTranslator() {
        return this.exceptionTranslator;
    }
 
    /**
     * {@inheritDoc}
     */
    public <T> T selectOne(String statement) {
        return this.sqlSessionProxy.<T> selectOne(statement);
    }
 
    /**
     * {@inheritDoc}
     */
    public <T> T selectOne(String statement, Object parameter) {
        return this.sqlSessionProxy.<T> selectOne(statement, parameter);
    }
 
    /**
     * {@inheritDoc}
     */
    public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
        return this.sqlSessionProxy.<K, V> selectMap(statement, mapKey);
    }
 
    /**
     * {@inheritDoc}
     */
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey) {
        return this.sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey);
    }
 
    /**
     * {@inheritDoc}
     */
    public <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
        return this.sqlSessionProxy.<K, V> selectMap(statement, parameter, mapKey, rowBounds);
    }
 
    /**
     * {@inheritDoc}
     */
    public <E> List<E> selectList(String statement) {
        return this.sqlSessionProxy.<E> selectList(statement);
    }
 
    /**
     * {@inheritDoc}
     */
    public <E> List<E> selectList(String statement, Object parameter) {
        return this.sqlSessionProxy.<E> selectList(statement, parameter);
    }
 
    /**
     * {@inheritDoc}
     */
    public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        return this.sqlSessionProxy.<E> selectList(statement, parameter, rowBounds);
    }
 
    /**
     * {@inheritDoc}
     */
    public void select(String statement, ResultHandler handler) {
        this.sqlSessionProxy.select(statement, handler);
    }
 
    /**
     * {@inheritDoc}
     */
    public void select(String statement, Object parameter, ResultHandler handler) {
        this.sqlSessionProxy.select(statement, parameter, handler);
    }
 
    /**
     * {@inheritDoc}
     */
    public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
        this.sqlSessionProxy.select(statement, parameter, rowBounds, handler);
    }
 
    /**
     * {@inheritDoc}
     */
    public int insert(String statement) {
        return this.sqlSessionProxy.insert(statement);
    }
 
    /**
     * {@inheritDoc}
     */
    public int insert(String statement, Object parameter) {
        return this.sqlSessionProxy.insert(statement, parameter);
    }
 
    /**
     * {@inheritDoc}
     */
    public int update(String statement) {
        return this.sqlSessionProxy.update(statement);
    }
 
    /**
     * {@inheritDoc}
     */
    public int update(String statement, Object parameter) {
        return this.sqlSessionProxy.update(statement, parameter);
    }
 
    /**
     * {@inheritDoc}
     */
    public int delete(String statement) {
        return this.sqlSessionProxy.delete(statement);
    }
 
    /**
     * {@inheritDoc}
     */
    public int delete(String statement, Object parameter) {
        return this.sqlSessionProxy.delete(statement, parameter);
    }
 
    /**
     * {@inheritDoc}
     */
    public <T> T getMapper(Class<T> type) {
        return getConfiguration().getMapper(type, this);
    }
 
    /**
     * {@inheritDoc}
     */
    public void commit() {
        throw new UnsupportedOperationException("Manual commit is not allowed over a Spring managed SqlSession");
    }
 
    /**
     * {@inheritDoc}
     */
    public void commit(boolean force) {
        throw new UnsupportedOperationException("Manual commit is not allowed over a Spring managed SqlSession");
    }
 
    /**
     * {@inheritDoc}
     */
    public void rollback() {
        throw new UnsupportedOperationException("Manual rollback is not allowed over a Spring managed SqlSession");
    }
 
    /**
     * {@inheritDoc}
     */
    public void rollback(boolean force) {
        throw new UnsupportedOperationException("Manual rollback is not allowed over a Spring managed SqlSession");
    }
 
    /**
     * {@inheritDoc}
     */
    public void close() {
        throw new UnsupportedOperationException("Manual close is not allowed over a Spring managed SqlSession");
    }
 
    /**
     * {@inheritDoc}
     */
    public void clearCache() {
        this.sqlSessionProxy.clearCache();
    }
 
    /**
     * {@inheritDoc}
     */
    public Connection getConnection() {
        return this.sqlSessionProxy.getConnection();
    }
 
    /**
     * {@inheritDoc}
     * @since 1.0.2
     */
    public List<BatchResult> flushStatements() {
        return this.sqlSessionProxy.flushStatements();
    }
 
    /**
     * Proxy needed to route MyBatis method calls to the proper SqlSession got from Spring's Transaction Manager It also
     * unwraps exceptions thrown by {@code Method#invoke(Object, Object...)} to pass a {@code PersistenceException} to
     * the {@code PersistenceExceptionTranslator}.
     */
    private class SqlSessionInterceptor implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            final SqlSession sqlSession = getSqlSession(
                    ZookeeperDatasourceSqlSessionTemplate.this.getSqlSessionFactory(),
                    ZookeeperDatasourceSqlSessionTemplate.this.executorType, 
                    ZookeeperDatasourceSqlSessionTemplate.this.exceptionTranslator);
            try {
                Object result = method.invoke(sqlSession, args);
                if (!isSqlSessionTransactional(sqlSession, ZookeeperDatasourceSqlSessionTemplate.this.getSqlSessionFactory())) {
                    // force commit even on non-dirty sessions because some databases require
                    // a commit/rollback before calling close()
                    sqlSession.commit(true);
                }
                return result;
            } catch (Throwable t) {
                Throwable unwrapped = unwrapThrowable(t);
                if (ZookeeperDatasourceSqlSessionTemplate.this.exceptionTranslator != null && unwrapped instanceof PersistenceException) {
                    Throwable translated = ZookeeperDatasourceSqlSessionTemplate.this.exceptionTranslator
                        .translateExceptionIfPossible((PersistenceException) unwrapped);
                    if (translated != null) {
                        unwrapped = translated;
                    }
                }
                throw unwrapped;
            } finally {
                closeSqlSession(sqlSession, ZookeeperDatasourceSqlSessionTemplate.this.getSqlSessionFactory());
            }
        }
    }
    
    private void zookeeperInit() throws Exception{
    	CuratorFramework client = getZookeeperFactoryBean().getObject();
    	MycatDiscovery.initDiscovery(client, new IZookeeperWatchChangeAction(){

			@Override
			public void execute(String path,Type eventType, List<ZookeeperDatasourceEntity> list1) throws Exception {
				List<ZookeeperDatasourceEntity> list = MycatDiscovery.listInstances();
				switch (eventType) {
					case CHILD_ADDED:
						addSqlSessionFactory(path,list);
						break;
					case CHILD_REMOVED:
						removeSqlSessionFactory(path);
						break;
					case CHILD_UPDATED:
						break;
					default:
						break;
				}
			}
    		
    	});
    }

	public static Map<String, ZookeeperDatasourceEntity> getDataSourceMap() {
		if(null==dataSourceMap){
			dataSourceMap = new HashMap<String, ZookeeperDatasourceEntity>();
		}
		return dataSourceMap;
	}

	public ZookeeperFactoryBean getZookeeperFactoryBean() {
		return zookeeperFactoryBean;
	}

	public void setZookeeperFactoryBean(ZookeeperFactoryBean zookeeperFactoryBean) {
		this.zookeeperFactoryBean = zookeeperFactoryBean;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			zookeeperInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addSqlSessionFactory(String path,List<ZookeeperDatasourceEntity> list){
		String configLocation = "config/website/mybatis/definition/mybatis-configuration.xml";
		String mapperLocations ="com/golive/*/modules/**/sql/**.xml";
		Map<Object, SqlSessionFactory> targetSqlSessionFactorys = getTargetSqlSessionFactorys();
		for(ZookeeperDatasourceEntity zkEntity : list){
			if(null==targetSqlSessionFactorys.get(path)){
				AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
				Properties properties = new Properties();
				properties.setProperty("username", zkEntity.getUserName());
				properties.setProperty("password", zkEntity.getPassword());
				properties.setProperty("url", zkEntity.getUrl());
				dataSource.setXaProperties(properties);
				dataSource.setPoolSize(3);
				dataSource.setReapTimeout(20000);
				dataSource.setBorrowConnectionTimeout(60);
				try {
					dataSource.setLoginTimeout(60);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				dataSource.setUniqueResourceName(zkEntity.getUniqueResourceName());
//				dataSource.setXaDataSource(new MysqlXADataSource());
				dataSource.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
				
				SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//				sqlSessionFactoryBean.setConfigLocationString(configLocation);
//				sqlSessionFactoryBean.setMapperLocationsString(mapperLocations);
				sqlSessionFactoryBean.setDataSource(dataSource);
				try{
					targetSqlSessionFactorys.put(path, sqlSessionFactoryBean.getObject());
					getTargetSqlSessionFactorysList().add(path);
				}catch(Exception e){e.printStackTrace();}
			}
		}
	}
	private void ddd(){
		/* <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">  
	        <property name="url" value="jdbc:mysql://127.0.0.1:3306/XXX" />  
	        <property name="username" value="root" />  
	        <property name="password" value="root" />  
	  
	        <property name="maxActive" value="20" />  
	        <property name="initialSize" value="1" />  
	        <property name="maxWait" value="60000" />  
	        <property name="minIdle" value="1" />  
	  
	        <property name="timeBetweenEvictionRunsMillis" value="3000" />  
	        <property name="minEvictableIdleTimeMillis" value="300000" />  
	  
	        <property name="validationQuery" value="SELECT 'x' FROM DUAL" />  
	        <property name="testWhileIdle" value="true" />  
	        <property name="testOnBorrow" value="false" />  
	        <property name="testOnReturn" value="false" />  
	        <!-- mysql 不支持 poolPreparedStatements-->  
	        <!--<property name="poolPreparedStatements" value="true" />-->  
	        <!--<property name="maxPoolPreparedStatementPerConnectionSize" value="20" />-->  
	  
	        <!-- 开启Druid的监控统计功能 -->  
	        <property name="filters" value="stat" />  
	  
	    </bean> */
	}
	private void removeSqlSessionFactory(String path){
		synchronized (targetSqlSessionFactorys) {
			if(null==targetSqlSessionFactorys.get(path)){
				targetSqlSessionFactorys.remove(path);
				targetSqlSessionFactorysList.remove(path);
			}
		}
	}

	public List<String> getTargetSqlSessionFactorysList() {
		if(null==targetSqlSessionFactorysList){
			targetSqlSessionFactorysList = new ArrayList<String> ();
		}
		return targetSqlSessionFactorysList;
	}

	public void setTargetSqlSessionFactorysList(
			List<String> targetSqlSessionFactorysList) {
		this.targetSqlSessionFactorysList = targetSqlSessionFactorysList;
	}
	
}
