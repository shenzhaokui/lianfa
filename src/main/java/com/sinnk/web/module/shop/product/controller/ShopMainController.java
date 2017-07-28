package com.sinnk.web.module.shop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinnk.web.common.controller.BaseController;

@Controller
@RequestMapping(value = "${shop.url}")
public class ShopMainController extends BaseController {

	/**
	 * 商城默认首页
	 * 
	 * @return
	 */
	@RequestMapping(value = { "index", "" })
	public String shopIndex() {
		return "shop/pc/index";
	}

}
