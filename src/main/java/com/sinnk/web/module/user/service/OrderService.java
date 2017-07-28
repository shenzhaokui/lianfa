package com.sinnk.web.module.user.service;

import java.util.List;

import com.sinnk.web.module.user.entity.OrderEntity;
import com.sinnk.web.module.user.exception.OrderDetailBlankException;

public interface OrderService {

	/**
	 * 根据订单ID获取订单实例
	 * 
	 * @param id
	 * @return
	 */
	public OrderEntity getOrderById(String id);

	/**
	 * 创建订单
	 * 
	 * @param order
	 * @return
	 * @throws OrderDetailBlankException
	 */
	public int createOrder(OrderEntity order) throws OrderDetailBlankException;

	/**
	 * 获取当前用户所属的全部订单
	 * 
	 * @return
	 */
	public List<OrderEntity> getAllOrders();

	/**
	 * 获取当前用户所属的待付款订单
	 * 
	 * @return
	 */
	public List<OrderEntity> getWaitPayOrders();

	/**
	 * 获取当前用户所属的待发货订单
	 * 
	 * @return
	 */
	public List<OrderEntity> getWaitSendOrders();

	/**
	 * 获取当前用户所属的待收货订单
	 * 
	 * @return
	 */
	public List<OrderEntity> getWaitGetOrders();

}
