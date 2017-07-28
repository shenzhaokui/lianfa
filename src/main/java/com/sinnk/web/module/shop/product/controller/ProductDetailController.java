package com.sinnk.web.module.shop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.exception.ProductNullException;
import com.sinnk.web.module.shop.product.service.ProductService;

@Controller
@RequestMapping(value = "${shop.url}")
public class ProductDetailController extends BaseController {

	@Autowired
	private ProductService productService;

	/**
	 * 商品详情
	 * 
	 * @return
	 * @throws ProductNullException
	 */
	@RequestMapping(value = "item")
	public String showItem(String id, Model model) throws ProductNullException {
		ProductEntity product = productService.getProductById(id);
		if (null == product) {
			throw new ProductNullException();
		}

		model.addAttribute("product", product);
		return "shop/pc/item";
	}

}
