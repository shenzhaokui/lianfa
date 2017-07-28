package com.sinnk.web.common.exception;

public class UserUsernameExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserUsernameExistException() {
		super();
	}

	public UserUsernameExistException(String message) {
		super(message);
	}

	public UserUsernameExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserUsernameExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserUsernameExistException(Throwable cause) {
		super(cause);
	}

}
