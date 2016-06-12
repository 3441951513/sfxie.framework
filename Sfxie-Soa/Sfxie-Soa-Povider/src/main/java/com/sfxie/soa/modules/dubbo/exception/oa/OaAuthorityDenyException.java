package com.sfxie.soa.modules.dubbo.exception.oa;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;
/**
 * 未授权访问异常
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:34:27 2016年4月22日
 * @example		
 *
 */
public class OaAuthorityDenyException extends BusinessException {

	/**
	 * 未授权访问异常
	 */
	public OaAuthorityDenyException(){
		super("未授权访问...");
	}

}
