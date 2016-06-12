package com.sfxie.extension.memcached.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.sfxie.extension.mybatis.service.AutoUpdateService;

/**
 * 使用Memcached缓存的service基类.<br>
 * 继承此类的service的以cache开头的方法名都将被拦截并进行缓存处理.<br>
 * 如果以cache开头的方法不想被缓存拦截,可以在方法定义上添加@MemcachedNotCache注解.
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:45:15 2015年9月8日
 * @example		
 *
 */
@Service
public class MemcachedService extends AutoUpdateService {

	private ICacheResultFilter cacheResultFilter;

	public ICacheResultFilter getCacheResultFilter() {
		return cacheResultFilter;
	}

	public void setCacheResultFilter(ICacheResultFilter cacheResultFilter) {
		this.cacheResultFilter = cacheResultFilter;
	}
	/**
	 * 初始方法,会在实例化时被调用,用于设置缓存数据过滤接口<br>
	 * 如果被过滤的方法的过滤值为空,则返回被过滤的方法的初始数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:12:33 2015年9月8日	
	 *
	 */
	@PostConstruct
	protected void initCacheResultFilter(){
		
	}
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
