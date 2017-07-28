package com.sinnk.web.module.shop.product.entity;

import com.sinnk.web.common.entity.DataEntity;

public class ProductCommissionEntity extends DataEntity<ProductCommissionEntity> {

	private static final long serialVersionUID = 1L;

	private String productId;

	private String commissionType;

	private float upOneLevelPercentage;

	private float upTwoLevelPercentage;

	private float upThreeLevelPercentage;

	private float upFourLevelPercentage;

	private float upFiveLevelPercentage;

	private float upOneLevelFixedAmount;

	private float upTwoLevelFixedAmount;

	private float upThreeLevelFixedAmount;

	private float upFourLevelFixedAmount;

	private float upFiveLevelFixedAmount;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCommissionType() {
		return commissionType;
	}

	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	public float getUpOneLevelPercentage() {
		return upOneLevelPercentage;
	}

	public void setUpOneLevelPercentage(float upOneLevelPercentage) {
		this.upOneLevelPercentage = upOneLevelPercentage;
	}

	public float getUpTwoLevelPercentage() {
		return upTwoLevelPercentage;
	}

	public void setUpTwoLevelPercentage(float upTwoLevelPercentage) {
		this.upTwoLevelPercentage = upTwoLevelPercentage;
	}

	public float getUpThreeLevelPercentage() {
		return upThreeLevelPercentage;
	}

	public void setUpThreeLevelPercentage(float upThreeLevelPercentage) {
		this.upThreeLevelPercentage = upThreeLevelPercentage;
	}

	public float getUpFourLevelPercentage() {
		return upFourLevelPercentage;
	}

	public void setUpFourLevelPercentage(float upFourLevelPercentage) {
		this.upFourLevelPercentage = upFourLevelPercentage;
	}

	public float getUpFiveLevelPercentage() {
		return upFiveLevelPercentage;
	}

	public void setUpFiveLevelPercentage(float upFiveLevelPercentage) {
		this.upFiveLevelPercentage = upFiveLevelPercentage;
	}

	public float getUpOneLevelFixedAmount() {
		return upOneLevelFixedAmount;
	}

	public void setUpOneLevelFixedAmount(float upOneLevelFixedAmount) {
		this.upOneLevelFixedAmount = upOneLevelFixedAmount;
	}

	public float getUpTwoLevelFixedAmount() {
		return upTwoLevelFixedAmount;
	}

	public void setUpTwoLevelFixedAmount(float upTwoLevelFixedAmount) {
		this.upTwoLevelFixedAmount = upTwoLevelFixedAmount;
	}

	public float getUpThreeLevelFixedAmount() {
		return upThreeLevelFixedAmount;
	}

	public void setUpThreeLevelFixedAmount(float upThreeLevelFixedAmount) {
		this.upThreeLevelFixedAmount = upThreeLevelFixedAmount;
	}

	public float getUpFourLevelFixedAmount() {
		return upFourLevelFixedAmount;
	}

	public void setUpFourLevelFixedAmount(float upFourLevelFixedAmount) {
		this.upFourLevelFixedAmount = upFourLevelFixedAmount;
	}

	public float getUpFiveLevelFixedAmount() {
		return upFiveLevelFixedAmount;
	}

	public void setUpFiveLevelFixedAmount(float upFiveLevelFixedAmount) {
		this.upFiveLevelFixedAmount = upFiveLevelFixedAmount;
	}
	
	

}
