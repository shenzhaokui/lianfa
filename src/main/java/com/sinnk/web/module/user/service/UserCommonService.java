package com.sinnk.web.module.user.service;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import com.sinnk.web.common.exception.UserEmailExistException;
import com.sinnk.web.common.exception.UserIdentityCardIdExistException;
import com.sinnk.web.common.exception.UserKeyExistException;
import com.sinnk.web.common.exception.UserKeyNotExistException;
import com.sinnk.web.common.exception.UserNotExistException;
import com.sinnk.web.common.exception.UserOpenIdExistException;
import com.sinnk.web.common.exception.UserPhoneNumberExistException;
import com.sinnk.web.common.exception.UserQQExistException;
import com.sinnk.web.common.exception.UserUsernameExistException;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.entity.UserLoginEntity;

public interface UserCommonService {

	/**
	 * 持久化用户数据
	 * 
	 * @param user
	 * @return
	 * @throws UserKeyExistException
	 * @throws UserUsernameExistException
	 * @throws UserOpenIdExistException
	 * @throws UserEmailExistException
	 * @throws UserIdentityCardIdExistException
	 * @throws UserPhoneNumberExistException
	 * @throws UserQQExistException
	 * @throws UserNotExistException
	 * @throws UserKeyNotExistException
	 */
	public int insert(UserEntity user, HttpServletRequest request)
			throws UserKeyExistException, UserUsernameExistException, UserOpenIdExistException, UserEmailExistException,
			UserIdentityCardIdExistException, UserPhoneNumberExistException, UserQQExistException,
			UserKeyNotExistException;

	/**
	 * 根据用户ID获取用户对象
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity getUserById(String id);

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity getUserByUsername(String username);

	public Set<String> getStringRoleSetByUserId(String uid);

	public Set<String> getUserRoleListByUsername(String username);

	public long getUserAmount();

	public long getUserAmountByUsername(String username);

	public int addUserLoginRecord(UserLoginEntity loginEntity);

	public boolean isDoLockedAccount(String username);

	public boolean isDoUnLockedAccount(String username);

}
