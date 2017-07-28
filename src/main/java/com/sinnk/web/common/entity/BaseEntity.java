package com.sinnk.web.common.entity;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";

	/**
	 * 实体类编号，唯一标示
	 */
	protected String id;

	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;

	/**
	 * 是否是新纪录，默认是False。
	 */
	protected boolean isNewRecord = false;

	/**
	 * 删除标记 (0：正常 1：删除)
	 */
	protected String delFlag;

	public BaseEntity() {
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public BaseEntity(String id) {
		this();
		this.id = id;
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Page<T> getPage() {
		if (null == page) {
			page = new Page<T>();
		}
		return page;
	}

	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}

	public boolean getIsNewRecord() {
		return isNewRecord || StringUtils.isBlank(getId());
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public abstract void preInsert();

	public abstract void preUpdate();

}
