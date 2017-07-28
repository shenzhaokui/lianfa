package com.sinnk.web.module.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sinnk.web.common.controller.BaseController;

@Controller
@RequestMapping(value = "${admin.url}")
public class AdminMainController extends BaseController {


	/**
	 * 显示管理员首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String index(Model model) {
		// model.addAttribute("useramount", userService.getUserAmount());
		return "admin/pc/index";
	}

	

}
