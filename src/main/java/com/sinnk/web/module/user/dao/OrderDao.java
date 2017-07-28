package com.sinnk.web.module.user.dao;

import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.user.entity.OrderEntity;

@MyBatisDao
public interface OrderDao extends CrudDao<OrderEntity> {

}
