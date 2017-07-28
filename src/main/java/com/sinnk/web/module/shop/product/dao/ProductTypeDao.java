package com.sinnk.web.module.shop.product.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.shop.product.entity.ProductTypeEntity;

@MyBatisDao
public interface ProductTypeDao extends CrudDao<ProductTypeEntity> {

	public List<ProductTypeEntity> getTypeListByProductId(@Param("productid") String productId);

	public int deleteProductTypeById(String id);

}
