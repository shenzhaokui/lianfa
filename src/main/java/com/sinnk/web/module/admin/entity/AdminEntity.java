package com.sinnk.web.module.admin.entity;

import java.util.Date;
import com.sinnk.web.common.entity.DataEntity;

public class AdminEntity extends DataEntity<AdminEntity> {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String openId;

	private String email;

	private String roleName;

	private String locked;
	
	private Date locakedDate;

	private Date unlockDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public Date getUnlockDate() {
		return unlockDate;
	}

	public void setUnlockDate(Date unlockDate) {
		this.unlockDate = unlockDate;
	}

	public Date getLocakedDate() {
		return locakedDate;
	}

	public void setLocakedDate(Date locakedDate) {
		this.locakedDate = locakedDate;
	}

	

}
