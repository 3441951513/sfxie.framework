package com.sfxie.soa.modules.dubbo.filter.security;

import java.util.List;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;
import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.soa.common.request.SecurityObject;
import com.sfxie.soa.modules.dubbo.exception.oa.OaAuthorityDenyException;

/**
 * Oa权限验证过滤器
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午8:35:13 2016年4月21日
 * @example		
 *
 */
public class OaAuthorityFilter implements Filter {

    private IpWhiteList ipWhiteList;

    //dubbo通过setter方式自动注入,即ipWhiteList属性取spring环境中id为ipWhiteList的bean
    public void setIpWhiteList(IpWhiteList ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
    	
//    	if(securityObject){
//    		
//    	}
//    	SecurityObject securityObject  = (SecurityObject) invocation.getArguments()[0];
        if (!ipWhiteList.isEnabled()) {
            LoggerUtil.system(IpWhiteList.class,"白名单禁用");
            return invoker.invoke(invocation);
        }
        String clientIp = RpcContext.getContext().getRemoteHost();
        LoggerUtil.system(IpWhiteList.class,"访问ip为"+clientIp);
        List<String> allowedIps = ipWhiteList.getIpList();
        if (allowedIps.contains(clientIp)) {
            return invoker.invoke(invocation);
        } else {
        	RpcResult rpcResult = new RpcResult();
        	rpcResult.setException(new OaAuthorityDenyException());
            return rpcResult;
        }
    }
}