package com.sfxie.extension.spring4.mvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfxie.core.exception.FrameworkException;
import com.sfxie.extension.spring4.jedis.JedisTransactionManager;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.extension.spring4.mvc.context.SpringContextHolder;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.extension.spring4.mvc.exception.info.ExceptionInfo;


/**
 * 拥有全局异常处理的控制类
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015-7-14上午10:27:28
 */
public class ExceptionController {
	@Resource
	private ExceptionResponseHandler exceptionResponseHandler;
	/**
	 * 异常处理方法
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler
	public @ResponseBody Object exception(HttpServletRequest request, Exception e) {
		String enviroment = Context.enviroment;
		if(null!=enviroment && !enviroment.equals("product")){
			e.printStackTrace();
		}
		Throwable t = ExceptionInfo.parseException(e);
		Object response ;
		if(t instanceof FrameworkException){
			Integer count = 0;
			notifyListener(t,count);
			//spring mvc类型异常
			if(t instanceof MvcException){
				response = exceptionResponseHandler.mvcExceptionResponse((MvcException)t, request);
			}else{
				response = exceptionResponseHandler.exceptionResponse(e, request);
			}
		}else{
			response = exceptionResponseHandler.exceptionResponse(e, request);
		}
		ExceptionContainer.clearParameters();
		//进行redis数据恢复
		rollbackJedis();
		return response;
	}
	private void notifyListener(Throwable t,Integer count){
		recurveListener(t,count);
	}
	private void recurveListener(Throwable t ,Integer count){
		//最多循环6次
		if(null!=t.getCause() && t.getCause() instanceof MvcException && count<6){
			count ++ ;
			recurveListener(t.getCause(),count);
		}else{
			//获取引起异常的异常
			((MvcException)t).notifyAllListeners();
		}
	}
	private void rollbackJedis(){
		try{
			Object transactionManager = SpringContextHolder.getBeanByClass(JedisTransactionManager.class);
			if(null!=transactionManager){
				JedisTransactionManager jedisTransactionManager = (JedisTransactionManager) transactionManager;
				if(jedisTransactionManager.isBeginTransaction()){
					jedisTransactionManager.rollback();
				}
			}
		}catch(Exception ex){
			;
		}
	}
}
