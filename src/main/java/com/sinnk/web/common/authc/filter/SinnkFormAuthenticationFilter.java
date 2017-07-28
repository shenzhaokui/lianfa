package com.sinnk.web.common.authc.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.sinnk.web.common.authc.token.SinnkToken;
import com.sinnk.web.common.enums.LianfaEnum;
import com.sinnk.web.common.utils.CryptoUtils;
import com.sinnk.web.common.utils.UserAgentUtils;
import com.sinnk.web.module.admin.entity.AdminEntity;
import com.sinnk.web.module.admin.entity.AdminLoginEntity;
import com.sinnk.web.module.admin.service.AdminService;
import com.sinnk.web.module.user.entity.UserEntity;
import com.sinnk.web.module.user.entity.UserLoginEntity;
import com.sinnk.web.module.user.service.UserCommonService;

public class SinnkFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserCommonService userService;

	@Autowired
	private AdminService adminService;

	public SinnkFormAuthenticationFilter() {

	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {

		if (null != token.getPrincipal()) {
			request.setAttribute("username", (String) token.getPrincipal());
		}

		SinnkToken sinnkToken = (SinnkToken) token;
		if (null != sinnkToken) {
			if (sinnkToken.getUserType().equals(SinnkToken.USER_LOHIN_TYPE)) {
				UserEntity user = userService.getUserByUsername((String) token.getPrincipal());
				if (null != user) {
					if (user.getLocked().equals(LianfaEnum.ACCOUNT_UNLOCKED.getValue())) {
						UserLoginEntity loginEntity = new UserLoginEntity();
						loginEntity.preInsert();
						loginEntity.setLoginStatus(LianfaEnum.LOGIN_FAIL.getValue());
						loginEntity.setLoginDate(loginEntity.getCreateDate());
						if (UserAgentUtils.isComputer((HttpServletRequest) request)) {
							loginEntity.setLoginType(LianfaEnum.LOGIN_TYPE_PC.getValue());
						} else {
							loginEntity.setLoginType(LianfaEnum.LOGIN_TYPE_MOBILE.getValue());
						}
						loginEntity.setLoginIp(((SinnkToken) token).getIp());
						loginEntity.setUserId(user.getId());
						userService.addUserLoginRecord(loginEntity);
						userService.isDoLockedAccount(user.getUsername());
					}
				}
			} else if (sinnkToken.getUserType().equals(SinnkToken.ADMIN_LOGIN_TYPE)) {
				AdminEntity admin = adminService.getAdminByUsername((String) token.getPrincipal());
				if (null != admin) {
					if (admin.getLocked().equals(LianfaEnum.ACCOUNT_UNLOCKED.getValue())) {
						AdminLoginEntity adminlogin = new AdminLoginEntity();
						adminlogin.preInsert();
						adminlogin.setLoginStatus(LianfaEnum.LOGIN_FAIL.getValue());
						adminlogin.setLoginDate(adminlogin.getCreateDate());
						if (UserAgentUtils.isComputer((HttpServletRequest) request)) {
							adminlogin.setLoginType(LianfaEnum.LOGIN_TYPE_PC.getValue());
						} else {
							adminlogin.setLoginType(LianfaEnum.LOGIN_TYPE_MOBILE.getValue());
						}
						adminlogin.setLoginIp(((SinnkToken) token).getIp());
						adminlogin.setAdminId(admin.getId());
						adminService.addAdminLoginRecord(adminlogin);
						adminService.isDoLockedAccount(admin.getUsername());
					}

				}
			}
		}

		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest hr = (HttpServletRequest) request;
		if (StringUtils.contains(hr.getRequestURI(), "/sinnk")) {
			setLoginUrl("/sinnk/login");
		} else {
			setLoginUrl("/user/login");
		}

		return super.onAccessDenied(request, response);
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {

		HttpServletRequest hr = (HttpServletRequest) request;
		String userType = "";
		if (StringUtils.endsWith(hr.getRequestURI(), "/user/login")) {
			userType = SinnkToken.USER_LOHIN_TYPE;
		} else if (StringUtils.endsWith(hr.getRequestURI(), "/sinnk/login")) {
			userType = SinnkToken.ADMIN_LOGIN_TYPE;
		}

		String username = this.getUsername(request);
		String password = null == this.getPassword(request) ? "" : CryptoUtils.MD5(this.getPassword(request));
		String host = this.getHost(request);
		boolean rememberMe = this.isRememberMe(request);
		String ip = hr.getRemoteAddr();

		return new SinnkToken(username, password, rememberMe, host, userType, ip);

	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		if (subject.hasRole("admin")) {
			this.setSuccessUrl("/sinnk/index");
		} else {
			this.setSuccessUrl("/user/index");
		}

		SinnkToken sinnkToken = (SinnkToken) token;
		if (null != sinnkToken) {
			if (sinnkToken.getUserType().equals(SinnkToken.USER_LOHIN_TYPE)) {
				UserEntity user = userService.getUserByUsername((String) token.getPrincipal());
				if (null != user) {
					UserLoginEntity loginEntity = new UserLoginEntity();
					loginEntity.preInsert();
					loginEntity.setLoginStatus(LianfaEnum.LOGIN_SUCCESS.getValue());
					loginEntity.setLoginDate(loginEntity.getCreateDate());
					if (UserAgentUtils.isComputer((HttpServletRequest) request)) {
						loginEntity.setLoginType(LianfaEnum.LOGIN_TYPE_PC.getValue());
					} else {
						loginEntity.setLoginType(LianfaEnum.LOGIN_TYPE_MOBILE.getValue());
					}
					loginEntity.setLoginIp(((SinnkToken) token).getIp());
					loginEntity.setUserId(user.getId());
					userService.addUserLoginRecord(loginEntity);

					subject.getSession().setAttribute("currentuser", user);
					
				}
			} else if (sinnkToken.getUserType().equals(SinnkToken.ADMIN_LOGIN_TYPE)) {
				AdminEntity admin = adminService.getAdminByUsername((String) token.getPrincipal());
				if (null != admin) {
					AdminLoginEntity adminlogin = new AdminLoginEntity();
					adminlogin.preInsert();
					adminlogin.setLoginStatus(LianfaEnum.LOGIN_SUCCESS.getValue());
					adminlogin.setLoginDate(adminlogin.getCreateDate());
					if (UserAgentUtils.isComputer((HttpServletRequest) request)) {
						adminlogin.setLoginType(LianfaEnum.LOGIN_TYPE_PC.getValue());
					} else {
						adminlogin.setLoginType(LianfaEnum.LOGIN_TYPE_MOBILE.getValue());
					}
					adminlogin.setLoginIp(((SinnkToken) token).getIp());
					adminlogin.setAdminId(admin.getId());
					adminService.addAdminLoginRecord(adminlogin);
				}
			}
		}

		return super.onLoginSuccess(token, subject, request, response);
	}

}
