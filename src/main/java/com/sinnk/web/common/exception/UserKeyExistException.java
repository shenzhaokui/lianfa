package com.sinnk.web.common.exception;

public class UserKeyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserKeyExistException() {
		super();
	}

	public UserKeyExistException(String message) {
		super(message);
	}

	public UserKeyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserKeyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserKeyExistException(Throwable cause) {
		super(cause);
	}

}
