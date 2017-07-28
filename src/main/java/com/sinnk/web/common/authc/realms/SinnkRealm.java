package com.sinnk.web.common.authc.realms;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinnk.web.common.authc.token.SinnkToken;
import com.sinnk.web.common.enums.LianfaEnum;
import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.service.AdminService;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.service.UserCommonService;

public class SinnkRealm extends AuthorizingRealm {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserCommonService userService;

	private SinnkToken sinnkToken;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (getSinnkToken() != null && getSinnkToken().getUserType().equals(SinnkToken.ADMIN_LOGIN_TYPE)) {
			info.addRole("admin");
		} else if (getSinnkToken().getUserType().equals(SinnkToken.USER_LOHIN_TYPE)) {
			String username = (String) principal.getPrimaryPrincipal();
			if (StringUtils.isNotBlank(username)) {
				info.addRoles(userService.getUserRoleListByUsername(username));
			}
		}

		return info;

	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		setSinnkToken((SinnkToken) token);

		if (getSinnkToken() != null && getSinnkToken().getUserType().equals(SinnkToken.ADMIN_LOGIN_TYPE)) {
			AdminEntity admin = adminService.getAdminByUsername(getSinnkToken().getUsername());
			if (null != admin) {
				if (admin.getLocked().equals(LianfaEnum.ACCOUNT_LOCKED.getValue())) { // 登录失败次数过多，账号被锁定一小时
					Date unlockDate = admin.getUnlockDate();
					Date nowDate = new Date();
					if (nowDate.getTime() < unlockDate.getTime()) {
						throw new LockedAccountException();
					} else {
						adminService.isDoUnLockedAccount(admin.getUsername());
					}
				}
				return new SimpleAuthenticationInfo(admin.getUsername(), admin.getPassword(), getName());
			}
		} else if (getSinnkToken().getUserType().equals(SinnkToken.USER_LOHIN_TYPE)) {
			UserEntity user = userService.getUserByUsername(getSinnkToken().getUsername());
			if (null != user) {
				if (user.getLocked().equals(LianfaEnum.ACCOUNT_LOCKED.getValue())) {
					Date unlockDate = user.getUnlockDate();
					Date nowDate = new Date();
					if (nowDate.getTime() < unlockDate.getTime()) {
						throw new LockedAccountException();
					} else {
						userService.isDoUnLockedAccount(user.getUsername());
					}
				}
				return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			}
		}

		return null;
	}

	public SinnkToken getSinnkToken() {
		return sinnkToken;
	}

	public void setSinnkToken(SinnkToken sinnkToken) {
		this.sinnkToken = sinnkToken;
	}

}
