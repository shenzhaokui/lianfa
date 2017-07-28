package com.sinnk.web.module.shop.status.dao;

import org.apache.ibatis.annotations.Param;
import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.shop.status.entity.StatusEntity;

@MyBatisDao
public interface StatusDao extends CrudDao<StatusEntity> {

	/**
	 * 获取当前用户总深度
	 * 
	 * @return
	 */
	public long getCurrentTotalUserMaxDepth();

	/**
	 * 获取当前用户总数
	 * 
	 * @return
	 */
	public long getCurrentTotalUserAmount();

	/**
	 * 设置当前用户深度
	 * 
	 * @param depth
	 * @return
	 */
	public int setCurrentTotalUserMaxDepth(@Param("depth") long depth);

	/**
	 * 设置当前用户总数
	 * 
	 * @param amount
	 * @return
	 */
	public int setCurrentTotalUserAmount(@Param("amount") long amount);

}
