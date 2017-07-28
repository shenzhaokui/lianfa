package com.sinnk.web.common.utils;

import java.util.UUID;

public class IdGen {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

}
