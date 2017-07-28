package com.sinnk.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.sinnk.web.common.utils.CookieUtils;
import com.sinnk.web.common.utils.Global;

public class RefferIDInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String refferId = request.getParameter(Global.getRefferFlag());
		if (StringUtils.isNotBlank(refferId)) {
			CookieUtils.setCookie(response, Global.getRefferFlag(), refferId);
		}
		return true;
	}

}
