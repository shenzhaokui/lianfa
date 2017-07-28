package com.sinnk.web.module.admin.dao;

import java.util.List;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.entity.AdminLoginEntity;

@MyBatisDao
public interface AdminLoginDao extends CrudDao<AdminLoginEntity> {

	public List<AdminLoginEntity> getRecentLoginFailRecord(AdminEntity admin);

}
