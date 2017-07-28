package com.sinnk.web.module.user.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinnk.web.common.enums.LianfaEnum;
import com.sinnk.web.common.exception.UserEmailExistException;
import com.sinnk.web.common.exception.UserIdentityCardIdExistException;
import com.sinnk.web.common.exception.UserKeyExistException;
import com.sinnk.web.common.exception.UserKeyNotExistException;
import com.sinnk.web.common.exception.UserNotExistException;
import com.sinnk.web.common.exception.UserOpenIdExistException;
import com.sinnk.web.common.exception.UserPhoneNumberExistException;
import com.sinnk.web.common.exception.UserQQExistException;
import com.sinnk.web.common.exception.UserUsernameExistException;
import com.sinnk.web.common.service.BaseService;
import com.sinnk.web.common.utils.CookieUtils;
import com.sinnk.web.common.utils.CryptoUtils;
import com.sinnk.web.common.utils.Global;
import com.sinnk.web.module.shop.status.dao.StatusDao;
import com.sinnk.web.module.user.dao.RoleDao;
import com.sinnk.web.module.user.dao.UserDao;
import com.sinnk.web.module.user.dao.UserLoginDao;
import com.sinnk.web.module.user.dao.UserRoleDao;
import com.sinnk.web.module.user.entity.RoleEntity;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.entity.UserLoginEntity;
import com.sinnk.web.module.user.entity.UserRoleEntity;
import com.sinnk.web.module.user.service.UserCommonService;

@Service
public class UserCommonServiceImpl extends BaseService implements UserCommonService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private StatusDao statusDao;

	@Autowired
	private UserLoginDao userLoginDao;

	private static final String BUYER = "1";

	/**
	 * 持久化新用户到数据库 包括插入或者更新
	 * 
	 * @throws UserNotExistException
	 * @throws UserKeyNotExistException
	 */
	@Override
	@Transactional(readOnly = false)
	public int insert(UserEntity user, HttpServletRequest request)
			throws UserKeyExistException, UserUsernameExistException, UserOpenIdExistException, UserEmailExistException,
			UserIdentityCardIdExistException, UserPhoneNumberExistException, UserQQExistException,
			UserKeyNotExistException {

		/*********************************
		 * 判断用户ID是否为空
		 *********************************/
		if (StringUtils.isBlank(user.getId())) {
			throw new UserKeyNotExistException(Global.getLocaleMessage(request, "validate.userid.not.blank"));
		}

		/***********************************
		 * 判断用户ID是否已经存在
		 ***********************************/
		if (userDao.getUserAmountByUserId(user.getId()) > 0) {
			throw new UserKeyExistException(Global.getLocaleMessage(request, "validate.userid.exist"));
		}

		/**************************************************************************************
		 * 检查用户名是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getUsername()) && userDao.getUserAmountByUsername(user.getUsername()) > 0) {
			throw new UserUsernameExistException(Global.getLocaleMessage(request, "validate.username.exist"));
		}

		/**************************************************************************************
		 * 检查用户OpenID是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getOpenId()) && userDao.getUserAmountByOpenId(user.getOpenId()) > 0) {
			throw new UserOpenIdExistException(Global.getLocaleMessage(request, "validate.openid.exist"));
		}

		/**************************************************************************************
		 * 检查用户电子邮件地址是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getEmail()) && userDao.getUserAmountByEmail(user.getEmail()) > 0) {
			throw new UserEmailExistException(Global.getLocaleMessage(request, "validate.email.exist"));
		}

		/**************************************************************************************
		 * 检查用户身份证号码是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getIdentityCardNumber())
				&& userDao.getUserAmountByIdentityCardNumber(user.getIdentityCardNumber()) > 0) {
			throw new UserIdentityCardIdExistException(
					Global.getLocaleMessage(request, "validate.identityCardNumber.exist"));
		}

		/**************************************************************************************
		 * 检查用户手机号码是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getPhoneNumber())
				&& userDao.getUserAmountByPhoneNumber(user.getPhoneNumber()) > 0) {
			throw new UserPhoneNumberExistException(Global.getLocaleMessage(request, "validate.phoneNumber.exist"));
		}

		/**************************************************************************************
		 * 检查用户QQ号码是否已经存在 如果存在抛出异常
		 **************************************************************************************/
		if (StringUtils.isNotBlank(user.getQq()) && userDao.getUserAmountByQQ(user.getQq()) > 0) {
			throw new UserQQExistException(Global.getLocaleMessage(request, "validate.qq.exist"));
		}

		/******************************************
		 * 处理用户信息
		 ******************************************/
		String reffer_id = CookieUtils.getCookie(request, Global.getRefferFlag());
		UserEntity fatherUserOne = userDao.get(reffer_id);
		if (null == fatherUserOne || fatherUserOne.getDelFlag().equals(UserEntity.DEL_FLAG_DELETE)) {
			user.setUpOneId("0");
			user.setUpTwoId("0");
			user.setUpThreeId("0");
			user.setUpFourId("0");
			user.setUpFiveId("0");
		} else {
			user.setUpOneId(fatherUserOne.getId());

			/********************************************************/
			long amountOne = fatherUserOne.getDownOneLevelAmount();
			fatherUserOne.setDownOneLevelAmount(amountOne + 1);
			fatherUserOne.preUpdate();
			userDao.setDownOneLevelAmount(fatherUserOne);
			/********************************************************/

			UserEntity fatherUserTwo = userDao.get(fatherUserOne.getUpOneId());
			if (null == fatherUserTwo || UserEntity.DEL_FLAG_DELETE.equals(fatherUserTwo.getDelFlag())) {
				user.setUpTwoId("0");
				user.setUpThreeId("0");
				user.setUpFourId("0");
				user.setUpFiveId("0");
			} else {
				user.setUpTwoId(fatherUserTwo.getId());

				/********************************************************/
				long amountTwo = fatherUserTwo.getDownTwoLevelAmount();
				fatherUserTwo.setDownTwoLevelAmount(amountTwo + 1);
				fatherUserTwo.preUpdate();
				userDao.setDownTwoLevelAmount(fatherUserTwo);
				/********************************************************/

				UserEntity fatherUserThree = userDao.get(fatherUserTwo.getUpOneId());
				if (null == fatherUserThree || UserEntity.DEL_FLAG_DELETE.equals(fatherUserThree.getDelFlag())) {
					user.setUpThreeId("0");
					user.setUpFourId("0");
					user.setUpFiveId("0");
				} else {
					user.setUpThreeId(fatherUserThree.getId());

					/********************************************************/
					long amountThree = fatherUserThree.getDownThreeLevelAmount();
					fatherUserThree.setDownThreeLevelAmount(amountThree + 1);
					fatherUserThree.preUpdate();
					userDao.setDownThreeLevelAmount(fatherUserThree);
					/********************************************************/

					UserEntity fatherUserFour = userDao.get(fatherUserThree.getUpOneId());
					if (null == fatherUserFour || UserEntity.DEL_FLAG_DELETE.equals(fatherUserFour.getDelFlag())) {
						user.setUpFourId("0");
						user.setUpFourId("0");
					} else {
						user.setUpFourId(fatherUserFour.getId());

						/********************************************************/
						long amountFour = fatherUserFour.getDownFourLevelAmount();
						fatherUserFour.setDownFourLevelAmount(amountFour + 1);
						fatherUserFour.preUpdate();
						userDao.setDownFourLevelAmount(fatherUserFour);
						/********************************************************/

						UserEntity fatherUserFive = userDao.get(fatherUserFour.getUpOneId());
						if (null == fatherUserFive || UserEntity.DEL_FLAG_DELETE.equals(fatherUserFive.getDelFlag())) {
							user.setUpFiveId("0");
						} else {
							user.setUpFiveId(fatherUserFive.getId());

							/********************************************************/
							long amountFive = fatherUserFive.getDownFiveLevelAmount();
							fatherUserFive.setDownFiveLevelAmount(amountFive + 1);
							fatherUserFive.preUpdate();
							userDao.setDownFiveLevelAmount(fatherUserFive);
							/********************************************************/

						}
					}
				}
			}
		}

		user.setCumulativeCommission(0);
		user.setCumulativeConsumptions(0);
		user.setCumulativeWithdraw(0);
		user.setCurrentConsumableCash(0);
		user.setCurrentWithdrawAbleCash(0);
		user.setPassword(CryptoUtils.MD5(user.getPassword()));
		user.setLocked(LianfaEnum.ACCOUNT_UNLOCKED.getValue());
		user.setLocakedDate(user.getCreateDate());
		user.setUnlockDate(user.getCreateDate());

		/******************************************
		 * 开始统计全局数据
		 ******************************************/
		long currentUserAmount = statusDao.getCurrentTotalUserAmount(); // 当前所有用户总数
		long currentUserMaxDepth = statusDao.getCurrentTotalUserMaxDepth(); // 当前用户的最大深度

		statusDao.setCurrentTotalUserAmount(currentUserAmount + 1); // 当前用户总数量增加一个

		user.setCurrentPosition(statusDao.getCurrentTotalUserAmount()); // 设置用户为第几位注册的用户

		if (null == fatherUserOne || fatherUserOne.getDelFlag().equals(UserEntity.DEL_FLAG_DELETE)) {
			user.setCurrentDepth(1);
			if (currentUserMaxDepth == 0) {
				statusDao.setCurrentTotalUserMaxDepth(currentUserMaxDepth + 1);
			}
		} else {
			user.setCurrentDepth(fatherUserOne.getCurrentDepth() + 1);
			if (currentUserMaxDepth == fatherUserOne.getCurrentDepth()) {
				statusDao.setCurrentTotalUserMaxDepth(currentUserMaxDepth + 1);
			}
		}

		UserRoleEntity userRoleEntity = new UserRoleEntity();

		userRoleEntity.setUserId(user.getId());
		userRoleEntity.setRoleId(BUYER);
		userRoleEntity.preInsert();

		userDao.insert(user);
		userRoleDao.insert(userRoleEntity);

		return 1;

	}

	/**
	 * 根据用户ID获取用户对象
	 */
	@Override
	@Transactional(readOnly = true)
	public UserEntity getUserById(String id) {
		return userDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Set<String> getStringRoleSetByUserId(String uid) {
		Set<String> set = new HashSet<String>();
		List<UserRoleEntity> userRoleList = userRoleDao.getUserRoleListByUserId(uid);

		if (null != userRoleList) {
			for (UserRoleEntity ur : userRoleList) {
				RoleEntity role = roleDao.get(ur.getRoleId());
				if (null != role) {
					set.add(role.getRoleName());
				}
			}
		}

		return set;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<String> getUserRoleListByUsername(String username) {
		Set<String> set = new HashSet<String>();
		List<UserRoleEntity> userRoleList = userRoleDao.getUserRoleListByUsername(username);
		if (null != userRoleList) {
			for (UserRoleEntity ur : userRoleList) {
				RoleEntity role = roleDao.get(ur.getRoleId());
				if (null != role) {
					set.add(role.getRoleName());
				}
			}
		}
		return set;
	}

	@Override
	@Transactional(readOnly = true)
	public long getUserAmount() {
		// TODO Auto-generated method stub
		return userDao.getUserAmount();
	}

	@Override
	@Transactional(readOnly = true)
	public UserEntity getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public long getUserAmountByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserAmountByUsername(username);
	}

	@Override
	@Transactional(readOnly = false)
	public int addUserLoginRecord(UserLoginEntity loginEntity) {
		// TODO Auto-generated method stub
		return userLoginDao.insert(loginEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public boolean isDoLockedAccount(String username) {
		UserEntity user = userDao.getUserByUsername(username);
		if (null == user) {
			return false;
		}

		List<UserLoginEntity> list = userLoginDao.getRecentLoginFailRecord(user);
		if (null == list || list.size() < 3) {
			return false;
		}

		if (list.get(0).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())
				&& list.get(1).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())
				&& list.get(2).getLoginStatus().equals(LianfaEnum.LOGIN_FAIL.getValue())) {

			Date firstDate = list.get(2).getCreateDate();
			Date nowDate = new Date();

			if ((nowDate.getTime() - firstDate.getTime()) / 1000 <= 3600) {
				user.preUpdate();
				user.setLocked(LianfaEnum.ACCOUNT_LOCKED.getValue());
				user.setLocakedDate(nowDate);
				user.setUnlockDate(new Date(firstDate.getTime() + (3600 * 1000)));
				userDao.lockAccount(user);
				return true;
			}

		}

		return false;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean isDoUnLockedAccount(String username) {
		UserEntity user = userDao.getUserByUsername(username);
		if (null == user) {
			return false;
		}

		user.preUpdate();
		user.setLocked(LianfaEnum.ACCOUNT_UNLOCKED.getValue());
		userDao.unlockAccount(user);
		return true;
	}

}
