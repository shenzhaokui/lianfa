package com.sinnk.web.common.entity;

import java.util.Date;
import com.sinnk.web.common.utils.IdGen;

public class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected Date createDate; // 创建日期
	protected Date updateDate; // 更新日期

	public DataEntity() {
		super();
	}

	public DataEntity(String id) {
		super(id);
	}

	@Override
	public void preInsert() {
		if (this.getIsNewRecord()) {
			this.setId(IdGen.getUUID());
		}
		this.setCreateDate(new Date());
		this.setUpdateDate(this.getCreateDate());
	}

	@Override
	public void preUpdate() {
		this.setUpdateDate(new Date());

	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
