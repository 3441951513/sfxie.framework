package com.sfxie.ui.extjs5.spring.mvc.interceptor;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cniemp.extension.mybatis.interceptor.QueryConditionEntity;
import com.cniemp.extension.mybatis.interceptor.QueryGroupConditionEntity;
import com.sfxie.ui.extjs5.annotation.ExtjsGridDataHandle;
import com.sfxie.ui.extjs5.mybatis.MybatisQueryConditionThreadLocal;
import com.cniemp.utils.jacson.JSONUtil;

/**
 * 专门为extjs设计的拦截器,用于生成外带查询参数列表
 * @author xieshengfeng
 * @since 2015-06-01
 *
 */
public class ExtjsSpringMvcInterceprot implements HandlerInterceptor { 

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//首先判断是否是Debug模式(全局)，如果否则使拦截器失效
		if(handler instanceof HandlerMethod){  
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			ExtjsGridDataHandle extjsSpringMvcHandle = handlerMethod.getMethod().getAnnotation(ExtjsGridDataHandle.class);
			if(null!=extjsSpringMvcHandle){
				createMybatisQueryConditionList(request);
			}
			return true;
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(111);
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println(111);

	}

	/**
	 * 构造外带查询参数列表
	 * @param request
	 */
	private void createMybatisQueryConditionList(HttpServletRequest request){
		
//		String language = (String) paramMap.get("language");
//		boolean forceFit = (Boolean) paramMap.get("forceFit");
		String otherParamMap = request.getParameter("otherParamMap");
		Map paramMap = JSONUtil.fromJSON(otherParamMap, Map.class);
		List<String> usingFields = JSONUtil.listFromJSON( paramMap.get("usingFields").toString());
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		Integer start = Integer.parseInt(request.getParameter("start"));
		Object queryCondition = request.getParameter("queryCondition");
		MybatisQueryConditionThreadLocal.get().setLimit(limit);
		MybatisQueryConditionThreadLocal.get().setStart(start);
		MybatisQueryConditionThreadLocal.get().setForceFit(new Boolean(paramMap.get("forceFit").toString()));
		MybatisQueryConditionThreadLocal.get().setUsingFields(usingFields);
		
		MybatisQueryConditionThreadLocal.get().getQueryGroupConditionEntityList().add(new QueryGroupConditionEntity("group1",QueryConditionEntity.CONDITIONTYPE_AND));
		
		MybatisQueryConditionThreadLocal.addQueryConditionEntity(new QueryConditionEntity("name","name",String.class,QueryConditionEntity.OPERATOR_LIKE));
		MybatisQueryConditionThreadLocal.addQueryConditionEntity(new QueryConditionEntity("id","id",Integer.class,QueryConditionEntity.OPERATOR_EQUAL));
		
		/**
		 * QueryConditionEntity
		 * @param fieldName
		 * @param fieldClass
		 * @param dbFieldName
		 * @param operator
		 * @param coditionType
		 * @param groupName
		 */
		MybatisQueryConditionThreadLocal.addQueryConditionEntity(new QueryConditionEntity("name",String.class,"name",QueryConditionEntity.OPERATOR_LIKE,QueryConditionEntity.CONDITIONTYPE_AND,"group1"));
		MybatisQueryConditionThreadLocal.addQueryConditionEntity(new QueryConditionEntity("id",String.class,"name",QueryConditionEntity.OPERATOR_EQUAL,QueryConditionEntity.CONDITIONTYPE_AND,"group1"));
	}
	

}
