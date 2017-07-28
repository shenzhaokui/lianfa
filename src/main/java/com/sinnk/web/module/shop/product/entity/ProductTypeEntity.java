package com.sinnk.web.module.shop.product.entity;

import com.sinnk.web.common.entity.DataEntity;

public class ProductTypeEntity extends DataEntity<ProductTypeEntity> {

	private static final long serialVersionUID = 1L;
	
	private String productId;
	
	private String typeName;
	
	private String imgUrl;
	
	
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

}
