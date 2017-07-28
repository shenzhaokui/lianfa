package com.sinnk.web.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.sinnk.web.common.utils.UserAgentUtils;

public class DeviceTypeInterceptor implements HandlerInterceptor {

	@Value(value = "${front.url}")
	private String frontUrl;

	@Value(value = "${m.front.url}")
	private String mobileFrontUrl;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView model)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		String requestUri = request.getRequestURI();
		String contexttPath = request.getContextPath();

		if (UserAgentUtils.isMobile(request)) {
			// 如果手机端访问PC端入口，强制跳转
			if (StringUtils.startsWith(requestUri, contexttPath + frontUrl)) {
				response.sendRedirect(StringUtils.replace(requestUri, frontUrl, mobileFrontUrl));
				return false;
			}
		} else {
			// 如果PC端访问手机端的入口，则强行跳回手机端入口
			if (StringUtils.startsWith(requestUri, contexttPath + mobileFrontUrl)) {
				response.sendRedirect(StringUtils.replace(requestUri, mobileFrontUrl, frontUrl));
				return false;
			}
		}

		return true;
	}

}
