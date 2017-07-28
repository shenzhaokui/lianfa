package com.sinnk.web.module.admin.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.common.utils.Global;
import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.service.AdminService;

@Controller
@RequestMapping(value = "${admin.url}")
public class AdminAuthcController extends BaseController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			return "redirect:" + adminPath + "/index";
		}

		String errorException = (String) request
				.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

		if (StringUtils.isNotBlank(errorException)) {
			if (UnknownAccountException.class.getName().equals(errorException)) {
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.form.userName.noexist"));
			} else if (IncorrectCredentialsException.class.getName().equals(errorException)) {
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.form.password.incorrect"));
			} else if (LockedAccountException.class.getName().equals(errorException)) {
				AdminEntity admin = adminService.getAdminByUsername((String) request.getAttribute("username"));
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.LockedAccountException")
						+ "，解锁时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(admin.getUnlockDate()));
			}
		}

		return "admin/pc/login";
	}

}
