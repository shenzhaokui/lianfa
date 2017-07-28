package com.sinnk.web.module.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.user.entity.OrderDetailEntity;

@MyBatisDao
public interface OrderDetailDao extends CrudDao<OrderDetailEntity> {

	public List<OrderDetailEntity> getListByOrderId(@Param("orderid") String orderId);

}
