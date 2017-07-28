package com.sinnk.web.module.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.common.exception.CategoryHasDownLevelCategory;
import com.sinnk.web.common.exception.CategoryHasProductException;
import com.sinnk.web.common.exception.CategoryIdNotExist;
import com.sinnk.web.common.exception.CategoryNameExistException;
import com.sinnk.web.common.utils.Global;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;
import com.sinnk.web.module.shop.product.service.ProductService;

@Controller
@RequestMapping(value = "${admin.url}")
public class AdminCategoryController extends BaseController {

	@Autowired
	private ProductService shopService;

	/**
	 * 商品分类首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "category", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String category(Model model) {
		model.addAttribute("categorylist", shopService.getAllTopCategory());
		return "admin/pc/category";
	}

	/**
	 * 添加新分类
	 * 
	 * @param category
	 * @param parentid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addcategory", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String addCategory(@ModelAttribute("category") ProductCategoryEntity category, String parentid,
			Model model) {
		model.addAttribute("parentid", parentid);
		if (StringUtils.isNotBlank(parentid)) {
			model.addAttribute("parentcategory", shopService.getCategoryById(parentid));
		}
		return "admin/pc/addcategory";
	}

	/**
	 * 处理商品分类添加
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @param session
	 * @param request
	 * @param parentid
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "addcategory", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin" })
	public String doAddCategory(@Valid @ModelAttribute("category") ProductCategoryEntity category, BindingResult result,
			Model model, HttpSession session, HttpServletRequest request, String parentid,
			RedirectAttributes redirectAttributes) {

		if (result.hasFieldErrors("categoryName")) {
			redirectAttributes.addFlashAttribute("error", result.getFieldError("categoryName").getDefaultMessage());
			return "redirect:addcategory?parentid=" + parentid;
		}

		if (StringUtils.isNotBlank(parentid)) {
			category.setParentId(parentid);
		} else {
			category.setParentId("0");
		}

		try {
			shopService.addCategory(category);
		} catch (CategoryNameExistException e) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.form.category.name.exist"));
			return "redirect:addcategory?parentid=" + parentid;
		}

		if (StringUtils.isBlank(parentid)) {
			return "redirect:category";
		} else {
			return "redirect:showchildcategory?parentid=" + parentid;
		}

	}

	/**
	 * 显示子分类
	 * 
	 * @param parentid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showchildcategory", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String showChildCategory(String parentid, Model model) {
		model.addAttribute("parentcategory", shopService.getCategoryById(parentid));
		model.addAttribute("categorylist", shopService.getCategoryByParentId(parentid));
		return "admin/pc/childcategory";
	}

	/**
	 * 显示商品分类更新界面
	 * 
	 * @param categoryid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "updatecategory", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String updateCategory(String categoryid, Model model) {
		model.addAttribute("category", shopService.getCategoryById(categoryid));
		return "admin/pc/updatecategory";
	}

	/**
	 * 处理商品分类更新
	 * 
	 * @param category
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updatecategory", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin" })
	public String doUpdateCategory(@Valid ProductCategoryEntity category, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasFieldErrors("categoryName")) {
			model.addAttribute("error", Global.getLocaleMessage(request, "validate.form.category.name.blank"));
			return "admin/pc/updatecategory";
		}

		try {
			shopService.updateCategory(category);
		} catch (CategoryNameExistException e) {
			model.addAttribute("error", Global.getLocaleMessage(request, "validate.form.category.name.exist"));
			return "admin/pc/updatecategory";
		}

		return "redirect:category";
	}

	/**
	 * 删除商品分类
	 * 
	 * @param categoryid
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "deletecategory", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String deleteCategoryById(String categoryid, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {

		String refferUrl = request.getHeader("Referer");

		try {
			shopService.deleteCategoryById(categoryid);
		} catch (CategoryIdNotExist e) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.form.category.id.notexist"));
			return "redirect:" + refferUrl;
		} catch (CategoryHasDownLevelCategory e) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.form.category.have.down.category"));
			return "redirect:" + refferUrl;
		} catch (CategoryHasProductException e) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.form.category.have.product"));
			return "redirect:" + refferUrl;
		}

		return "redirect:" + refferUrl;
	}

}
