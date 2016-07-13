package com.sfxie.extension.spring4.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sfxie.extension.spring4.mvc.context.Context;



public class SpringMvcController {
	/**
	 * 操作成功返回默认对象-有业务意义的返回对象可用自己声明的对象替换(用于返回json格式数据需要)
	 */
	protected static final SuccessObject SUCCESS_OBJECT = new SuccessObject();
	
    protected static final Log logger = LogFactory.getLog(SpringMvcController.class);

    /**
     * 获取用户真实IP地址
     * From： 网络
     */
    public  String getRequestIP() {

        String ip = Context.getRequest().getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getRequest().getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getRequest().getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = Context.getRequest().getRemoteAddr();
        }
        return ip;
    }
}
