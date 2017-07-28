package com.sinnk.web.module.shop.status.entity;

import com.sinnk.web.common.entity.DataEntity;

public class StatusEntity extends DataEntity<StatusEntity> {

	private static final long serialVersionUID = 1L;

	private long totalDepth;

	private long totalAmount;

	public long getTotalDepth() {
		return totalDepth;
	}

	public void setTotalDepth(long totalDepth) {
		this.totalDepth = totalDepth;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

}
