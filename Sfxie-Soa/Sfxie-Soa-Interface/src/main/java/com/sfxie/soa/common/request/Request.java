package com.sfxie.soa.common.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 全局参数请求对象
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:51:28 2016年5月3日
 * @example		
 *
 */
@XmlRootElement
@JsonRootName("request") 
public class Request  extends SecurityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
