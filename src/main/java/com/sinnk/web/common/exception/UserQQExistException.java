package com.sinnk.web.common.exception;

public class UserQQExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserQQExistException() {
		super();
	}

	public UserQQExistException(String message) {
		super(message);
	}

	public UserQQExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserQQExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserQQExistException(Throwable cause) {
		super(cause);
	}

}
