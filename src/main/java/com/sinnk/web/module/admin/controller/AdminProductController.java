package com.sinnk.web.module.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sinnk.web.common.controller.BaseController;
import com.sinnk.web.common.exception.ProductNameExistException;
import com.sinnk.web.common.utils.Global;
import com.sinnk.web.common.utils.IdGen;
import com.sinnk.web.module.shop.product.entity.ProductCategoryEntity;
import com.sinnk.web.module.shop.product.entity.ProductEntity;
import com.sinnk.web.module.shop.product.entity.ProductThumbnailEntity;
import com.sinnk.web.module.shop.product.entity.ProductTypeEntity;
import com.sinnk.web.module.shop.product.service.ProductService;

@Controller
@RequestMapping(value = "${admin.url}")
public class AdminProductController extends BaseController {

	@Autowired
	private ProductService shopService;

	/**
	 * 展示商品管理首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "product", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String product(Model model) {
		model.addAttribute("productlist", shopService.getAllProduct());
		return "admin/pc/product";
	}

	/**
	 * 展示商品详情
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "productinfo", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String productinfo(String pid, Model model) {
		model.addAttribute("product", shopService.getProductById(pid));
		return "admin/pc/productinfo";
	}

	/**
	 * 展示商品更新界面
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "updateuroduct", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String updateProduct(String pid, Model model) {
		model.addAttribute("product", shopService.getProductById(pid));
		model.addAttribute("categorys", shopService.getAllCategory());
		return "admin/pc/productupdate";
	}

	/**
	 * 处理商品更新
	 * 
	 * @param product
	 * @param result
	 * @param model
	 * @param request
	 * @param redirectAttributes
	 * @param file1
	 * @param file2
	 * @param file3
	 * @param file4
	 * @param typeName
	 * @return
	 */
	@RequestMapping(value = "updateuroduct", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin" })
	public String doUpdateProduct(@Valid ProductEntity product, BindingResult result, Model model,
			HttpServletRequest request, RedirectAttributes redirectAttributes, MultipartFile file1, MultipartFile file2,
			MultipartFile file3, MultipartFile file4, String typeName) {

		if (result.hasFieldErrors()) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.update.product.error"));
			return "redirect:updateuroduct?pid=" + product.getId();
		}

		String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/productimg/";

		if (!file1.isEmpty()) {
			if (!file1.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:updateuroduct?pid=" + product.getId();
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);

				String oldName = product.getBigPicUrl();
				File oldFile = new File(uploadPath + oldName);

				try {
					file1.transferTo(desFile);
					product.setBigPicUrl(uuidName);
					oldFile.delete();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		if (!file2.isEmpty()) {
			if (!file2.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:updateuroduct?pid=" + product.getId();
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);

				String oldName = product.getSmallPicUrl();
				File oldFile = new File(uploadPath + oldName);

				try {
					file2.transferTo(desFile);
					product.setSmallPicUrl(uuidName);
					oldFile.delete();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		// 新增缩略图
		if (!file3.isEmpty()) {
			if (!file3.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:updateuroduct?pid=" + product.getId();
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file3.getOriginalFilename().substring(file3.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);

				ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
				thumbnail.preInsert();
				thumbnail.setProductId(product.getId());
				thumbnail.setThumbnailUrl(uuidName);

				try {
					shopService.addNewThumbnail(thumbnail);
					file3.transferTo(desFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		// 新增商品颜色分类
		if (!file4.isEmpty()) {
			if (!file4.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:updateuroduct?pid=" + product.getId();
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file4.getOriginalFilename().substring(file4.getOriginalFilename().lastIndexOf(".") + 1);
				String desFileUrl = uploadPath + uuidName;
				File desFile = new File(desFileUrl);

				ProductTypeEntity type = new ProductTypeEntity();
				type.preInsert();
				type.setProductId(product.getId());
				type.setImgUrl(uuidName);
				type.setTypeName(typeName);

				if (StringUtils.isBlank(typeName)) {
					redirectAttributes.addFlashAttribute("error",
							Global.getLocaleMessage(request, "validate.update.file.format.error"));
					return "redirect:updateuroduct?pid=" + product.getId();
				}

				try {
					shopService.addProductType(type);
					file4.transferTo(desFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		try {
			shopService.updateProduct(product);
		} catch (ProductNameExistException e) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.form.product.name.exist"));
			return "redirect:updateuroduct?pid=" + product.getId();
		}
		return "redirect:productinfo?pid=" + product.getId();
	}

	/**
	 * 展示添加商品界面
	 * 
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "addproduct", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String addProduct(@ModelAttribute("product") ProductEntity product, Model model) {
		System.out.println(product);
		model.addAttribute("categorys", shopService.getAllCategory());
		return "admin/pc/addproduct";
	}

	/**
	 * 处理商品添加
	 * 
	 * @param product
	 * @param result
	 * @param model
	 * @param file1
	 * @param file2
	 * @param thumbnail1
	 * @param thumbnail2
	 * @param thumbnail3
	 * @param thumbnail4
	 * @param thumbnail5
	 * @param thumbnail6
	 * @param redirectAttributes
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "addproduct", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin" })
	public String doAddProduct(@Valid ProductEntity product, BindingResult result, Model model, MultipartFile file1,
			MultipartFile file2, MultipartFile thumbnail1, MultipartFile thumbnail2, MultipartFile thumbnail3,
			MultipartFile thumbnail4, MultipartFile thumbnail5, MultipartFile thumbnail6,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		if (file1.isEmpty() || file2.isEmpty() || thumbnail1.isEmpty() || thumbnail2.isEmpty() || thumbnail3.isEmpty()
				|| thumbnail4.isEmpty() || thumbnail5.isEmpty() || thumbnail6.isEmpty()) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.update.file.notblank"));
			return "redirect:addproduct";
		}

		if (result.hasFieldErrors()) {
			redirectAttributes.addFlashAttribute("error",
					Global.getLocaleMessage(request, "validate.update.product.error"));
			return "redirect:addproduct";
		}

		ProductCategoryEntity category = shopService.getCategoryById(product.getProductCategoryId());

		if (null != category && category.getParentId().equals("0")) {
			redirectAttributes.addFlashAttribute("error", "顶级分类下不能添加产品");
			return "redirect:addproduct";
		}

		String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/productimg/";

		product.preInsert();

		// 上传产品大图
		if (!file1.isEmpty()) {

			if (!file1.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file1.getOriginalFilename().substring(file1.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					file1.transferTo(desFile);
					product.setBigPicUrl(uuidName);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传产品小图
		if (!file2.isEmpty()) {

			if (!file2.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "."
						+ file2.getOriginalFilename().substring(file2.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					file2.transferTo(desFile);
					product.setSmallPicUrl(uuidName);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		List<ProductThumbnailEntity> list = new ArrayList<ProductThumbnailEntity>();

		// 上传缩略图1
		if (!thumbnail1.isEmpty()) {

			if (!thumbnail1.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail1.getOriginalFilename()
						.substring(thumbnail1.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail1.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传缩略图2
		if (!thumbnail2.isEmpty()) {

			if (!thumbnail2.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail2.getOriginalFilename()
						.substring(thumbnail2.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail2.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传缩略图3
		if (!thumbnail3.isEmpty()) {

			if (!thumbnail3.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail3.getOriginalFilename()
						.substring(thumbnail3.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail3.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传缩略图4
		if (!thumbnail4.isEmpty()) {

			if (!thumbnail4.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail4.getOriginalFilename()
						.substring(thumbnail4.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail4.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传缩略图5
		if (!thumbnail5.isEmpty()) {

			if (!thumbnail5.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail5.getOriginalFilename()
						.substring(thumbnail5.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail5.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 上传缩略图6
		if (!thumbnail6.isEmpty()) {

			if (!thumbnail6.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:addproduct";
			} else {

				String uuidName = IdGen.getUUID() + "." + thumbnail6.getOriginalFilename()
						.substring(thumbnail6.getOriginalFilename().lastIndexOf(".") + 1);

				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);
				try {
					thumbnail6.transferTo(desFile);
					ProductThumbnailEntity thumbnail = new ProductThumbnailEntity();
					thumbnail.preInsert();
					thumbnail.setThumbnailUrl(uuidName);
					thumbnail.setProductId(product.getId());
					list.add(thumbnail);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		product.setThumbnails(list);

		shopService.addProduct(product);

		redirectAttributes.addFlashAttribute("error", Global.getLocaleMessage(request, "validate.addproduct.success"));

		return "redirect:addproduct";
	}

	/**
	 * 展示商品缩略图更新界面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "updatethumbnail", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String updateThumbnail(String id, Model model) {
		model.addAttribute("thumbnail", shopService.getThumbnaiById(id));
		return "admin/pc/updatethumbnail";
	}

	/**
	 * 处理商品缩略图更新
	 * 
	 * @param thumbnail
	 * @param model
	 * @param file
	 * @param redirectAttributes
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "updatethumbnail", method = RequestMethod.POST)
	@RequiresRoles(value = { "admin" })
	public String doUpdateThumbnail(ProductThumbnailEntity thumbnail, Model model, MultipartFile file,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		thumbnail = shopService.getThumbnaiById(thumbnail.getId());
		if (null == thumbnail) {
			return "redirect:product";
		}
		String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/productimg/";
		if (!file.isEmpty()) {
			if (!file.getContentType().startsWith("image")) {
				redirectAttributes.addFlashAttribute("error",
						Global.getLocaleMessage(request, "validate.update.file.format.error"));
				return "redirect:updatethumbnail?id=" + thumbnail.getId();
			} else {
				String uuidName = IdGen.getUUID() + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				String desFileUrl = uploadPath + uuidName;

				File desFile = new File(desFileUrl);

				String oldName = thumbnail.getThumbnailUrl();
				File oldFile = new File(uploadPath + oldName);

				thumbnail.preUpdate();

				try {
					thumbnail.setThumbnailUrl(uuidName);
					shopService.updateThumbnai(thumbnail);
					file.transferTo(desFile);
					if (oldFile.exists()) {
						oldFile.delete();
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:updateuroduct?pid=" + thumbnail.getProductId();
	}

	/**
	 * 删除商品缩略图
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deletethumbnail", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String deleteThumbnail(String id, HttpServletRequest request) {

		ProductThumbnailEntity thumbnail = shopService.getThumbnaiById(id);
		if (null == thumbnail) {
			return "redirect:product";
		}

		String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/productimg/";

		File oldFile = new File(uploadPath + thumbnail.getThumbnailUrl());

		shopService.deleteThumbnailByid(id);

		if (oldFile.exists()) {
			oldFile.delete();
		}

		return "redirect:updateuroduct?pid=" + thumbnail.getProductId();
	}

	/**
	 * 删除商品颜色分类
	 * 
	 * @param typeid
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "deleteproducttype", method = RequestMethod.GET)
	@RequiresRoles(value = { "admin" })
	public String deleteProductType(String typeid, HttpServletRequest request) {
		ProductTypeEntity ptype = shopService.getProductTypeById(typeid);
		String pid = ptype == null ? "" : ptype.getProductId();

		if (ptype != null) {
			String uploadPath = request.getSession().getServletContext().getRealPath("/") + "upload/productimg/";
			File file = new File(uploadPath + ptype.getImgUrl());
			if (file.exists()) {
				file.delete();
			}
		}

		shopService.deleteProductTypeById(typeid);

		return "redirect:updateuroduct?pid=" + pid;
	}

}
