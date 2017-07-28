package com.sinnk.web.module.user.entity;

import java.util.Date;

import com.sinnk.web.common.entity.DataEntity;

public class UserLoginEntity extends DataEntity<UserLoginEntity> {

	private static final long serialVersionUID = 1L;

	private String userId;

	private Date loginDate;

	private String loginIp;

	private String loginType;

	private String loginStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
