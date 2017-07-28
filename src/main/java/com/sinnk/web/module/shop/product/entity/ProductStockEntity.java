package com.sinnk.web.module.shop.product.entity;

import com.sinnk.web.common.entity.DataEntity;

public class ProductStockEntity extends DataEntity<ProductStockEntity> {

	private static final long serialVersionUID = 1L;
	
	private String productId;
	
	private String measurementUnit;
	
	private double stock;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}
	
	

}
