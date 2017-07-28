package com.sinnk.web.module.user.entity;

import com.sinnk.web.common.entity.DataEntity;

public class OrderDetailEntity extends DataEntity<OrderDetailEntity> {

	private static final long serialVersionUID = 1L;

	/*
	 * 所属订单ID
	 */
	private String orderId;

	/*
	 * 产品ID
	 */
	private String productId;

	/*
	 * 产品名称
	 */
	private String productName;

	/*
	 * 颜色分类ID
	 */
	private String productTypeId;
	
	/*
	 * 颜色分类名称
	 */
	private String typeName;

	/*
	 * 产品颜色分类名称
	 */
	private String productTypeName;

	/*
	 * 该产品的订购数量
	 */
	private int amount;

	/*
	 * 产品缩略图url
	 */
	private String productSmallUrl;

	/*
	 * 产品原价
	 */
	private double productOriginalPrice;

	/*
	 * 产品现价
	 */
	private double productCurrentPrice;
	
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getProductSmallUrl() {
		return productSmallUrl;
	}

	public void setProductSmallUrl(String productSmallUrl) {
		this.productSmallUrl = productSmallUrl;
	}

	public double getProductOriginalPrice() {
		return productOriginalPrice;
	}

	public void setProductOriginalPrice(double productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}

	public double getProductCurrentPrice() {
		return productCurrentPrice;
	}

	public void setProductCurrentPrice(double productCurrentPrice) {
		this.productCurrentPrice = productCurrentPrice;
	}



}
