package com.sinnk.web.module.shop.product.entity;

import com.sinnk.web.common.entity.DataEntity;

public class ProductThumbnailEntity extends DataEntity<ProductThumbnailEntity> {

	private static final long serialVersionUID = 1L;

	private String productId;

	private String thumbnailUrl;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	@Override
	public String toString() {
		return "Thumbnail [productId=" + productId + ", thumbnailUrl=" + thumbnailUrl + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", id=" + id + ", delFlag=" + delFlag + "]";
	}
	
	

}
