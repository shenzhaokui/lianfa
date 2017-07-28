package com.sinnk.web.module.user.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.module.user.entity.OrderEntity;
import com.sinnk.web.module.user.exception.OrderDetailBlankException;
import com.sinnk.web.module.user.service.OrderService;

@Controller
@RequestMapping(value = "${user.url}")
public class UserCommonController extends BaseController {

	@Autowired
	private OrderService orderService;

	@RequiresRoles(value = { "buyer" })
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index() {
		System.out.println(orderService.getAllOrders().size() + " ......................");
		return "user/pc/index";
	}

	// @RequestMapping(value = "about", method = RequestMethod.GET)
	// public String about() {
	// return "user/pc/about";
	// }

	/**
	 * 采购订单查看
	 * 
	 * @return
	 * @throws OrderDetailBlankException
	 */
	@RequiresRoles(value = { "buyer" })
	@RequestMapping(value = "showorder", method = RequestMethod.GET)
	public String showOrder(String type) throws OrderDetailBlankException {

		orderService.createOrder(new OrderEntity());

		if (StringUtils.isBlank(type) || type.equals("all")) {
			return "user/pc/order";
		} else if (type.equals("waitpay")) {
			return "user/pc/order";
		} else if (type.equals("waitsend")) {
			return "user/pc/order";
		} else if (type.equals("waitget")) {
			return "user/pc/order";
		} else {
			return "user/pc/order";
		}

	}

	/**
	 * 我的收藏
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "buyer" })
	@RequestMapping(value = "favorite", method = RequestMethod.GET)
	public String favorite() {
		return "user/pc/favorite";
	}

	/**
	 * 我的销售订单查看
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "sellorder", method = RequestMethod.GET)
	public String sellOrder(String type) {
		if (StringUtils.isBlank(type) || type.equals("all")) {
			return "user/pc/sellorder";
		} else if (type.equals("waitpay")) {
			return "user/pc/sellorder";
		} else if (type.equals("waitsend")) {
			return "user/pc/sellorder";
		} else if (type.equals("waitget")) {
			return "user/pc/sellorder";
		} else {
			return "user/pc/sellorder";
		}
	}

	/**
	 * 我的店铺
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "myshop", method = RequestMethod.GET)
	public String myShop() {
		return "user/pc/myshop";
	}

	/**
	 * 连锁店列表
	 * 
	 * @param level
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "shoplist", method = RequestMethod.GET)
	public String shopList(String level, Model model) {

		if (StringUtils.isBlank(level)) {
			return "redirect:myshop";
		}

		if (level.equals("one")) {
			model.addAttribute("level", "one");
		} else if (level.equals("two")) {
			model.addAttribute("level", "two");
		} else if (level.equals("three")) {
			model.addAttribute("level", "three");
		} else {
			return "redirect:myshop";
		}

		return "user/pc/shop_list";
	}

	/**
	 * 我的佣金
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "mycash", method = RequestMethod.GET)
	public String myCash() {
		return "user/pc/my_cash";
	}

	/**
	 * 提现记录查看
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "withdrawlist", method = RequestMethod.GET)
	public String withdrawList() {
		return "user/pc/withdraw_list";
	}

	/**
	 * 收入明细
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "incomelist", method = RequestMethod.GET)
	public String incomeList() {
		return "user/pc/income_list";
	}

	/**
	 * 我的推广码
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "seller", "buyer" }, logical = Logical.AND)
	@RequestMapping(value = "spread", method = RequestMethod.GET)
	public String spread() {
		return "user/pc/spread";
	}

	/**
	 * 个人资料
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "buyer" })
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile() {
		return "user/pc/profile";
	}

}
