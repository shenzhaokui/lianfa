package com.sinnk.web.common.extend;

import javax.servlet.ServletContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

public class MyContextLoaderListener extends ContextLoaderListener {

	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext arg0) {
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 " + "Lianfa" + "  - Powered By http://sinnk.com\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return super.initWebApplicationContext(arg0);
	}

}
