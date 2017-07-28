package com.sinnk.web.common.exception;

public class UserIdentityCardIdExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserIdentityCardIdExistException() {
		super();
	}

	public UserIdentityCardIdExistException(String message) {
		super(message);
	}

	public UserIdentityCardIdExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserIdentityCardIdExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserIdentityCardIdExistException(Throwable cause) {
		super(cause);
	}

}
