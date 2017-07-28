package com.sinnk.web.module.user.service.impl;

import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sinnk.web.common.service.BaseService;
import com.sinnk.web.module.user.dao.OrderDao;
import com.sinnk.web.module.user.dao.OrderDetailDao;
import com.sinnk.web.module.user.entity.OrderDetailEntity;
import com.sinnk.web.module.user.entity.OrderEntity;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.exception.OrderDetailBlankException;
import com.sinnk.web.module.user.service.OrderService;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl extends BaseService implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	/**
	 * 根据订单ID获取订单对象
	 */
	@Override
	public OrderEntity getOrderById(String id) {
		OrderEntity order = orderDao.get(id);
		if (null != order) {
			order.setOrderDetailEntityList(orderDetailDao.getListByOrderId(order.getId()));
		}
		return order;
	}

	/**
	 * 创建订单
	 * 
	 * @throws OrderDetailBlankException
	 */
	@Override
	@Transactional(readOnly = false)
	public int createOrder(OrderEntity order) throws OrderDetailBlankException {
		List<OrderDetailEntity> detailList = order.getOrderDetailEntityList();

		Subject subject = SecurityUtils.getSubject();

		System.out.println(subject.getPrincipal());

		if (null == detailList || detailList.size() == 0) {
			throw new OrderDetailBlankException();
		}
		return 0;
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		UserEntity user = (UserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentuser");
		OrderEntity entity = new OrderEntity();
		if (null != user) {
			entity.setUserId(user.getId());
		}
		return orderDao.findAllList(entity);
	}

	@Override
	public List<OrderEntity> getWaitPayOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> getWaitSendOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> getWaitGetOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
