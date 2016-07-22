package com.sfxie.extension.mybatis.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.sfxie.data.security.ISqlDecorator;
import com.sfxie.data.security.ISqlSecurity;
import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.ConditionColumn;
import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.SqlDecorator;
import com.sfxie.extension.mybatis.annotation.SqlSecurity;
import com.sfxie.extension.mybatis.inform.AbstractInformInterceptor;
import com.sfxie.extension.mybatis.inform.IInformInterceptor;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.utils.ReflectUtils;
import com.sfxie.utils.StringUtils;

/**
 * mybatis的查询拦截器
 * 已经实现的拦截功能：<br>
 * 	1)	sql监控处理(监控处理时间)<br>
 *  2)	基于Page参数的分页匹配处理<br>
 * @author xiesf
 *
 */
@Intercepts({ @Signature(method = "query", type = Executor.class, args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class QueryInterceptor extends AbstractInformInterceptor implements
		Interceptor {

	public static final Class<? extends Annotation> MYBATISCOLUMN = ColumnName.class;
	public static final Class<? extends Annotation> PARTITIONFIELD = PartitionField.class;
	public static final Class<? extends Annotation> CONDITIONCOLUMN = ConditionColumn.class;
	
    private final static String _sql_regex_query_find = ".*cniemp.mybatis.autosql.find.entity.*";
	/** sql监控列表拦截器名称 */
	private String informInterceptorList = null;
	/** 是否启动sql监控功能 */
	private boolean openSqlInterceptor = false;
	/** sql监控列表拦截器 */
	private List<IInformInterceptor> informInterceptors;
	
	public Object intercept(Invocation invocation) throws Throwable {
		Long startTimeMillionSecord = System.currentTimeMillis();
		try{
			paging(invocation);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		Object result = invocation.proceed();
		if (openSqlInterceptor) {
			Long endTimeMillionSecord = System.currentTimeMillis();
			inform("query", invocation, startTimeMillionSecord,
					endTimeMillionSecord);
		}
		return result;
	}

	/**	分页处理 */
	private void paging(Invocation invocation) throws Throwable {
		// 当前环境 MappedStatement，BoundSql，及sql取得
		StringBuffer sb = new StringBuffer();
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		String originalSql = null;

		// Page对象获取，“信使”到达拦截器！
//		Page page = searchPageWithXpath(boundSql.getParameterObject(), ".","page", "*/page");

		String mapperSQL = boundSql.getSql();
		List<ParameterMapping> parameterMappngList = null;
		
		if(mapperSQL.matches(_sql_regex_query_find)){
			originalSql = interceptorQuery(mapperSQL,parameter);
			/*//sql安全处理
			SqlSecurity sqlScAnnotation = parameter.getClass().getAnnotation(SqlSecurity.class);
			if(null!=sqlScAnnotation){
				ISqlSecurity sqlSc = sqlScAnnotation.securitor().newInstance();
				sqlSc.securitySql(originalSql, parameter);
			}
			//sql安全处理
			
			//sql装潢处理
			SqlDecorator sqlDtAnnotation = parameter.getClass().getAnnotation(SqlDecorator.class);
			if(null!=sqlDtAnnotation){
				if(StringUtils.isEmpty(originalSql)){
					originalSql = boundSql.getSql().trim();
				}
				ISqlDecorator sqlDt = sqlDtAnnotation.decorator().newInstance();
				originalSql = sqlDt.decoratedSql(originalSql,parameter);
			}*/
			originalSql = AutoSqlStatementHandlerInterceptor._sql_regex_query + originalSql;
			//sql装潢处理
			
			if("cniemp.mybatis.autosql.find.entity.List".equals(mapperSQL.trim())){
				parameterMappngList = createQueryParameterMappingList(parameter,mappedStatement);
			}else{
				parameterMappngList = createUpdateParameterMappingList(parameter,mappedStatement);
			}
//			BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), originalSql,parameterMappngList,boundSql.getParameterObject()); 
//            MappedStatement newMs = MappedStatmentHelper.copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql),parameter); 
//            invocation.getArgs()[0]= newMs; 
		}
//		else if (page != null) {
		if(Page.class.isAssignableFrom(parameter.getClass())){
			Page page = (Page) parameter;
			//sql安全处理
			SqlSecurity sqlScAnnotation = parameter.getClass().getAnnotation(SqlSecurity.class);
			if(null!=sqlScAnnotation){
				ISqlSecurity sqlSc = sqlScAnnotation.securitor().newInstance();
				sqlSc.securitySql(originalSql, parameter);
			}
			//sql安全处理
			
			//sql装潢处理
			SqlDecorator sqlDtAnnotation = parameter.getClass().getAnnotation(SqlDecorator.class);
			if(null!=sqlDtAnnotation){
				if(StringUtils.isEmpty(originalSql)){
					originalSql = boundSql.getSql().trim();
				}
				ISqlDecorator sqlDt = sqlDtAnnotation.decorator().newInstance();
				originalSql = sqlDt.decoratedSql(originalSql,parameter);
			}
			//sql装潢处理
			if(null==originalSql){
				originalSql = boundSql.getSql().trim();
			}
//			Object parameterObject = boundSql.getParameterObject();
			// Page对象存在的场合，开始分页处理
			String countSql = getCountSql(originalSql.replace(AutoSqlStatementHandlerInterceptor._sql_regex_query, "")).replaceAll(AutoSqlStatementHandlerInterceptor.PARAMETER_PLACEHOLDER, "?");
			Connection connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
			PreparedStatement countStmt = connection.prepareStatement(countSql);
			BoundSql countBS  = null;
			if(mapperSQL.matches(_sql_regex_query_find)){
				countBS = new BoundSql(mappedStatement.getConfiguration(),countSql ,parameterMappngList,parameter); 
			}else{
				countBS = copyFromBoundSql(mappedStatement, boundSql,parameterMappngList,countSql);
			}
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameter, countBS);
			parameterHandler.setParameters(countStmt);
			ResultSet rs = countStmt.executeQuery();
			int totpage = 0;
			if (rs.next()) {
				totpage = rs.getInt(1);
			}
			rs.close();
			countStmt.close();
			connection.close();

			// 分页计算
			page.setTotalRecord(totpage);

			// 对原始Sql追加limit
			int offset = (page.getPageNo() - 1) * page.getPageSize();
			
			sb.append(originalSql).append(" limit ").append(offset).append(",").append(page.getPageSize());
		}
		if(mapperSQL.matches(_sql_regex_query_find)){
			BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(),sb.toString() ,parameterMappngList,parameter);
			MappedStatement newMs = copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));
			invocation.getArgs()[0] = newMs;
		}else{
			
			BoundSql newBoundSql = copyFromBoundSql(mappedStatement, boundSql,sb.toString());
			MappedStatement newMs = copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));
			invocation.getArgs()[0] = newMs;
		}
	}
	
	private String interceptorQuery(String mapperDBsql,Object param){
		return MapperSqlHelper.getExecuSQL(mapperDBsql, param);
	}
	/**
     * 重新构造增删改sql的参数列表集合
     * @param parameterObject
     * @param mappedStatement
     * @return
     */
    private  List<ParameterMapping> createUpdateParameterMappingList(Object parameterObject,MappedStatement mappedStatement){
//    	Field[] fields = parameterObject.getClass().getDeclaredFields();
    	List<Field> col = new ArrayList<Field>();
		ReflectUtils.getBeanAllFields(col, parameterObject.getClass(), null);
    	List<ParameterMapping>  parameterMappingList = new ArrayList<ParameterMapping> ();
    	for(Field field : col){
    		String fName = field.getName();
    		if (field.isAnnotationPresent(MYBATISCOLUMN)) {
				ColumnName columnName = (ColumnName) field.getAnnotation(MYBATISCOLUMN);
				if (columnName.isKey()) {
					try {
						Class<?> fClass = ReflectUtils.getFieldGenericType(field);
						ParameterMapping.Builder parameterMappingBuilder = new ParameterMapping.Builder(mappedStatement.getConfiguration(),fName,fClass);
						parameterMappingList.add(parameterMappingBuilder.build());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			} 
    	}
     	return parameterMappingList;
    }
    /**
     * 重新构造查询sql的参数列表集合
     * @param parameterObject
     * @param mappedStatement
     * @return
     */
    private  List<ParameterMapping> createQueryParameterMappingList(Object parameterObject,MappedStatement mappedStatement){
//    	Field[] fields = parameterObject.getClass().getDeclaredFields();
    	List<Field> col = new ArrayList<Field>();
		ReflectUtils.getBeanAllFields(col, parameterObject.getClass(), null);
    	List<ParameterMapping>  parameterMappingList = new ArrayList<ParameterMapping> ();
    	for(Field field : col){
    		String fName = field.getName();
    		if (field.isAnnotationPresent(CONDITIONCOLUMN) || field.isAnnotationPresent(PARTITIONFIELD)) {
				try {
					Class<?> fClass = ReflectUtils.getFieldGenericType(field);
					ParameterMapping.Builder parameterMappingBuilder = new ParameterMapping.Builder(mappedStatement.getConfiguration(),fName,fClass);
					parameterMappingList.add(parameterMappingBuilder.build());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} 
    	}
     	return parameterMappingList;
    }
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		if (null == informInterceptorList
				&& null != properties.getProperty("informInterceptorList")) {
			this.informInterceptorList = properties.getProperty("informInterceptorList");
		}
		if (null != properties.getProperty("openSqlInterceptor")) {
			this.openSqlInterceptor = Boolean.parseBoolean(properties.getProperty("openSqlInterceptor"));
		}
	}

	public void setOpenSqlInterceptor(boolean openSqlInterceptor) {
		this.openSqlInterceptor = openSqlInterceptor;
	}

	public List<IInformInterceptor> getInformInterceptors() {
		if (null == informInterceptors) {
			try {
				informInterceptors = Context
						.getSpringBean(this.informInterceptorList);
			} catch (Exception e) {
				LoggerUtil.console(QueryInterceptor.class, e.getMessage());
			}
		}
		return informInterceptors;
	}

	/**
	 * 根据给定的xpath查询Page对象
	 */
	private Page searchPageWithXpath(Object o, String... xpaths) {
		JXPathContext context = JXPathContext.newContext(o);
		Object result;
		for (String xpath : xpaths) {
			try {
				result = context.selectSingleNode(xpath);
			} catch (JXPathNotFoundException e) {
				continue;
			}
			if (result instanceof Page) {
				return (Page) result;
			}
		}
		return null;
	}

	/**
	 * 复制MappedStatement对象
	 */
	private MappedStatement copyFromMappedStatement(MappedStatement ms,
			SqlSource newSqlSource) {
		Builder builder = new Builder(ms.getConfiguration(), ms.getId(),
				newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		if(null!=ms.getKeyProperties()){
			for (String key : ms.getKeyProperties()) {
				builder.keyProperty(key);
			}
		}
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());

		return builder.build();
	}

	/**
	 * 复制BoundSql对象
	 */
	private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql,
			String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
				boundSql.getParameterMappings(), boundSql.getParameterObject());
		for (ParameterMapping mapping : boundSql.getParameterMappings()) {
			String prop = mapping.getProperty();
			if (boundSql.hasAdditionalParameter(prop)) {
				newBoundSql.setAdditionalParameter(prop,
						boundSql.getAdditionalParameter(prop));
			}
		}
		return newBoundSql;
	}
	/**
	 * 复制BoundSql对象
	 */
	private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql,List<ParameterMapping> parameterMappingList,
			String sql) {
		BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
				boundSql.getParameterMappings(), boundSql.getParameterObject());
		if(null!=parameterMappingList){
			for (ParameterMapping mapping : parameterMappingList) {
				String prop = mapping.getProperty();
				if (boundSql.hasAdditionalParameter(prop)) {
					newBoundSql.setAdditionalParameter(prop,
							boundSql.getAdditionalParameter(prop));
				}
			}
		}
		
		return newBoundSql;
	}
	/**
	 * 根据原Sql语句获取对应的查询总记录数的Sql语句
	 */
	private String getCountSql(String sql) {
		return "SELECT COUNT(*) FROM (" + sql + ") aliasForPage";
	}

	public class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

}