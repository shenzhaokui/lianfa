package com.sinnk.web.module.shop.product.dao;

import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.shop.product.entity.ProductThumbnailEntity;

@MyBatisDao
public interface ProductThumbnailDao extends CrudDao<ProductThumbnailEntity> {

	public int delete(String id);

}
