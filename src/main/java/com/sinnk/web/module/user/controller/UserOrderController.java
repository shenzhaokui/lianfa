package com.sinnk.web.module.user.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.entity.ProductTypeEntity;
import com.sinnk.web.module.shop.product.exception.ProductNullException;
import com.sinnk.web.module.shop.product.exception.ProductTypeNullException;
import com.sinnk.web.module.shop.product.service.ProductService;
import com.sinnk.web.module.user.entity.OrderEntity;
import com.sinnk.web.module.user.entity.UserEntity;

@Controller
@RequestMapping(value = "${user.url}")
public class UserOrderController extends BaseController {

	@Autowired
	private ProductService productService;

	/**
	 * 创建单个商品订单
	 * 
	 * @param productid
	 * @param typeid
	 * @param amount
	 * @param model
	 * @return
	 * @throws ProductNullException
	 * @throws ProductTypeNullException
	 */
	@RequiresRoles(value = { "buyer" })
	@RequestMapping(value = "createsingleorder", method = RequestMethod.GET)
	public String createSingleOrder(String productid, String typeid, String amount, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws ProductNullException, ProductTypeNullException {

		int int_amount;

		try {
			int_amount = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			redirectAttributes.addFlashAttribute("error", "商品数量格式不正确");
			return "redirect:/shop/item?id=" + productid;
		}

		if (int_amount < 1) {
			redirectAttributes.addFlashAttribute("error", "商品数量不正确");
			return "redirect:/shop/item?id=" + productid;
		}

		ProductEntity product = productService.getProductById(productid);
		ProductTypeEntity productType = productService.getProductTypeById(typeid);

		if (null == product) {
			redirectAttributes.addFlashAttribute("error", "商品信息不存在");
			return "redirect:/shop/item?id=" + productid;
		}

		if (null == productType) {
			redirectAttributes.addFlashAttribute("error", "商品类型信息不存在");
			return "redirect:/shop/item?id=" + productid;
		}

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.preInsert();
		orderEntity
				.setUserId(((UserEntity) SecurityUtils.getSubject().getSession().getAttribute("currentuser")).getId());
		orderEntity.setUserIp(request.getRemoteAddr());

		return null;
	}

}
