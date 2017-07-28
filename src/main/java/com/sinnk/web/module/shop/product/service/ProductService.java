package com.sinnk.web.module.shop.product.service;

import java.util.List;

import com.sinnk.web.common.exception.CategoryHasDownLevelCategory;
import com.sinnk.web.common.exception.CategoryHasProductException;
import com.sinnk.web.common.exception.CategoryIdNotExist;
import com.sinnk.web.common.exception.CategoryNameExistException;
import com.sinnk.web.common.exception.ProductNameExistException;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.entity.ProductThumbnailEntity;
import com.sinnk.web.module.shop.product.entity.ProductTypeEntity;

public interface ProductService {
	public int addCategory(ProductCategoryEntity category) throws CategoryNameExistException;

	public List<ProductCategoryEntity> getAllTopCategory();

	public List<ProductCategoryEntity> getAllCategory();

	public ProductCategoryEntity getCategoryById(String id);

	public List<ProductCategoryEntity> getCategoryByParentId(String parentid);

	public int updateCategory(ProductCategoryEntity category) throws CategoryNameExistException;

	public int deleteCategoryById(String id)
			throws CategoryIdNotExist, CategoryHasDownLevelCategory, CategoryHasProductException;

	public ProductEntity getProductById(String id);

	public List<ProductEntity> getAllProduct();

	public int updateProduct(ProductEntity product) throws ProductNameExistException;

	public int addProduct(ProductEntity product);

	public ProductThumbnailEntity getThumbnaiById(String id);

	public int updateThumbnai(ProductThumbnailEntity thumbnail);

	public int deleteThumbnailByid(String id);

	public int addNewThumbnail(ProductThumbnailEntity thumbnail);

	public int addProductType(ProductTypeEntity type);

	public ProductTypeEntity getProductTypeById(String id);

	public int deleteProductTypeById(String id);

	public List<ProductEntity> getProductListByCategoryId(String categoryid);

}
