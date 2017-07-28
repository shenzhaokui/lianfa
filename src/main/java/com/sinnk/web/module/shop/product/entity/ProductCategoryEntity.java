package com.sinnk.web.module.shop.product.entity;

import org.hibernate.validator.constraints.NotBlank;

import com.sinnk.web.common.entity.DataEntity;

/**
 * 商品分类实体对象
 * 
 * @author dakui
 *
 */
public class ProductCategoryEntity extends DataEntity<ProductCategoryEntity> {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{validate.form.category.name.blank}")
	private String categoryName;

	@NotBlank(message = "{validate.form.category.parentid.blank}")
	private String parentId;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", parentId=" + parentId + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", id=" + id + ", page=" + page + ", isNewRecord=" + isNewRecord
				+ ", delFlag=" + delFlag + "]";
	}

}
