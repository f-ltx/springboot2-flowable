package com.zzy.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 数据拦截器
 * @author guokaige
 *
 */
@Component
public class DataInterceptor implements HandlerInterceptor {
	
	private static final String REDIRECT_API="redirect";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (null !=modelAndView && null!=modelAndView.getViewName()){
			
     		String viewName = modelAndView.getViewName().toUpperCase();
     		
			if(!viewName.startsWith(DataInterceptor.REDIRECT_API.toUpperCase())){
				//得到当前action的请求路径  
				Map<String,Object> model=modelAndView.getModelMap();
				model.put("base", request.getContextPath());
				
				//url地址
				 String basePathUrl = request.getScheme() + "://"
				               + request.getServerName() + ":"
							   + request.getServerPort()
							   + request.getContextPath() + "/";
				request.setAttribute("basePathUrl", basePathUrl);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	
}