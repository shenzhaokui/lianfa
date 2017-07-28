package com.sinnk.web.common.dao;

import java.util.List;

public interface CrudDao<T> extends BaseDao {

	/**
	 * 获取单条数据对象
	 * 
	 * @param id
	 * @return
	 */
	public T get(String id);

	/**
	 * 获取单条数据对象
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity);

	/**
	 * 获取数据列表
	 * 
	 * 如果需要分页，设置分页对象，entity.setPage(new Page<T>())
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);

	/**
	 * 获取所有数据列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity);

	/**
	 * 插入一条数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(T entity);

	/**
	 * 更新一条数据
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity);

	/**
	 * 删除一条数据
	 * 
	 * 一般是逻辑删除，即更新del_flag字段值为1
	 * 
	 * @param entity
	 * @return
	 */
	public int delete(T entity);

}
