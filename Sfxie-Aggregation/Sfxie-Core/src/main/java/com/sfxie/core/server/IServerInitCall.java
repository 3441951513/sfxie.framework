package com.sfxie.core.server;

/**
 * 服务器启动时加载
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午8:05:55 2016年2月24日
 * @example		
 *
 */
public interface IServerInitCall {
	/**
	 * 服务器启动时调用方法
	 * @TODO	
	 * @return	
	 * 		返回数据
	 *
	 */
	public <T> T init();
}
