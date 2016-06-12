package com.sfxie.extension.spring4.mvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangquan on 2016/2/1.
 */

public class CibnInterceptorAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Context context = Context.getInstance();
//        context.setRequest(request);
//        context.setResponse(response);
        String serverName=request.getServerName();
//        System.out.println("========"+serverName+"=======");
        //如果请求地址包含“cibntv” 则标记为来自国管请求
        if (serverName.indexOf("cibntv") != -1||serverName.indexOf("183.60.142.163")!=-1
                ||serverName.indexOf("127.0.0.1")!=-1) {
            request.setAttribute("GOLIVE_LHQ_CIBNTV", "yes");
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
