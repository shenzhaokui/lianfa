package com.sinnk.web.common.exception;

public class UserEmailExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserEmailExistException() {
		super();
	}

	public UserEmailExistException(String message) {
		super(message);
	}

	public UserEmailExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserEmailExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserEmailExistException(Throwable cause) {
		super(cause);
	}

}
