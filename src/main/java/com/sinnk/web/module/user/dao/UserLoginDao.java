package com.sinnk.web.module.user.dao;

import java.util.List;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.entity.UserLoginEntity;

@MyBatisDao
public interface UserLoginDao extends CrudDao<UserLoginEntity> {
	
	public List<UserLoginEntity> getRecentLoginFailRecord(UserEntity user);
	
}
