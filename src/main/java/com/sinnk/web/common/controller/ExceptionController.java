package com.sinnk.web.common.controller;

import javax.servlet.http.HttpServletRequest;
import com.sinnk.web.module.user.exception.OrderDetailBlankException;
import com.sinnk.web.module.shop.product.exception.ProductCategoryNullException;
import com.sinnk.web.module.shop.product.exception.ProductNullException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import com.sinnk.web.common.utils.Global;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AuthorizationException.class)
	public String AuthorizationExceptionHandler(Model model, HttpServletRequest request) {
		model.addAttribute("error", Global.getLocaleMessage(request, "exception.no.authorization"));
		return "authc/pc/exception";
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String MaxUploadSizeExceededException(Model model, HttpServletRequest request) {
		model.addAttribute("error", Global.getLocaleMessage(request, "upload.maxsize.error"));
		return "authc/pc/exception";
	}

	@ExceptionHandler(OrderDetailBlankException.class)
	public String OrderDetailBlankException(Model model, HttpServletRequest request) {
		model.addAttribute("error", Global.getLocaleMessage(request, "upload.maxsize.error"));
		return "authc/pc/exception";
	}

	@ExceptionHandler(ProductCategoryNullException.class)
	public String ProductCategoryNullException(Model model, HttpServletRequest request) {
		model.addAttribute("error", "分类未找到");
		return "authc/pc/exception";
	}

	@ExceptionHandler(ProductNullException.class)
	public String ProductNullException(Model model, HttpServletRequest request) {
		model.addAttribute("error", "产品不存在");
		return "authc/pc/exception";
	}

	@ExceptionHandler(NumberFormatException.class)
	public String NumberFormatException(Model model, HttpServletRequest request) {
		model.addAttribute("error", "数值转换异常");
		return "authc/pc/exception";
	}

}
