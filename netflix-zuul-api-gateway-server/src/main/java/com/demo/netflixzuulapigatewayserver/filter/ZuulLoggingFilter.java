package com.demo.netflixzuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logging = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logging.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
