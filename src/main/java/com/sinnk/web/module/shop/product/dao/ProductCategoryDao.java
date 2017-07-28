package com.sinnk.web.module.shop.product.dao;

import java.util.List;

import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;


@MyBatisDao
public interface ProductCategoryDao extends CrudDao<ProductCategoryEntity> {

	public List<ProductCategoryEntity> getCategoryByName(String name);

	public List<ProductCategoryEntity> getAllTopCategory();

	public List<ProductCategoryEntity> getAllCategory();

	public List<ProductCategoryEntity> getCategoryByParentId(String parentid);

	public int deleteCategoryById(String id);

	public long getProductAmountByCategoryId(String categoryid);

}
