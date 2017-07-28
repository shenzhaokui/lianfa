package com.sinnk.web.module.user.entity;

import java.util.Date;
import java.util.List;
import com.sinnk.web.common.entity.DataEntity;

public class OrderEntity extends DataEntity<OrderEntity> {

	private static final long serialVersionUID = 1L;

	/*
	 * 订单的用户ID
	 */
	private String userId;

	/*
	 * 用户下单的IP地址
	 */
	private String userIp;

	/*
	 * 订单总金额
	 */
	private double totalSum;

	/*
	 * 订单实际支付的总金额
	 */
	private double paymentSum;

	/*
	 * 支付时间戳
	 */
	private Date paymentDate;

	/*
	 * 订单的收件人姓名
	 */
	private String deliveryName;

	/*
	 * 订单收件人联系手机
	 */
	private String deliveryPhone;

	/*
	 * 订单收件人地址
	 */
	private String deliveryAddress;

	/*
	 * 订单状态
	 */
	private String orderStatus;

	/*
	 * 订单详情列表
	 */
	private List<OrderDetailEntity> orderDetailEntityList;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public double getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

	public double getPaymentSum() {
		return paymentSum;
	}

	public void setPaymentSum(double paymentSum) {
		this.paymentSum = paymentSum;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderDetailEntity> getOrderDetailEntityList() {
		return orderDetailEntityList;
	}

	public void setOrderDetailEntityList(List<OrderDetailEntity> orderDetailEntityList) {
		this.orderDetailEntityList = orderDetailEntityList;
	}

}
