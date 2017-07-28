package com.sinnk.web.module.shop.product.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.exception.ProductCategoryNullException;
import com.sinnk.web.module.shop.product.service.ProductService;

@Controller
@RequestMapping(value = "${shop.url}")
public class ProductCategoryController extends BaseController {

	@Autowired
	private ProductService productService;

	/**
	 * 商品分类页
	 * 
	 * @return
	 * @throws ProductCategoryNullException
	 */
	@RequestMapping(value = "category")
	public String showCategory(String id, Model model) throws ProductCategoryNullException {
		ProductCategoryEntity category = productService.getCategoryById(id);
		if (null == category) {
			throw new ProductCategoryNullException();
		}

		ProductCategoryEntity fatherCategory = productService.getCategoryById(category.getParentId());
		List<ProductCategoryEntity> categoryList = null;
		List<ProductEntity> productList = null;
		if (category.getParentId().equals("0")) {
			categoryList = productService.getCategoryByParentId(id);
		} else {
			categoryList = productService.getCategoryByParentId(category.getParentId());
		}
		productList = productService.getProductListByCategoryId(id);
		model.addAttribute("category", category);
		model.addAttribute("fatherCategory", fatherCategory);
		model.addAttribute("list", categoryList);
		model.addAttribute("productList", productList);
		return "shop/pc/category";
	}

}
