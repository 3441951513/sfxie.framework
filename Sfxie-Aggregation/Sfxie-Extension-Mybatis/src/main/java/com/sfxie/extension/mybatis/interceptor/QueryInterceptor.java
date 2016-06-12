package com.sfxie.extension.mybatis.interceptor;

import java.util.List;
import java.util.Properties;
 









import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.mybatis.inform.AbstractInformInterceptor;
import com.sfxie.extension.mybatis.inform.IInformInterceptor;
import com.sfxie.extension.spring4.mvc.context.Context;
 
@Intercepts( {
       @Signature(method = "query", type = Executor.class, args = {
              MappedStatement.class, Object.class, RowBounds.class,
              ResultHandler.class })})
public class QueryInterceptor extends AbstractInformInterceptor implements Interceptor {
	/** sql监控列表拦截器名称*/
    private String informInterceptorList = null;
    /**	是否启动sql监控功能	*/
    private boolean openSqlInterceptor = false;
    /** sql监控列表拦截器*/
	private List<IInformInterceptor> informInterceptors;
	
    public Object intercept(Invocation invocation) throws Throwable {
    	Long startTimeMillionSecord = System.currentTimeMillis();
    	Object result = invocation.proceed();
    	if(openSqlInterceptor){
    		Long endTimeMillionSecord = System.currentTimeMillis();
    		inform("query",invocation,startTimeMillionSecord,endTimeMillionSecord);
    	}
    	return result;
    }
 
    public Object plugin(Object target) {
       return Plugin.wrap(target, this);
    }
 
    public void setProperties(Properties properties) {
    	if(null==informInterceptorList && null!=properties.getProperty("informInterceptorList")){
    		this.informInterceptorList = properties.getProperty("informInterceptorList");
    	}
    	if(null!=properties.getProperty("openSqlInterceptor")){
    		this.openSqlInterceptor = Boolean.parseBoolean(properties.getProperty("openSqlInterceptor"));
    	}
    }

	public void setOpenSqlInterceptor(boolean openSqlInterceptor) {
		this.openSqlInterceptor = openSqlInterceptor;
	}

	public List<IInformInterceptor> getInformInterceptors() {
		if(null==informInterceptors){
			try{
				informInterceptors = Context.getSpringBean(this.informInterceptorList);
			}catch(Exception e){
				LoggerUtil.console(QueryInterceptor.class,e.getMessage());
			}
		}
		return informInterceptors;
	}
	
    
}