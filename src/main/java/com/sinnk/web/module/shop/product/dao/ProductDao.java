package com.sinnk.web.module.shop.product.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.shop.product.entity.ProductCommissionEntity;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.entity.ProductStockEntity;
import com.sinnk.web.module.shop.product.entity.ProductThumbnailEntity;

@MyBatisDao
public interface ProductDao extends CrudDao<ProductEntity> {

	public List<ProductEntity> getAllProduct();

	public List<ProductEntity> getProductListByCategoryId(String categoryid);

	public List<ProductThumbnailEntity> getThumbnailsByProductId(String productid);

	public long getProductAmountByProductName(String name);

	public int updateStockMeasurementUnit(@Param("unit") String unit, @Param("productid") String productid);

	public int updateCommission(ProductEntity product);

	public int addProductStock(ProductStockEntity stock);

	public int addProductCommission(ProductCommissionEntity commission);

	public int addProductThumbnail(ProductThumbnailEntity thumbnail);

}
