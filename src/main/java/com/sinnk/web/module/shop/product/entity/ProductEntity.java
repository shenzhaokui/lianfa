package com.sinnk.web.module.shop.product.entity;

import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import com.sinnk.web.common.entity.DataEntity;

/**
 * 产品实体类对象
 * 
 * @author dakui
 *
 */
public class ProductEntity extends DataEntity<ProductEntity> {

	private static final long serialVersionUID = 1L;

	/*
	 * 商品名称
	 */
	@NotBlank
	private String productName;

	/*
	 * 商品详情
	 */
	@NotBlank
	private String productDescription;

	/*
	 * 商品所属分类ID
	 */
	@NotBlank
	private String productCategoryId;

	/*
	 * 商品所属分类名称
	 */
	private String productCategoryName;

	/*
	 * 商品佣金类型 '0':按照百分比提成 '1':按照固定金额提成
	 */
	@NotBlank
	@Pattern(regexp = "^[0|1]{1}$", message = "{validate.update.product.error}")
	private String productCommissionType;

	/*
	 * 商品一级上线提成百分比
	 */
	@Digits(fraction = 2, integer = 0)
	private float productUpOneLevelPercentage;

	/*
	 * 商品二级上线提成百分比
	 */

	private float productUpTwoLevelPercentage;

	/*
	 * 商品三级上线提成百分比
	 */
	private float productUpThreeLevelPercentage;

	/*
	 * 商品四级上线提成百分比
	 */
	private float productUpFourLevelPercentage;

	/*
	 * 商品五级上线提成百分比
	 */
	private float productUpFiveLevelPercentage;

	/*
	 * 商品一级上线提成固定金额数
	 */
	private float productUpOneLevelFixedAmount;

	/*
	 * 商品二级上线提成固定金额数
	 */
	private float productUpTwoLevelFixedAmount;

	/*
	 * 商品三级上线提成固定金额数
	 */
	private float productUpThreeLevelFixedAmount;

	/*
	 * 商品四级上线提成固定金额数
	 */
	private float productUpFourLevelFixedAmount;

	/*
	 * 商品五级上线提成固定金额数
	 */
	private float productUpFiveLevelFixedAmount;

	/*
	 * 商品当前库存
	 */
	@DecimalMin(value = "1")
	private double productStock;

	@NotBlank
	private String measurementUnit;

	private String bigPicUrl;

	private String smallPicUrl;
	
	private double originalPrice;
	
	private double currentPrice;

	/**
	 * 商品缩略图列表
	 */
	private List<ProductThumbnailEntity> thumbnails;

	/**
	 * 商品分类列表
	 */
	private List<ProductTypeEntity> typeList;
	
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getProductCommissionType() {
		return productCommissionType;
	}

	public void setProductCommissionType(String productCommissionType) {
		this.productCommissionType = productCommissionType;
	}

	public float getProductUpOneLevelPercentage() {
		return productUpOneLevelPercentage;
	}

	public void setProductUpOneLevelPercentage(float productUpOneLevelPercentage) {
		this.productUpOneLevelPercentage = productUpOneLevelPercentage;
	}

	public float getProductUpTwoLevelPercentage() {
		return productUpTwoLevelPercentage;
	}

	public void setProductUpTwoLevelPercentage(float productUpTwoLevelPercentage) {
		this.productUpTwoLevelPercentage = productUpTwoLevelPercentage;
	}

	public float getProductUpThreeLevelPercentage() {
		return productUpThreeLevelPercentage;
	}

	public void setProductUpThreeLevelPercentage(float productUpThreeLevelPercentage) {
		this.productUpThreeLevelPercentage = productUpThreeLevelPercentage;
	}

	public float getProductUpFourLevelPercentage() {
		return productUpFourLevelPercentage;
	}

	public void setProductUpFourLevelPercentage(float productUpFourLevelPercentage) {
		this.productUpFourLevelPercentage = productUpFourLevelPercentage;
	}

	public float getProductUpFiveLevelPercentage() {
		return productUpFiveLevelPercentage;
	}

	public void setProductUpFiveLevelPercentage(float productUpFiveLevelPercentage) {
		this.productUpFiveLevelPercentage = productUpFiveLevelPercentage;
	}

	public float getProductUpOneLevelFixedAmount() {
		return productUpOneLevelFixedAmount;
	}

	public void setProductUpOneLevelFixedAmount(float productUpOneLevelFixedAmount) {
		this.productUpOneLevelFixedAmount = productUpOneLevelFixedAmount;
	}

	public float getProductUpTwoLevelFixedAmount() {
		return productUpTwoLevelFixedAmount;
	}

	public void setProductUpTwoLevelFixedAmount(float productUpTwoLevelFixedAmount) {
		this.productUpTwoLevelFixedAmount = productUpTwoLevelFixedAmount;
	}

	public float getProductUpThreeLevelFixedAmount() {
		return productUpThreeLevelFixedAmount;
	}

	public void setProductUpThreeLevelFixedAmount(float productUpThreeLevelFixedAmount) {
		this.productUpThreeLevelFixedAmount = productUpThreeLevelFixedAmount;
	}

	public float getProductUpFourLevelFixedAmount() {
		return productUpFourLevelFixedAmount;
	}

	public void setProductUpFourLevelFixedAmount(float productUpFourLevelFixedAmount) {
		this.productUpFourLevelFixedAmount = productUpFourLevelFixedAmount;
	}

	public float getProductUpFiveLevelFixedAmount() {
		return productUpFiveLevelFixedAmount;
	}

	public void setProductUpFiveLevelFixedAmount(float productUpFiveLevelFixedAmount) {
		this.productUpFiveLevelFixedAmount = productUpFiveLevelFixedAmount;
	}

	public double getProductStock() {
		return productStock;
	}

	public void setProductStock(double productStock) {
		this.productStock = productStock;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public String getBigPicUrl() {
		return bigPicUrl;
	}

	public void setBigPicUrl(String bigPicUrl) {
		this.bigPicUrl = bigPicUrl;
	}

	public String getSmallPicUrl() {
		return smallPicUrl;
	}

	public void setSmallPicUrl(String smallPicUrl) {
		this.smallPicUrl = smallPicUrl;
	}

	public List<ProductThumbnailEntity> getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(List<ProductThumbnailEntity> thumbnails) {
		this.thumbnails = thumbnails;
	}

	public List<ProductTypeEntity> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<ProductTypeEntity> typeList) {
		this.typeList = typeList;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "ProductEntity [productName=" + productName + ", productDescription=" + productDescription
				+ ", productCategoryId=" + productCategoryId + ", productCategoryName=" + productCategoryName
				+ ", productCommissionType=" + productCommissionType + ", productUpOneLevelPercentage="
				+ productUpOneLevelPercentage + ", productUpTwoLevelPercentage=" + productUpTwoLevelPercentage
				+ ", productUpThreeLevelPercentage=" + productUpThreeLevelPercentage + ", productUpFourLevelPercentage="
				+ productUpFourLevelPercentage + ", productUpFiveLevelPercentage=" + productUpFiveLevelPercentage
				+ ", productUpOneLevelFixedAmount=" + productUpOneLevelFixedAmount + ", productUpTwoLevelFixedAmount="
				+ productUpTwoLevelFixedAmount + ", productUpThreeLevelFixedAmount=" + productUpThreeLevelFixedAmount
				+ ", productUpFourLevelFixedAmount=" + productUpFourLevelFixedAmount
				+ ", productUpFiveLevelFixedAmount=" + productUpFiveLevelFixedAmount + ", productStock=" + productStock
				+ ", measurementUnit=" + measurementUnit + ", bigPicUrl=" + bigPicUrl + ", smallPicUrl=" + smallPicUrl
				+ ", thumbnails=" + thumbnails + ", typeList=" + typeList + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", id=" + id + ", isNewRecord=" + isNewRecord + ", delFlag=" + delFlag
				+ "]";
	}

}
