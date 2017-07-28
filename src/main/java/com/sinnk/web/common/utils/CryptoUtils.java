package com.sinnk.web.common.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

public class CryptoUtils {

	/**
	 * Base64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encBase64(String str) {
		return Base64.encodeToString(str.getBytes());
	}

	/**
	 * Base64解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decBase64(String str) {
		return Base64.decodeToString(str);
	}

	/**
	 * MD5加密、加盐、散列次数
	 * 
	 * @param str
	 * @return
	 */
	public static String MD5(String str) {
		return new Md5Hash(str, "sinnk", 2).toString();
	}

}
