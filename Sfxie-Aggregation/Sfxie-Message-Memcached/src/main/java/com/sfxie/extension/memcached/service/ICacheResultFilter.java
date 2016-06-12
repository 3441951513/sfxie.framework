package com.sfxie.extension.memcached.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 缓存数据过滤接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:07:46 2015年9月7日
 * @example		
 *
 */
public abstract class ICacheResultFilter {
	/**
	 * 过滤缓存数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午4:07:57 2015年9月7日
	 * @param methodName
	 * 			service的当前执行方法名
	 * @param args
	 * 			service方法的参数列表
	 * @param originalResult
	 * 			所有原始数据
	 * @return	
	 *
	 */
	public abstract Object filter(String methodName,Object[] args,Object originalResult);
	/**
	 * 截取列表
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:34:20 2015年9月9日
	 * @param start
	 * 			开始下标
	 * @param limit
	 * 			结束下标
	 * @param originalList
	 * 			源列表
	 * @return	
	 * 			结果列表
	 *
	 */
	protected List<?> spliceList(int start,int limit,List<?> originalList){
		List resultList = new ArrayList();
		int length = 0;
		if((start+limit)<originalList.size()){
			length = start+limit;
		}else{
			length = originalList.size();
		}
		for(;start < length;start++){
			resultList.add(originalList.get(start));
		}
		return resultList;
	}
}
