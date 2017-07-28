package com.sinnk.web.common.utils;

import java.util.regex.Pattern;

public class ValidatorUtil {

	/**
	 * 判断URL请求参数是否合法
	 * 
	 * URL请求参数只能由24个小写英文字母和数字下划线以及英文状态下的等号组成
	 * 
	 * @param requestString
	 * @return
	 */
	public static boolean requestQueryStringValid(String requestString) {

		String regStr = "^[a-zA-Z0-9=&_]{0,100}$";

		Pattern pattern = Pattern.compile(regStr);

		if (null == requestString) {
			return false;
		}
		return pattern.matcher(requestString).matches();
	}

	/**
	 * 验证手机号码是否合法
	 * 
	 * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
	 * 
	 * 联通号码段:130、131、132、136、185、186、145
	 * 
	 * 电信号码段:133、153、180、189
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean mobilePhoneValidator(String phone) {

		if (null == phone) {
			return false;
		}
		String regStr = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
		Pattern pattern = Pattern.compile(regStr);
		return pattern.matcher(phone).matches();
	}

	/**
	 * 判断Email地址是否合法
	 * 
	 * @param email
	 * @return
	 */
	public static boolean emailValidator(String email) {
		if (null == email) {
			return false;
		}
		String regStr = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		Pattern pattern = Pattern.compile(regStr);
		return pattern.matcher(email).matches();
	}

	/**
	 * 密码验证，5-16位，字母数字下划线
	 * 
	 * @param username
	 * @return
	 */
	public static boolean userNameValidator(String username) {
		if (null == username) {
			return false;
		}

		String regStr = "^[a-zA-Z0-9_]{5,16}$";
		Pattern pattern = Pattern.compile(regStr);
		return pattern.matcher(username).matches();
	}

	/**
	 * 密码验证
	 * 
	 * 密码由任意非空字符组成，长度为6-16位之间
	 * 
	 * @param password
	 * @return
	 */
	public static boolean passwordValidator(String password) {
		if (null == password) {
			return false;
		}
		String regStr = "^\\S{6,16}$";
		Pattern pattern = Pattern.compile(regStr);
		return pattern.matcher(password).matches();
	}

	/**
	 * Reffer_Id 验证
	 * 
	 * @param refferid
	 * @return
	 */
	public static boolean refferIdValidator(String refferid) {
		if (null == refferid) {
			return false;
		}
		String regStr = "^[a-z0-9]{64}$";
		Pattern pattern = Pattern.compile(regStr);
		return pattern.matcher(refferid).matches();
	}

	// public static void main(String[] args) {
	// System.out.println(passwordValidator("aaaad_sdd*U__=家=aaaaaaaaaaaaaaaaaaa"));
	// }

}
