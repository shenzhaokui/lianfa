package com.sinnk.web.module.shop.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sinnk.web.common.exception.CategoryHasDownLevelCategory;
import com.sinnk.web.common.exception.CategoryHasProductException;
import com.sinnk.web.common.exception.CategoryIdNotExist;
import com.sinnk.web.common.exception.CategoryNameExistException;
import com.sinnk.web.common.exception.ProductNameExistException;
import com.sinnk.web.common.service.BaseService;
import com.sinnk.web.module.shop.product.dao.ProductCategoryDao;
import com.sinnk.web.module.shop.product.dao.ProductDao;
import com.sinnk.web.module.shop.product.dao.ProductThumbnailDao;
import com.sinnk.web.module.shop.product.dao.ProductTypeDao;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;
import com.sinnk.web.module.shop.product.entity.ProductCommissionEntity;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.entity.ProductStockEntity;
import com.sinnk.web.module.shop.product.entity.ProductThumbnailEntity;
import com.sinnk.web.module.shop.product.entity.ProductTypeEntity;
import com.sinnk.web.module.shop.product.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl extends BaseService implements ProductService {

	@Autowired
	private ProductCategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductThumbnailDao thumbnailDao;

	@Autowired
	private ProductTypeDao productTypeDao;

	@Override
	@Transactional(readOnly = false)
	public int addCategory(ProductCategoryEntity category) throws CategoryNameExistException {
		if (categoryDao.getCategoryByName(category.getCategoryName()).size() > 0) {
			throw new CategoryNameExistException();
		}
		category.preInsert();

		String parentid = category.getParentId();
		if (StringUtils.isBlank(parentid) || parentid.equals("0")) {
			category.setParentId("0");
		} else {
			if (null != categoryDao.get(parentid)) {
				category.setParentId(parentid);
			} else {
				category.setParentId("0");
			}
		}

		return categoryDao.insert(category);
	}

	@Override
	public List<ProductCategoryEntity> getAllTopCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllTopCategory();
	}

	@Override
	public ProductCategoryEntity getCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public List<ProductCategoryEntity> getCategoryByParentId(String parentid) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByParentId(parentid);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateCategory(ProductCategoryEntity category) throws CategoryNameExistException {
		category.preUpdate();
		if (categoryDao.getCategoryByName(category.getCategoryName()).size() > 0) {
			throw new CategoryNameExistException();
		}
		return categoryDao.update(category);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteCategoryById(String id)
			throws CategoryIdNotExist, CategoryHasDownLevelCategory, CategoryHasProductException {

		if (null == categoryDao.get(id)) {
			throw new CategoryIdNotExist();
		}

		if (categoryDao.getCategoryByParentId(id).size() > 0) {
			throw new CategoryHasDownLevelCategory();
		}

		if (categoryDao.getProductAmountByCategoryId(id) > 0) {
			throw new CategoryHasProductException();
		}

		return categoryDao.deleteCategoryById(id);
	}

	@Override
	public ProductEntity getProductById(String id) {
		ProductEntity product = productDao.get(id);
		if (null != product) {
			product.setThumbnails(productDao.getThumbnailsByProductId(id));
			product.setTypeList(productTypeDao.getTypeListByProductId(id));
		}
		return product;
	}

	@Override
	public List<ProductEntity> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public List<ProductCategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

	@Override
	@Transactional(readOnly = false)
	public int updateProduct(ProductEntity product) throws ProductNameExistException {
		product.preUpdate();
		productDao.update(product);
		productDao.updateStockMeasurementUnit(product.getMeasurementUnit(), product.getId());
		productDao.updateCommission(product);
		if (product.getThumbnails() != null && product.getThumbnails().size() > 0) {
			// update thumbnail
		}
		return 1;
	}

	@Override
	@Transactional(readOnly = false)
	public int addProduct(ProductEntity product) {
		// TODO Auto-generated method stub

		productDao.insert(product);

		ProductStockEntity stock = new ProductStockEntity();
		stock.preInsert();
		stock.setMeasurementUnit(product.getMeasurementUnit());
		stock.setStock(product.getProductStock());
		stock.setProductId(product.getId());

		productDao.addProductStock(stock);

		ProductCommissionEntity commission = new ProductCommissionEntity();
		commission.preInsert();
		commission.setProductId(product.getId());
		commission.setCommissionType(product.getProductCommissionType());
		commission.setUpOneLevelPercentage(product.getProductUpOneLevelPercentage());
		commission.setUpTwoLevelPercentage(product.getProductUpTwoLevelPercentage());
		commission.setUpThreeLevelPercentage(product.getProductUpThreeLevelPercentage());
		commission.setUpFourLevelPercentage(product.getProductUpFourLevelPercentage());
		commission.setUpFiveLevelPercentage(product.getProductUpFiveLevelPercentage());

		commission.setUpOneLevelFixedAmount(product.getProductUpOneLevelFixedAmount());
		commission.setUpTwoLevelFixedAmount(product.getProductUpTwoLevelFixedAmount());
		commission.setUpThreeLevelFixedAmount(product.getProductUpThreeLevelFixedAmount());
		commission.setUpFourLevelFixedAmount(product.getProductUpFourLevelFixedAmount());
		commission.setUpFiveLevelFixedAmount(product.getProductUpFiveLevelFixedAmount());

		productDao.addProductCommission(commission);

		List<ProductThumbnailEntity> list = product.getThumbnails();

		if (null != list) {
			for (ProductThumbnailEntity thumbnail : list) {
				productDao.addProductThumbnail(thumbnail);
			}
		}

		return 1;
	}

	@Override
	public ProductThumbnailEntity getThumbnaiById(String id) {
		// TODO Auto-generated method stub
		return thumbnailDao.get(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateThumbnai(ProductThumbnailEntity thumbnail) {
		// TODO Auto-generated method stub
		return thumbnailDao.update(thumbnail);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteThumbnailByid(String id) {
		// TODO Auto-generated method stub
		return thumbnailDao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int addNewThumbnail(ProductThumbnailEntity thumbnail) {
		// TODO Auto-generated method stub
		return productDao.addProductThumbnail(thumbnail);
	}

	@Override
	@Transactional(readOnly = false)
	public int addProductType(ProductTypeEntity type) {
		// TODO Auto-generated method stub
		return productTypeDao.insert(type);
	}

	@Override
	public ProductTypeEntity getProductTypeById(String id) {
		// TODO Auto-generated method stub
		return productTypeDao.get(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteProductTypeById(String id) {
		// TODO Auto-generated method stub
		return productTypeDao.deleteProductTypeById(id);
	}

	@Override
	public List<ProductEntity> getProductListByCategoryId(String categoryid) {
		ProductCategoryEntity category = categoryDao.get(categoryid);
		if (category != null && !category.getParentId().equals("0")) {
			return productDao.getProductListByCategoryId(categoryid);
		}
		List<ProductEntity> productList = new ArrayList<ProductEntity>();
		List<ProductCategoryEntity> categoryList = categoryDao.getCategoryByParentId(categoryid);
		for (ProductCategoryEntity item : categoryList) {
			productList.addAll(productDao.getProductListByCategoryId(item.getId()));
		}

		return productList;

	}

}
