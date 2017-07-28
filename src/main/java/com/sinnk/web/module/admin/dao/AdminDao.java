package com.sinnk.web.module.admin.dao;

import org.apache.ibatis.annotations.Param;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.admin.entity.AdminEntity;

@MyBatisDao
public interface AdminDao extends CrudDao<AdminEntity> {

	public AdminEntity getAdminByUsername(@Param("username") String username);

	public int lockAccount(AdminEntity admin);

	public int unlockAccount(AdminEntity admin);

}
