package com.sinnk.web.common.utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * 全局配置对象
 * 
 * @author Xiaozhuzhu
 *
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("config.properties");

	public static final String SHOW = "1";
	public static final String HIDE = "0";

	public static final String YES = "1";
	public static final String NO = "0";

	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String USERFILES_BASE_URL = "/userfiles/";

	/**
	 * 获取Global对象
	 * 
	 * @return
	 */
	public static Global getInstance() {
		return global;
	}

	/**
	 * 获取配置内容
	 * 
	 * @param key
	 * @return
	 */
	private static String getConfig(String key) {
		String value = map.get(key);
		if (null == value) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	public static String getProjectName(HttpServletRequest request) {
		return RequestContextUtils.findWebApplicationContext(request).getMessage("project.name", null,
				RequestContextUtils.getLocale(request));
	}

	/**
	 * 获取i18n资源文件数据
	 * 
	 * @param request
	 * @param code
	 * @return
	 */
	public static String getLocaleMessage(HttpServletRequest request, String code) {
		return RequestContextUtils.findWebApplicationContext(request).getMessage(code, null, "Null Message",
				RequestContextUtils.getLocale(request));
	}

	public static String getMd5Salt() {
		return getConfig("md5.salt");
	}

	public static int getHashIterations() {
		String iterations = getConfig("md5.hashIterations");
		int ite;
		try {
			ite = Integer.valueOf(iterations);
		} catch (NumberFormatException e) {
			ite = 1;
		}
		if (ite > 5) {
			ite = 2;
		}
		return ite;
	}

	public static String getRefferFlag() {
		return getConfig("reffer.flag");
	}

	public static String getGlobalMsgFlag() {
		return getConfig("GLOBAL_MSG_FLAG");
	}

	public static String getWebUrlPrefix() {
		return getConfig("web.url");
	}

	public static String getUserUrlPrefix() {
		return getConfig("user.url");
	}

	public static String getAdminUrlPrefix() {
		return getConfig("admin.url");
	}

	public static String getShopUrlPrefix() {
		return getConfig("shop.url");
	}

	public static String getForumUrlPrefix() {
		return getConfig("forum.url");
	}

	public static int getPageSize() {
		String pSize = getConfig("page.pageSize");
		int iPsize = 10;
		if (!StringUtils.isNumeric(pSize)) {
			return iPsize;
		}
		try {
			iPsize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			iPsize = 10;
		}

		return iPsize;
	}

}
