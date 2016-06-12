package com.sfxie.extension.memcached.aop;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.sfxie.extension.memcached.CacheApiImpl;
import com.sfxie.extension.memcached.annotation.MemcachedCacheKey;
import com.sfxie.extension.memcached.annotation.MemcachedNotCache;
import com.sfxie.extension.memcached.annotation.MemcachedServiceDataFilter;
import com.sfxie.extension.memcached.service.ICacheResultFilter;
import com.sfxie.extension.memcached.service.MemcachedService;
@Aspect
public class MemcachedAspect {
	
	@Resource
	private CacheApiImpl cacheApi;
	
	
	//匹配在com.sfxie.website.modules.api.service.*.impl.*目录下所有以cache开头的方法
	@Pointcut("execution(* com.sfxie.website.modules.api.service.*.impl.*.cache*(..))")
//	@Pointcut("execution(* com.sfxie.website.modules.*.dao.*.*.cache*(..))")
	private void cacheMethod(){}//定义一个切入点
	
//	@Around("insert() || update() || delete()")
	@Around("cacheMethod()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		Object obj = joinPoint.getTarget();
		if(obj instanceof MemcachedService){ 
			String methodName = joinPoint.getSignature().getName();
			MethodSignature signature = (MethodSignature) joinPoint.getSignature();
			Method method = signature.getMethod();
			Object cacheObj = null;
			
			MemcachedNotCache notCache = method.getAnnotation(MemcachedNotCache.class);
			//如果方法用了不进行cache处理注解,不进行存处理
			if(notCache!=null ){
				cacheObj = joinPoint.proceed();//执行该方法
			}
			//进行缓存处理
			else{
				String cacheKey = obj.getClass().getName()+"."+methodName;
				MemcachedCacheKey nemcachedCacheKey = method.getAnnotation(MemcachedCacheKey.class);
				if(null!=nemcachedCacheKey && !nemcachedCacheKey.cacheKey().equals("")){
					cacheKey = nemcachedCacheKey.cacheKey();
				}
				try{
//					cacheObj = cacheApi.get(cacheKey);
//					cacheApi.delete(cacheKey);
					cacheObj = cacheApi.get(cacheKey);
				}catch(Exception e){
					e.printStackTrace();
				}
				//如果没有缓存,则从service方法中查询数据并且保存到 Memcached中
				if(null==cacheObj){
					Object object = joinPoint.proceed();//执行该方法
					try{
						cacheApi.add(cacheKey, 0, object);
					}catch(Exception e){
						e.printStackTrace();
					}
					cacheObj = object;
				}
			}
			
			////////////////////////////////////////数据过滤///////////////////////////////////////////////
			MemcachedService temp = (MemcachedService) obj;
			ICacheResultFilter cacheResultFilter = temp.getCacheResultFilter();
			if(null!=cacheResultFilter){
				Object[] args = joinPoint.getArgs();
				Object filterObj = cacheResultFilter.filter(methodName, args, cacheObj);
				if(null!=filterObj){
					cacheObj = filterObj; 
				}
			}else{
				MemcachedServiceDataFilter msdf = method.getAnnotation(MemcachedServiceDataFilter.class);
				if(null!=msdf){
					ICacheResultFilter cfilter = msdf.filter().newInstance();
					Object[] args = joinPoint.getArgs();
					Object filterObj = cfilter.filter(methodName, args, cacheObj);
					if(null!=filterObj){
						cacheObj = filterObj; 
					}
				}
			}
			////////////////////////////////////////数据过滤///////////////////////////////////////////////
			return cacheObj;
		}else{
			return joinPoint.proceed();//执行该方法
		}
	}
}
