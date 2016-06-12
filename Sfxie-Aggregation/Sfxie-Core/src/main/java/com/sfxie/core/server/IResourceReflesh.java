package com.sfxie.core.server;

/**
 * 用于刷新memcached缓存接口定义,主要结合{@link com.sfxie.core.server.IServerInitCall}设计使用.
 * 调用方法如: ApiMemcachedManager.reflesh("sysConfigInit");<br>
 * sysConfigInit是实现了{@link com.sfxie.core.server.IResourceReflesh}
        接口的实现类并且已经注册到spring上下文环境中的bean id.
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:36:37 2016年2月25日
 * @example		
 *
 */
public interface IResourceReflesh {

	/**
	 * 刷新缓存方法体
	 * @TODO	
	 * @return	
	 *
	 */
	public <T> T reflesh();
}
