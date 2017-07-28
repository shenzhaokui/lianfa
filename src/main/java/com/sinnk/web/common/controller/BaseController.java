package com.sinnk.web.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${admin.url}")
	protected String adminPath;

	@Value("${user.url}")
	protected String userPath;

	@Value("${shop.url}")
	protected String shopPath;


}
