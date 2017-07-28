package com.sinnk.web.common.utils;

import javax.servlet.http.HttpServletRequest;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentUtils {

	/**
	 * 取到用户代理对象
	 * 
	 * @param request
	 * @return
	 */
	public static UserAgent getUserAgent(HttpServletRequest request) {
		return UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
	}

	/**
	 * 获取用户设备类型
	 * 
	 * @param request
	 * @return
	 */
	public static DeviceType getDeviceType(HttpServletRequest request) {
		return getUserAgent(request).getOperatingSystem().getDeviceType();
	}

	/**
	 * 判断用户是否是PC端访问
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isComputer(HttpServletRequest request) {
		return DeviceType.COMPUTER.equals(getDeviceType(request));
	}

	/**
	 * 判断用户是否是手机端访问
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isMobile(HttpServletRequest request) {
		return DeviceType.MOBILE.equals(getDeviceType(request));
	}

	/**
	 * 判断用户是否是平板电脑访问
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isTablet(HttpServletRequest request) {
		return DeviceType.TABLET.equals(getDeviceType(request));
	}

	/**
	 * 判断用户是否是平板或者手机端访问
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isMobileOrTablet(HttpServletRequest request) {
		DeviceType deviceType = getDeviceType(request);
		return DeviceType.MOBILE.equals(deviceType) || DeviceType.TABLET.equals(deviceType);
	}

	/**
	 * 获取用户访问的浏览器类型
	 * 
	 * @param request
	 * @return
	 */
	public static Browser getBrowser(HttpServletRequest request) {
		return getUserAgent(request).getBrowser();
	}

	/**
	 * 判断用户IE浏览器版本是否低于或等于IE8
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isLteIE8(HttpServletRequest request) {
		Browser browser = getBrowser(request);
		return Browser.IE5.equals(browser) || Browser.IE6.equals(browser) || Browser.IE7.equals(browser)
				|| Browser.IE8.equals(browser);
	}

}
