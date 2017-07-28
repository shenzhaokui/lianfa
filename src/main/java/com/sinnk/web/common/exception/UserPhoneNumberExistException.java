package com.sinnk.web.common.exception;

public class UserPhoneNumberExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserPhoneNumberExistException() {
		super();
	}

	public UserPhoneNumberExistException(String message) {
		super(message);
	}

	public UserPhoneNumberExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserPhoneNumberExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserPhoneNumberExistException(Throwable cause) {
		super(cause);
	}

}
