package com.sinnk.web.module.user.entity;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import com.sinnk.web.common.entity.DataEntity;

public class UserEntity extends DataEntity<UserEntity> {

	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$", message = "{validate.form.userName.invalid}")
	private String username;

	@NotBlank(message = "{validate.form.password.invalid}")
	private String password;

	private String userType;

	private String country;

	private String province;

	private String city;

	private String userIp;

	private String locked;

	private Date locakedDate;

	private Date unlockDate;

	/*****************************************
	 * 微信OpenId，不能为空
	 ****************************************/
	@NotBlank
	private String openId;

	/*****************************************
	 * 真实姓名，不能为空
	 ****************************************/
	@NotBlank
	private String trueName;

	/********************************************************************************
	 * 性别，只能为'M' (男) 或者 'F' (女)
	 *******************************************************************************/
	@Pattern(regexp = "^[M|F]{1}$", message = "{validate.form.sex.invalid}")
	private String gender;

	/*****************************************
	 * 年龄在18周岁以上，并且小于200岁
	 ****************************************/
	@Min(value = 18)
	@Max(value = 200)
	private int age;

	/*****************************************
	 * 用户身份证号码，不能为空
	 ****************************************/
	@NotBlank
	private String identityCardNumber;

	/*****************************************
	 * 通讯地址不能为空
	 ****************************************/
	@NotBlank
	private String address;

	/*****************************************
	 * 手机号码
	 ****************************************/
	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "{validate.form.phone.invalid}")
	private String phoneNumber;

	/*****************************************
	 * 电子邮件
	 ****************************************/
	@Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "{validate.form.email.invalid}")
	private String email;

	/*****************************************
	 * QQ号码
	 ****************************************/
	@NotBlank
	private String qq;

	/*****************************************
	 * 上一级的用户ID
	 ****************************************/
	private String upOneId;

	/*****************************************
	 * 上两级的用户ID
	 ****************************************/
	private String upTwoId;

	/*****************************************
	 * 上三级的用户ID
	 ****************************************/
	private String upThreeId;

	/*****************************************
	 * 上四级的用户ID
	 ****************************************/
	private String upFourId;

	/****************************************
	 * 上五级的用户ID
	 ****************************************/
	private String upFiveId;

	/****************************************
	 * 一级下线的用户数量
	 ****************************************/
	private long downOneLevelAmount;

	/****************************************
	 * 二级下线的用户数量
	 ****************************************/
	private long downTwoLevelAmount;

	/****************************************
	 * 三级下线的用户数量
	 ****************************************/
	private long downThreeLevelAmount;

	/****************************************
	 * 四级下线的用户数量
	 ****************************************/
	private long downFourLevelAmount;

	/****************************************
	 * 五级下线的用户数量
	 ****************************************/
	private long downFiveLevelAmount;

	/*****************************************
	 * 用户当前所处金字塔的深度，最小深度为1
	 ****************************************/
	private long currentDepth;

	/***************************************
	 * 当前第几位用户
	 ***************************************/
	private long currentPosition;

	/***************************************
	 * 用户累积赚取的佣金总数
	 ***************************************/
	private double cumulativeCommission;

	/***************************************
	 * 用户累积提现金额总数
	 ***************************************/
	private double cumulativeWithdraw;

	/***************************************
	 * 用户在平台上累积消费的总金额
	 ***************************************/
	private double cumulativeConsumptions;

	/***************************************
	 * 用户当前可用于消费的金额数
	 ***************************************/
	private double currentConsumableCash;

	/***************************************
	 * 用户当前可用于提现的金额数
	 ***************************************/
	private double currentWithdrawAbleCash;

	/***************************************
	 * 快递收件人姓名
	 ***************************************/
	@NotBlank
	private String deliveryName;

	/***************************************
	 * 快递收件人手机号码
	 ***************************************/
	@Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message = "{validate.form.phone.invalid}")
	private String deliveryPhone;

	/***************************************
	 * 快递收件人地址
	 ***************************************/
	@NotBlank
	private String deliveryAddress;

	public UserEntity() {
		super();
		this.currentDepth = 0;
		this.currentPosition = 0;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getUpOneId() {
		return upOneId;
	}

	public void setUpOneId(String upOneId) {
		this.upOneId = upOneId;
	}

	public String getUpTwoId() {
		return upTwoId;
	}

	public void setUpTwoId(String upTwoId) {
		this.upTwoId = upTwoId;
	}

	public String getUpThreeId() {
		return upThreeId;
	}

	public void setUpThreeId(String upThreeId) {
		this.upThreeId = upThreeId;
	}

	public String getUpFourId() {
		return upFourId;
	}

	public void setUpFourId(String upFourId) {
		this.upFourId = upFourId;
	}

	public String getUpFiveId() {
		return upFiveId;
	}

	public void setUpFiveId(String upFiveId) {
		this.upFiveId = upFiveId;
	}

	public long getCurrentDepth() {
		return currentDepth;
	}

	public void setCurrentDepth(long currentDepth) {
		this.currentDepth = currentDepth;
	}

	public long getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(long currentPosition) {
		this.currentPosition = currentPosition;
	}

	public long getDownOneLevelAmount() {
		return downOneLevelAmount;
	}

	public void setDownOneLevelAmount(long downOneLevelAmount) {
		this.downOneLevelAmount = downOneLevelAmount;
	}

	public long getDownTwoLevelAmount() {
		return downTwoLevelAmount;
	}

	public void setDownTwoLevelAmount(long downTwoLevelAmount) {
		this.downTwoLevelAmount = downTwoLevelAmount;
	}

	public long getDownThreeLevelAmount() {
		return downThreeLevelAmount;
	}

	public void setDownThreeLevelAmount(long downThreeLevelAmount) {
		this.downThreeLevelAmount = downThreeLevelAmount;
	}

	public long getDownFourLevelAmount() {
		return downFourLevelAmount;
	}

	public void setDownFourLevelAmount(long downFourLevelAmount) {
		this.downFourLevelAmount = downFourLevelAmount;
	}

	public long getDownFiveLevelAmount() {
		return downFiveLevelAmount;
	}

	public void setDownFiveLevelAmount(long downFiveLevelAmount) {
		this.downFiveLevelAmount = downFiveLevelAmount;
	}

	public double getCumulativeCommission() {
		return cumulativeCommission;
	}

	public void setCumulativeCommission(double cumulativeCommission) {
		this.cumulativeCommission = cumulativeCommission;
	}

	public double getCumulativeWithdraw() {
		return cumulativeWithdraw;
	}

	public void setCumulativeWithdraw(double cumulativeWithdraw) {
		this.cumulativeWithdraw = cumulativeWithdraw;
	}

	public double getCumulativeConsumptions() {
		return cumulativeConsumptions;
	}

	public void setCumulativeConsumptions(double cumulativeConsumptions) {
		this.cumulativeConsumptions = cumulativeConsumptions;
	}

	public double getCurrentConsumableCash() {
		return currentConsumableCash;
	}

	public void setCurrentConsumableCash(double currentConsumableCash) {
		this.currentConsumableCash = currentConsumableCash;
	}

	public double getCurrentWithdrawAbleCash() {
		return currentWithdrawAbleCash;
	}

	public void setCurrentWithdrawAbleCash(double currentWithdrawAbleCash) {
		this.currentWithdrawAbleCash = currentWithdrawAbleCash;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public Date getUnlockDate() {
		return unlockDate;
	}

	public void setUnlockDate(Date unlockDate) {
		this.unlockDate = unlockDate;
	}

	public Date getLocakedDate() {
		return locakedDate;
	}

	public void setLocakedDate(Date locakedDate) {
		this.locakedDate = locakedDate;
	}

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", password=" + password + ", userType=" + userType + ", country="
				+ country + ", province=" + province + ", city=" + city + ", userIp=" + userIp + ", locked=" + locked
				+ ", locakedDate=" + locakedDate + ", unlockDate=" + unlockDate + ", openId=" + openId + ", trueName="
				+ trueName + ", gender=" + gender + ", age=" + age + ", identityCardNumber=" + identityCardNumber
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", qq=" + qq
				+ ", upOneId=" + upOneId + ", upTwoId=" + upTwoId + ", upThreeId=" + upThreeId + ", upFourId="
				+ upFourId + ", upFiveId=" + upFiveId + ", downOneLevelAmount=" + downOneLevelAmount
				+ ", downTwoLevelAmount=" + downTwoLevelAmount + ", downThreeLevelAmount=" + downThreeLevelAmount
				+ ", downFourLevelAmount=" + downFourLevelAmount + ", downFiveLevelAmount=" + downFiveLevelAmount
				+ ", currentDepth=" + currentDepth + ", currentPosition=" + currentPosition + ", cumulativeCommission="
				+ cumulativeCommission + ", cumulativeWithdraw=" + cumulativeWithdraw + ", cumulativeConsumptions="
				+ cumulativeConsumptions + ", currentConsumableCash=" + currentConsumableCash
				+ ", currentWithdrawAbleCash=" + currentWithdrawAbleCash + ", deliveryName=" + deliveryName
				+ ", deliveryPhone=" + deliveryPhone + ", deliveryAddress=" + deliveryAddress + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", id=" + id + ", delFlag=" + delFlag + "]";
	}

}
