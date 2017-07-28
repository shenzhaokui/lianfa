package com.sinnk.web.module.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.user.entity.UserRoleEntity;

@MyBatisDao
public interface UserRoleDao extends CrudDao<UserRoleEntity> {

	public UserRoleEntity getUserRoleByUidRid(@Param("uid") String uid, @Param("rid") String rid);

	public List<UserRoleEntity> getUserRoleListByUserId(@Param("uid") String uid);

	public List<UserRoleEntity> getUserRoleListByUsername(@Param("username") String username);

}
