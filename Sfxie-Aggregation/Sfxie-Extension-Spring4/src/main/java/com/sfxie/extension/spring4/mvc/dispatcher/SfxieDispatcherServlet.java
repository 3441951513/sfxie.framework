package com.sfxie.extension.spring4.mvc.dispatcher;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.sfxie.extension.spring4.mvc.context.Context;

public class SfxieDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Exposes the DispatcherServlet-specific request attributes and delegates to {@link #doDispatch}
	 * for the actual dispatching.
	 */
	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*String dateString = DateHelper.formatLongDate(new Date(BatchNumberHolder.getBatchNumber()));
		Map map = request.getParameterMap();
		if(null!=map){
			LoggerUtil.instance(SfxieDispatcherServlet.class).info("当前访问Url["+dateString+"]: "+request.getRequestURL()+"\t\n访问参数: "+JsonUtil.toJSON(map));
		}*/
		response.setCharacterEncoding("UTF-8");
		Context.setRequest(request);
		Context.setResponse(response);
//		Context.retainPostParameter();
		super.doService(request, response);
		BatchNumberHolder.clearBatchNumber();
//		Context.clearRequestAndResponse();
	}
}
