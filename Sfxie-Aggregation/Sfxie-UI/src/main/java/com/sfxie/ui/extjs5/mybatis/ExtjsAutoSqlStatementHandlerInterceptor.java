package com.sfxie.ui.extjs5.mybatis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.cniemp.utils.ReflectUtil;

import com.cniemp.extension.mybatis.annotation.MyBatisRepository;
import com.cniemp.extension.mybatis.interceptor.QueryConditionEntity;
import com.cniemp.extension.mybatis.interceptor.QueryGroupConditionEntity;
import com.sfxie.ui.extjs5.annotation.ExtjsMybatisQuery;
/**
 * 
 * @author xieshengfeng
 * @since 20150519
 * @todo  重新设置BoundSql包含cniemp.mybatis.autosql字符串的sql
 *
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class ExtjsAutoSqlStatementHandlerInterceptor implements Interceptor {

	public static final Class<? extends Annotation> MYBATISREPOSITORY = MyBatisRepository.class;
	/** 更新操作标志*/
	public final static String _sql_regex_update = "cniemp.mybatis.autosql.update";
	/** 查询操作标志*/
	public final static String _sql_regex_query = "cniemp.mybatis.autosql.query";
	/** 参数标志*/
	private final static String PARAMETER_PLACEHOLDER = "\\[parameter\\]";
	/** 数据库类型，不同的数据库有不同的分页方法*/
	private String databaseType;
	/** 查询操作的条件类,从前端传过来的参数*/
//	private static IMybatisQueryCondition mybatisQueryCondition ;
	
	

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();
		// 通过反射获取到当前RoutingStatementHandler对象的delegate属性
		StatementHandler delegate = (StatementHandler) ReflectUtil
				.getFieldValue(handler, "delegate");
		// 获取到当前StatementHandler的
		// boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了
		// RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。
		BoundSql boundSql = delegate.getBoundSql();
		// 拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
		if (boundSql.getSql().startsWith(_sql_regex_update)) {
			//执行新增和修改操作
			doSaveOrUpdate(boundSql);
		}else{
			//执行分页函数操作
			doSelectPage(invocation);
		}
		return invocation.proceed();
	}
	private void doSaveOrUpdate(BoundSql boundSql){
		ReflectUtil.setFieldValue(boundSql, "sql", boundSql.getSql().replaceAll(_sql_regex_update, "").replaceAll(PARAMETER_PLACEHOLDER, "?"));
	}
	private void doSelectPage(Invocation invocation){
		//对于StatementHandler其实只有两个实现类，一个是RoutingStatementHandler，另一个是抽象类BaseStatementHandler，
	       //BaseStatementHandler有三个子类，分别是SimpleStatementHandler，PreparedStatementHandler和CallableStatementHandler，
	       //SimpleStatementHandler是用于处理Statement的，PreparedStatementHandler是处理PreparedStatement的，而CallableStatementHandler是
	       //处理CallableStatement的。Mybatis在进行Sql语句处理的时候都是建立的RoutingStatementHandler，而在RoutingStatementHandler里面拥有一个
	       //StatementHandler类型的delegate属性，RoutingStatementHandler会依据Statement的不同建立对应的BaseStatementHandler，即SimpleStatementHandler、
	       //PreparedStatementHandler或CallableStatementHandler，在RoutingStatementHandler里面所有StatementHandler接口方法的实现都是调用的delegate对应的方法。
	       //我们在PageInterceptor类上已经用@Signature标记了该Interceptor只拦截StatementHandler接口的prepare方法，又因为Mybatis只有在建立RoutingStatementHandler的时候
	       //是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
	       RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
	       //通过反射获取到当前RoutingStatementHandler对象的delegate属性
	       StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate");
//	       获取到当前StatementHandler的 boundSql，这里不管是调用handler.getBoundSql()还是直接调用delegate.getBoundSql()结果是一样的，因为之前已经说过了
	       //RoutingStatementHandler实现的所有StatementHandler接口方法里面都是调用的delegate对应的方法。
	       BoundSql boundSql = delegate.getBoundSql();
	       //拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
	       Object parameterObject =  boundSql.getParameterObject();
	       //这里我们简单的通过传入的是Page对象就认定它是需要进行分页操作的。
	       Method method = invocation.getMethod();
	       MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement");
	       String id = mappedStatement.getId();
	       String className = id.substring(0, id.lastIndexOf("."));
	       String methodName = id.substring(id.lastIndexOf(".")+1);
	       Method queryMethod = null;
	       try {
			Class clss = Class.forName(className);
			Method[] methods = clss.getMethods();
			for(Method m : methods){
				if(m.getName().equals(methodName)){
					queryMethod = m;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       if(null!=queryMethod){
		       ExtjsMybatisQuery extjsMybatisQuery = queryMethod.getAnnotation(ExtjsMybatisQuery.class);
		       if (null!=extjsMybatisQuery) {
		    	   Class <?> entityClass = ReflectUtil.getMethodGenericReturnType(queryMethod);
		    	   MybatisQueryConditionThreadLocal.get().setEntityClass(entityClass);
		           //通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
		           //拦截到的prepare方法参数是一个Connection对象
		           Connection connection = (Connection)invocation.getArgs()[0];
		           //获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
	//	           String sql = boundSql.getSql();
		    	   List<ParameterMapping> parameterMappingList = createQueryParameterMappingList(parameterObject,mappedStatement);
		    	   if(null!=parameterMappingList)
		    		   ReflectUtil.setFieldValue(boundSql, "parameterMappings", parameterMappingList);
	//	           String restructQuerySql = restructQuerySql(boundSql);
		           //给当前的page参数对象设置总记录数
		    	   String restructQuerySql =  this.setTotalRecord(parameterObject, mappedStatement,boundSql, connection);
		           //获取分页Sql语句
		           String pageSql = this.getPageSql(restructQuerySql);
		           //利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
		           ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
		       }
	       }else{
	    	    List<ParameterMapping> parameterMappingList = createQueryParameterMappingList(parameterObject,mappedStatement);
	    	    if(null!=parameterMappingList)
	    	    	ReflectUtil.setFieldValue(boundSql, "parameterMappings", parameterMappingList);
	       		String restructQuerySql = restructQuerySql(boundSql);
	       		ReflectUtil.setFieldValue(boundSql, "sql",restructQuerySql);
	       }
	}
	 /**
     * 重新构造查询sql的参数列表集合
     * @param parameterObject
     * @param mappedStatement
     * @return
     */
	private  List<ParameterMapping> createQueryParameterMappingList(Object parameterObject,MappedStatement mappedStatement){
		List<ParameterMapping>  parameterMappingList = null;
		List<QueryConditionEntity> queryConditionEntityList = MybatisQueryConditionThreadLocal.get().getQueryConditionEntityList();
		if(null!=queryConditionEntityList && queryConditionEntityList.size()>0){
	    	parameterMappingList = mappedStatement.getBoundSql(parameterObject).getParameterMappings();
	    	
	    	if(parameterMappingList.size()==0){
	    		parameterMappingList = new ArrayList<ParameterMapping>();
	    	}
	    	Iterator<ParameterMapping> iterator = parameterMappingList.iterator();
	    	//把之前的动态生成的参数列表移除
	    	while(iterator.hasNext()){
	    		if(iterator.next().getMode().equals(ParameterMode.INOUT)){
	    			iterator.remove();
				}
	    	}
	    	//重新构造动态参数列表
//    		List<QueryConditionEntity> queryConditionEntityList = mybatisQueryCondition.getQueryConditionEntityList();
    		if(null!=queryConditionEntityList){
    			for(QueryConditionEntity queryConditionEntity: queryConditionEntityList){
    				Class<?> fClass = queryConditionEntity.getFieldClass();
    				String name = queryConditionEntity.getFieldName();
    				ParameterMapping.Builder parameterMappingBuilder = new ParameterMapping.Builder(mappedStatement.getConfiguration(),name,fClass);
    				parameterMappingBuilder.expression(queryConditionEntity.getOperator());
//    				parameterMappingBuilder.expression(queryConditionEntity.getOperator()+","+queryConditionEntity.getCoditionType());
    				//由于mybatis的ParameterMapping类不可以被继承，并且没有其它成员变量可用
    				//所以只能借用jdbcTypeName这个成员变量来保存QueryConditionEntity的dbFieldName成员变量
    				parameterMappingBuilder.jdbcTypeName(queryConditionEntity.getDbFieldName());
    				//标记此参数是外带的最外层的查询参数
    				parameterMappingBuilder.mode(ParameterMode.INOUT);
    				parameterMappingList.add(parameterMappingBuilder.build());
    			}
    		}
    	}
     	return parameterMappingList;
    }
	
	public static void main(String[] args) {
//		List<QueryGroupConditionEntity> queryGroupConditionEntityList =  MybatisQueryConditionThreadLocal.get().getQueryGroupConditionEntityList();
		
		testGroupCondition();
		
	}
	
	/**
	 * 
	 * @param fieldName
	 * @param fieldClass
	 * @param dbFieldName
	 * @param operator
	 * @param coditionType
	 * @param groupName
	 */
	private static void testGroupCondition(){
		
		
		
		List<QueryConditionEntity> queryConditionEntityList = new ArrayList<QueryConditionEntity> ();
		//////////////////////////////////////////////////////////第一层参数/////////////////////////////////////////////////////////////////
		QueryGroupConditionEntity queryGroupConditionEntity1 = new QueryGroupConditionEntity ("1",QueryConditionEntity.CONDITIONTYPE_AND);
		QueryConditionEntity queryConditionEntity1 = new QueryConditionEntity("field1",String.class,"dbField1",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"1");
		queryConditionEntityList.add(queryConditionEntity1);
		QueryConditionEntity queryConditionEntity2 = new QueryConditionEntity("field2",String.class,"dbField2",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_EMPTY,"1");
		queryConditionEntityList.add(queryConditionEntity2);
		QueryConditionEntity queryConditionEntity3 = new QueryConditionEntity("field3",String.class,"dbField3",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"1");
		queryConditionEntityList.add(queryConditionEntity3);
		//////////////////////////////////////////////////////////第一层参数/////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////第二层参数/////////////////////////////////////////////////////////////////
		QueryGroupConditionEntity queryGroupConditionEntity2 = new QueryGroupConditionEntity ("2",QueryConditionEntity.CONDITIONTYPE_AND);
		queryGroupConditionEntity1.getChildGroup().add(queryGroupConditionEntity2);
		QueryConditionEntity queryConditionEntity4 = new QueryConditionEntity("field4",String.class,"dbField4",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_EMPTY,"2");
		queryConditionEntityList.add(queryConditionEntity4);
		QueryConditionEntity queryConditionEntity5 = new QueryConditionEntity("field5",String.class,"dbField5",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"2");
		queryConditionEntityList.add(queryConditionEntity5);
		//////////////////////////////////////////////////////////第二层参数/////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////第二层参数/////////////////////////////////////////////////////////////////
		QueryGroupConditionEntity queryGroupConditionEntity3 = new QueryGroupConditionEntity ("3",QueryConditionEntity.CONDITIONTYPE_AND);
		queryGroupConditionEntity1.getChildGroup().add(queryGroupConditionEntity3);
		QueryConditionEntity queryConditionEntity6 = new QueryConditionEntity("field6",String.class,"dbField6",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_EMPTY,"3");
		queryConditionEntityList.add(queryConditionEntity6);
		QueryConditionEntity queryConditionEntity7 = new QueryConditionEntity("field7",String.class,"dbField7",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"3");
		queryConditionEntityList.add(queryConditionEntity7);
		//////////////////////////////////////////////////////////第二层参数/////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////第三层参数/////////////////////////////////////////////////////////////////
		QueryGroupConditionEntity queryGroupConditionEntity4 = new QueryGroupConditionEntity ("4",QueryConditionEntity.CONDITIONTYPE_AND);
		queryGroupConditionEntity3.getChildGroup().add(queryGroupConditionEntity4);
		QueryConditionEntity queryConditionEntity8 = new QueryConditionEntity("field8",String.class,"dbField8",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_EMPTY,"4");
		queryConditionEntityList.add(queryConditionEntity8);
		QueryConditionEntity queryConditionEntity9 = new QueryConditionEntity("field9",String.class,"dbField9",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"4");
		queryConditionEntityList.add(queryConditionEntity9);
		//////////////////////////////////////////////////////////第三层参数/////////////////////////////////////////////////////////////////	

		StringBuffer conditionSql = new StringBuffer();
		constructedLevelOneGroupSql(queryGroupConditionEntity1,queryConditionEntityList,conditionSql);
		constructedSubLevelGroupSql(queryGroupConditionEntity1,queryConditionEntityList,conditionSql);
		
		System.out.println(conditionSql);
	}
	private static  void constructedLevelOneGroupSql(QueryGroupConditionEntity queryGroupConditionEntity ,List<QueryConditionEntity> queryConditionEntityList,StringBuffer sql){
		String groupName = queryGroupConditionEntity.getGroupName();
		String coditionType = queryGroupConditionEntity.getCoditionType();
		boolean isFirst = true ;
		for(QueryConditionEntity conditionEntity : queryConditionEntityList){
			if(null!=conditionEntity.getGroupName() && conditionEntity.getGroupName().equals(groupName)){
				if(isFirst){
					isFirst = false;
					sql.append(" ")
					   .append(conditionEntity.getDbFieldName())
					   .append(" ")
					   .append(conditionEntity.getOperator())
					   .append(" ? ")
					   ;
				}else{
					sql.append(" ")
					   .append(coditionType)
					   .append(" ")
					   .append(conditionEntity.getDbFieldName())
					   .append(" ")
					   .append(conditionEntity.getOperator())
					   .append(" ? ")
					   ;
				}
			}
		}
	}
	private static  void constructedSubLevelGroupSql(QueryGroupConditionEntity queryGroupConditionEntity ,List<QueryConditionEntity> queryConditionEntityList,StringBuffer sql){
		/**
		 * 
		    SELECT
				a.*
			FROM
				(SELECT * FROM g_ad g) a
			WHERE
				a. CODE LIKE '%ad%'
			AND (
				(
					a.ID > 5
					OR (
						a. NAME LIKE '%天利时代%'
						AND a.IsQuestion = 1
					)
				)
				AND a. CODE LIKE '%1%'
			)
		  
		 */
		if(null!=queryGroupConditionEntity){
			List<QueryGroupConditionEntity> groupConditionEntityList = queryGroupConditionEntity.getChildGroup();
			if(null!=groupConditionEntityList && groupConditionEntityList.size()>0){
				for(QueryGroupConditionEntity conditionEntityParent : groupConditionEntityList){
					if(null!=conditionEntityParent){
						constructedSubLevelGroupSql(conditionEntityParent,queryConditionEntityList,sql);
					}
				}
			}else{
				String groupName = queryGroupConditionEntity.getGroupName();
				String coditionType = queryGroupConditionEntity.getCoditionType();
				boolean isFirst = true ;
				for(QueryConditionEntity conditionEntity : queryConditionEntityList){
					if(null!=conditionEntity.getGroupName() && conditionEntity.getGroupName().equals(groupName)){
						if(isFirst){
							isFirst = false;
							sql.append(" ")
							   .append(coditionType)
							   .append(" ")
							   .append("(")
							   .append(" ")
							   .append(conditionEntity.getDbFieldName())
							   .append(" ")
							   .append(conditionEntity.getOperator())
							   .append(" ? ")
							   ;
						}else{
							sql.append(" ")
							   .append(coditionType)
							   .append(" ")
							   .append(conditionEntity.getDbFieldName())
							   .append(" ")
							   .append(conditionEntity.getOperator())
							   .append(" ? ")
							   ;
						}
					}
				}
				if(!isFirst){
					sql.append(")");
				}
			}
		}
	}
    /**
     * 重新构造查询操作sql,如果前端没有查询参数传过来,则返回原来的sql.
     * 重新构造的sql是在原来的sql上外面嵌套一层外带前端传过来的参数的查询条件sql
     * @param boundSql
     * @return
     */
	private String restructQuerySql(BoundSql boundSql){
		
		List<QueryGroupConditionEntity> queryGroupConditionEntityList =  MybatisQueryConditionThreadLocal.get().getQueryGroupConditionEntityList();
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Object  parameterObject = boundSql.getParameterObject();
    	StringBuffer querySql = new StringBuffer();
    	String realSql = boundSql.getSql();
    	List<ParameterMapping>  parameterMappingList = boundSql.getParameterMappings();
    	String resultSQL = null;
    	try {
			boolean firstFlag = true;
			Iterator<ParameterMapping> iterator = parameterMappingList.iterator();
	    	//把之前的动态生成的参数列表移除
	    	while(iterator.hasNext()){
	    		ParameterMapping parameterMapping = iterator.next();
	    		if(parameterMapping.getMode().equals(ParameterMode.INOUT)){
					Object value = Ognl.getValue(parameterMapping.getProperty(), parameterObject);
					if(!firstFlag){
						querySql.append(" and ")
						.append(parameterMapping.getJdbcTypeName())
						.append(" ")
						.append(parameterMapping.getExpression())
						.append(getRealValueExpressioin(parameterMapping.getExpression(),value,iterator));
					}else{
						querySql.append(" select * from( ")
						.append(realSql)
						.append(") a ").append(" where ")
						.append(parameterMapping.getJdbcTypeName())
						.append(" ")
						.append(parameterMapping.getExpression())
						.append(getRealValueExpressioin(parameterMapping.getExpression(),value,iterator));
						firstFlag = false;
					}
				}
	    	}
			resultSQL = querySql.toString().equals("")?realSql:querySql.toString();
			System.out.println("restruct sql: "+resultSQL);
		} catch (OgnlException e) {
			e.printStackTrace();
		}
		return resultSQL;
    }
	private Object getRealValueExpressioin(String expressioin,Object value,Iterator<ParameterMapping> iterator){
		if(expressioin.trim().toLowerCase().equals(QueryConditionEntity.OPERATOR_LIKE)){
			iterator.remove();
			return " '%"+value.toString().trim()+"%' ";
		}
		return " ? ";
	}
	/**
     * 拦截器对应的封装原始对象的方法
     */
    public Object plugin(Object target) {
       return Plugin.wrap(target, this);
    }
 
    /**
     * 设置注册拦截器时设定的属性
     */
    public void setProperties(Properties properties) {
       this.databaseType = properties.getProperty("databaseType");
    }
   
    /**
     * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle
     * 其它的数据库都 没有进行分页
     *
     * @param page 分页对象
     * @param sql 原sql语句
     * @return
     */
    private String getPageSql( String sql) {
       StringBuffer sqlBuffer = new StringBuffer(sql);
       if ("mysql".equalsIgnoreCase(databaseType)) {
           return getMysqlPageSql(sqlBuffer);
       } else if ("oracle".equalsIgnoreCase(databaseType)) {
           return getOraclePageSql(sqlBuffer);
       }
       return sqlBuffer.toString();
    }
   
    /**
     * 获取Mysql数据库的分页查询语句
     * @param page 分页对象
     * @param sqlBuffer 包含原sql语句的StringBuffer对象
     * @return Mysql数据库分页语句
     */
    private String getMysqlPageSql(StringBuffer sqlBuffer) {
       //计算第一条记录的位置，Mysql中记录的位置是从0开始的。
    	int start = MybatisQueryConditionThreadLocal.get().getStart();
    	sqlBuffer.append(" limit ").append(start).append(",").append(MybatisQueryConditionThreadLocal.get().getLimit());
    	return sqlBuffer.toString();
    }
   
    /**
     * 获取Oracle数据库的分页查询语句
     * @param page 分页对象
     * @param sqlBuffer 包含原sql语句的StringBuffer对象
     * @return Oracle数据库的分页查询语句
     */
    private String getOraclePageSql( StringBuffer sqlBuffer) {
       //计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
    	
       int start = MybatisQueryConditionThreadLocal.get().getStart();
       sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(MybatisQueryConditionThreadLocal.get().getLimit());
       sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(start);
       //上面的Sql语句拼接之后大概是这个样子：
       //select * from (select u.*, rownum r from (select * from t_user) u where rownum < 31) where r >= 16
       return sqlBuffer.toString();
    }
   
    /**
     * 给当前的参数对象page设置总记录数
     *
     * @param PageMybatis 
     * 			带Condition参数的分页对象
     * @param MappedStatement 
     * 			Mapper映射语句
     * @param Connection 
     * 			当前的数据库连接
     * @return string
     * 		
     */
    private String setTotalRecord(Object parameterObject,
           MappedStatement mappedStatement,BoundSql boundSql, Connection connection) {
       //获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
       //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
//       BoundSql boundSql = mappedStatement.getBoundSql(page);
       //获取到我们自己写在Mapper映射语句中对应的Sql语句
       String restructQuerySql = restructQuerySql(boundSql);
//       String sql = boundSql.getSql();
       //通过查询Sql语句获取到对应的计算总记录数的sql语句
       String countSql = this.getCountSql(restructQuerySql);
       //通过BoundSql获取对应的参数映射
       List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
       //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
       BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, parameterObject);
       //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
       ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, countBoundSql);
       //通过connection建立一个countSql对应的PreparedStatement对象。
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       try {
           pstmt = connection.prepareStatement(countSql);
           //通过parameterHandler给PreparedStatement对象设置参数
           parameterHandler.setParameters(pstmt);
           //之后就是执行获取总记录数的Sql语句和获取结果了。
           rs = pstmt.executeQuery();
           if (rs.next()) {
              int totalRecord = rs.getInt(1);
              //给当前的参数page对象设置总记录数
              MybatisQueryConditionThreadLocal.get().setTotal(totalRecord);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
              if (rs != null)
                  rs.close();
               if (pstmt != null)
                  pstmt.close();
           } catch (SQLException e) {
              e.printStackTrace();
           }
       }
       return restructQuerySql;
    }
   
    /**
     * 根据原Sql语句获取对应的查询总记录数的Sql语句
     * @param sql
     * @return
     */
    private String getCountSql(String sql) {
       
       return "select count(1) from (" + sql + ") a";
    }
	/*public  IMybatisQueryCondition getMybatisQueryCondition() {
		return mybatisQueryCondition;
	}
	public  void setMybatisQueryCondition(
			IMybatisQueryCondition mybatisQueryCondition) {
		AutoSqlStatementHandlerInterceptor.mybatisQueryCondition = mybatisQueryCondition;
	}*/
   

    
}
