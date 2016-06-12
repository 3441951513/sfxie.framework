package com.sfxie.extension.spring4.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sfxie.extension.spring4.mvc.context.Context;



public class SpringMvcController {
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
