package com.sinnk.web.module.admin.service;

import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.entity.AdminLoginEntity;

public interface AdminService {

	public AdminEntity getAdminByUsername(String username);

	public int addAdminLoginRecord(AdminLoginEntity adminlogin);

	public boolean isDoLockedAccount(String username);

	public boolean isDoUnLockedAccount(String username);

}
