package com.zhuanglide.admin.interceptor;

import java.util.List;
import java.util.SortedSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zhuanglide.admin.cache.service.ICacheService;
import com.zhuanglide.util.UrlUtils;
import com.zhuanglide.util.WebUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter implements InitializingBean {
	private Logger logger = Logger.getLogger(LoginInterceptor.class);
	private SortedSet<String> excludedUrls;
	
	@Resource(name="redisService")
	private ICacheService redisService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
        // 登陆者信息
        String ip = WebUtils.getIpAddr(request);
        String path = request.getServletPath();
        logger.info("ip[" + ip + "],path[" + request.getContextPath() + path + "]");
        
        // 属于exclude url跳出,不在此url的校验是否登陆,登陆设置登陆的值
        if(!UrlUtils.urlMatch(excludedUrls, path)) {
        	
        	
            return ;
        }
		return true;
	}


	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
}
