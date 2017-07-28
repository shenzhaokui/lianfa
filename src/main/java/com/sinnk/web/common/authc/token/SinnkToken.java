package com.sinnk.web.common.authc.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class SinnkToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	private String userType;
	private String ip;
	public static final String ADMIN_LOGIN_TYPE = "adminType";
	public static final String USER_LOHIN_TYPE = "userType";

	public SinnkToken(String username, String password, boolean rememberMe, String host, String userType, String ip) {
		super(username, password, rememberMe, host);
		this.userType = userType;
		this.ip = ip;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
