package com.sinnk.web.module.user.controller;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.common.enums.LianfaEnum;
import com.sinnk.web.common.exception.UserEmailExistException;
import com.sinnk.web.common.exception.UserIdentityCardIdExistException;
import com.sinnk.web.common.exception.UserKeyExistException;
import com.sinnk.web.common.exception.UserKeyNotExistException;
import com.sinnk.web.common.exception.UserOpenIdExistException;
import com.sinnk.web.common.exception.UserPhoneNumberExistException;
import com.sinnk.web.common.exception.UserQQExistException;
import com.sinnk.web.common.exception.UserUsernameExistException;
import com.sinnk.web.common.utils.Global;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.service.UserCommonService;

@Controller
@RequestMapping(value = "${user.url}")
public class UserAuthcController extends BaseController {

	@Autowired
	private UserCommonService userService;

	private static final String USER_LOGIN_PAGE = "authc/pc/userlogin";
	private static final String USER_REG_PAGE = "authc/pc/userregister";
	private static final String USER_REG_PAGE_2 = "authc/pc/userregister_step_2";
	private static final String USER_REG_PAGE_3 = "authc/pc/userregister_step_3";
	private static final String REG_SUCCESS = "authc/pc/reg_success";
	private static final String REG_FAIL = "authc/pc/reg_fail";

	/**
	 * 显示用户登录界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			return "redirect:" + userPath + "/index";
		}

		String errorException = (String) request
				.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

		if (StringUtils.isNotBlank(errorException)) {
			if (UnknownAccountException.class.getName().equals(errorException)) {
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.form.userName.noexist"));
			} else if (IncorrectCredentialsException.class.getName().equals(errorException)) {
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.form.password.incorrect"));
			} else if (LockedAccountException.class.getName().equals(errorException)) {
				UserEntity user = userService.getUserByUsername((String) request.getAttribute("username"));
				model.addAttribute("msg", Global.getLocaleMessage(request, "validate.LockedAccountException")
						+ "，解锁时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getUnlockDate()));
			}
		}

		return USER_LOGIN_PAGE;
	}

	/**
	 * 显示用户注册界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(RedirectAttributes redirectAttributes, HttpServletRequest request) {

		request.getSession().removeAttribute("tempuser");
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			redirectAttributes.addFlashAttribute("msg", Global.getLocaleMessage(request, "TIPS.MSG.RE_REGISTER"));
			return "redirect:" + userPath + "/index";
		}
		return USER_REG_PAGE;
	}

	/**
	 * 处理用户注册第一步
	 * 
	 * @return
	 */
	@RequestMapping(value = "regstepone", method = RequestMethod.POST)
	public String doRegisterStepOne(@Valid @ModelAttribute("user") UserEntity user, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request) {

		/*
		 * 如果已经处于登录状态，直接跳转到用户首页
		 */
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:" + userPath + "/index";
		}

		/*
		 * 用户名验证失败
		 */
		if (result.hasFieldErrors("username")) {
			model.addAttribute("error", result.getFieldError("username").getDefaultMessage());
			return USER_REG_PAGE;
		}

		/*
		 * 判断所填写的用户名是否已经存在
		 */
		if (userService.getUserAmountByUsername(user.getUsername()) > 0) {
			model.addAttribute("error", Global.getLocaleMessage(request, "validate.form.userName.exist"));
			return USER_REG_PAGE;
		}

		/*
		 * session 存储临时用户
		 */
		session.setAttribute("tempuser", user);

		return "redirect:regsteptwo";
	}

	/**
	 * 显示用户注册第二步
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "regsteptwo", method = RequestMethod.GET)
	public String registerStepTwo(HttpSession session) {

		/*
		 * 如果已经处于登录状态，直接跳转到用户首页
		 */
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:" + userPath + "/index";
		}

		if (null == (UserEntity) session.getAttribute("tempuser")
				|| StringUtils.isBlank(((UserEntity) session.getAttribute("tempuser")).getUsername())) {
			return "redirect:register";
		}

		return USER_REG_PAGE_2;
	}

	/**
	 * 处理用户注册第二步
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "regsteptwo", method = RequestMethod.POST)
	public String doregisterStepTwo(@Valid @ModelAttribute("user") UserEntity user, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request, String repassword) {

		/*
		 * 如果已经处于登录状态，直接跳转到用户首页
		 */
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:" + userPath + "/index";
		}

		if (null == (UserEntity) session.getAttribute("tempuser")
				|| StringUtils.isBlank(((UserEntity) session.getAttribute("tempuser")).getUsername())) {
			return "redirect:register";
		}

		if (result.hasFieldErrors("password")) {
			model.addAttribute("error_password", result.getFieldError("password").getDefaultMessage());
			return USER_REG_PAGE_2;
		}

		if (null == repassword || !repassword.equals(user.getPassword())) {
			model.addAttribute("error_repassword",
					Global.getLocaleMessage(request, "validate.form.rePassword.invalid"));
			return USER_REG_PAGE_2;
		}

		model.addAttribute("repassword", repassword);

		if (result.hasFieldErrors("deliveryName")) {
			model.addAttribute("error_deliveryname", result.getFieldError("deliveryName").getDefaultMessage());
			return USER_REG_PAGE_2;
		}

		if (result.hasFieldErrors("deliveryPhone")) {
			model.addAttribute("error_deliveryphone", result.getFieldError("deliveryPhone").getDefaultMessage());
			return USER_REG_PAGE_2;
		}

		if (result.hasFieldErrors("deliveryAddress")) {
			model.addAttribute("error_deliveryaddress", result.getFieldError("deliveryAddress").getDefaultMessage());
			return USER_REG_PAGE_2;
		}

		user.setUsername(((UserEntity) session.getAttribute("tempuser")).getUsername());
		session.setAttribute("tempuser", user);

		return USER_REG_PAGE_3;
	}

	/**
	 * 提交最终注册信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "updatereg", method = RequestMethod.GET)
	public String updateReg(HttpSession session, HttpServletRequest request, Model model) {

		/*
		 * 如果已经处于登录状态，直接跳转到用户首页
		 */
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:" + userPath + "/index";
		}

		UserEntity tempuser = (UserEntity) session.getAttribute("tempuser");

		if (null == tempuser || StringUtils.isBlank(tempuser.getUsername())
				|| StringUtils.isBlank(tempuser.getPassword()) || StringUtils.isBlank(tempuser.getDeliveryName())
				|| StringUtils.isBlank(tempuser.getDeliveryPhone())
				|| StringUtils.isBlank(tempuser.getDeliveryAddress())) {
			return "redirect:register";
		}

		tempuser.preInsert();
		tempuser.setUserType(LianfaEnum.USER_TYPE_FREE.getValue());
		tempuser.setUserIp(request.getRemoteAddr());

		try {
			userService.insert(tempuser, request);
		} catch (UserKeyExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserUsernameExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserOpenIdExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserEmailExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserIdentityCardIdExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserPhoneNumberExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserQQExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		} catch (UserKeyNotExistException e) {
			model.addAttribute("error", e.getMessage());
			return REG_FAIL;
		}

		session.removeAttribute("tempuser");

		return REG_SUCCESS;
	}

}
