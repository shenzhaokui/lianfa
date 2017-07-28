package com.sinnk.web.common.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.common.entity.DataEntity;
import com.sinnk.web.common.entity.Page;

@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {

	@Autowired
	protected D dao;

	/**
	 * 返回单条数据
	 * 
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}

	/**
	 * 返回单条数据
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}

	/**
	 * 分页查询数据列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}

	/**
	 * 查询所有数据列表
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity) {
		return dao.findAllList(entity);
	}

	/**
	 * 获取分页对象
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}

	/**
	 * 持久化数据
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int save(T entity) {
		if (entity.getIsNewRecord()) {
			entity.preInsert();
			return dao.insert(entity);
		} else {
			entity.preUpdate();
			return dao.update(entity);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int delete(T entity) {
		return dao.delete(entity);
	}

}
