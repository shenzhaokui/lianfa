package com.sinnk.web.module.user.dao;

import org.apache.ibatis.annotations.Param;

import com.sinnk.web.common.annotation.MyBatisDao;
import com.sinnk.web.common.dao.CrudDao;
import com.sinnk.web.module.user.entity.UserEntity;

@MyBatisDao
public interface UserDao extends CrudDao<UserEntity> {

	/**
	 * 更具用户名获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public UserEntity getUserByUsername(@Param("username") String username);

	/**
	 * 根据用户ID获取用户对象
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity getUserById(@Param("id") String id);

	/**
	 * 根据用户ID获取用户数量，用于判断用户ID是否有重复
	 * 
	 * @param id
	 * @return
	 */
	public long getUserAmountByUserId(@Param("id") String id);

	/**
	 * 根据用户名获取用户数量，用于判断用户名是否重复
	 * 
	 * @param username
	 * @return
	 */
	public long getUserAmountByUsername(@Param("username") String username);

	/**
	 * 根据用户微信OpenId获取用户数量，用于判断OpenId是否重复
	 * 
	 * @param username
	 * @return
	 */
	public long getUserAmountByOpenId(@Param("openid") String openid);

	/**
	 * 根据Email获取用户数量，用于判断Email是否重复
	 * 
	 * @param email
	 * @return
	 */
	public long getUserAmountByEmail(@Param("email") String email);

	/**
	 * 根据身份证号码获取用户数量，用于判断身份证号码是否重复
	 * 
	 * @param idcard
	 * @return
	 */
	public long getUserAmountByIdentityCardNumber(@Param("idcard") String idcard);

	/**
	 * 根据手机号码获取用户数量，用于判断手机号码是否重复
	 * 
	 * @param phone
	 * @return
	 */
	public long getUserAmountByPhoneNumber(@Param("phone") String phone);

	/**
	 * 根据QQ号码获取用户数量，用于判断QQ是否重复
	 * 
	 * @param qq
	 * @return
	 */
	public long getUserAmountByQQ(@Param("qq") String qq);

	public int setDownOneLevelAmount(UserEntity user);

	public int setDownTwoLevelAmount(UserEntity user);

	public int setDownThreeLevelAmount(UserEntity user);

	public int setDownFourLevelAmount(UserEntity user);

	public int setDownFiveLevelAmount(UserEntity user);

	public long getUserAmount();

	public int lockAccount(UserEntity user);

	public int unlockAccount(UserEntity user);

}
