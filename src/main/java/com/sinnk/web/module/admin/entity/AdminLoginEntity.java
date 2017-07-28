package com.sinnk.web.module.admin.entity;

import java.util.Date;

import com.sinnk.web.common.entity.DataEntity;

public class AdminLoginEntity extends DataEntity<AdminLoginEntity> {

	private static final long serialVersionUID = 1L;
	
	private String adminId;

	private Date loginDate;

	private String loginIp;

	private String loginType;

	private String loginStatus;
	

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
