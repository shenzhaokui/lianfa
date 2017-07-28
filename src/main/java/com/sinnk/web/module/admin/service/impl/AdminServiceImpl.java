package com.sinnk.web.module.admin.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sinnk.web.common.enums.LianfaEnum;
import com.sinnk.web.common.service.BaseService;
import com.sinnk.web.module.admin.dao.AdminDao;
import com.sinnk.web.module.admin.dao.AdminLoginDao;
import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.entity.AdminLoginEntity;
import com.sinnk.web.module.admin.service.AdminService;

@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseService implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminLoginDao adminLoginDao;

	@Override
	public AdminEntity getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByUsername(username);
	}

	@Override
	@Transactional(readOnly = false)
	public int addAdminLoginRecord(AdminLoginEntity adminlogin) {
		// TODO Auto-generated method stub
		return adminLoginDao.insert(adminlogin);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean isDoLockedAccount(String username) {
		AdminEntity admin = adminDao.getAdminByUsername(username);
		if (null == admin) {
			return false;
		}

		List<AdminLoginEntity> list = adminLoginDao.getRecentLoginFailRecord(admin);
		if (null == list || list.size() < 3) {
			return false;
		}

		if (list.get(0).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())
				&& list.get(1).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())
				&& list.get(2).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())) {

			Date firstDate = list.get(2).getCreateDate();
			Date nowDate = new Date();

			if ((nowDate.getTime() - firstDate.getTime()) / 1000 <= 3600) {
				admin.preUpdate();
				admin.setLocked(LianfaEnum.ACCOUNT_LOCKED.getValue());
				admin.setLocakedDate(nowDate);
				admin.setUnlockDate(new Date(firstDate.getTime() + (3600 * 1000)));
				adminDao.lockAccount(admin);
				return true;
			}
		}

		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean isDoUnLockedAccount(String username) {
		AdminEntity admin = adminDao.getAdminByUsername(username);
		if (null == admin) {
			return false;
		}
		admin.preUpdate();
		admin.setLocked(LianfaEnum.ACCOUNT_UNLOCKED.getValue());
		adminDao.unlockAccount(admin);
		return true;
	}

}
