package com.sinnk.web.common.enums;

public enum LianfaEnum {
	ORDER_STATUS_NEW_CREATE("0"), ORDER_STATUS_PAYED("1"), ACCOUNT_LOCKED("1"), ACCOUNT_UNLOCKED("0"), LOGIN_TYPE_PC(
			"0"), LOGIN_TYPE_MOBILE(
					"1"), LOGIN_SUCCESS("0"), LOGIN_FAIL("1"), USER_TYPE_FREE("0"), USER_TYPE_PAYED("1");

	private String value;

	private LianfaEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
