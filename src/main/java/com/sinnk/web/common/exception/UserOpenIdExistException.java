package com.sinnk.web.common.exception;

public class UserOpenIdExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserOpenIdExistException() {
		super();
	}

	public UserOpenIdExistException(String message) {
		super(message);
	}

	public UserOpenIdExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserOpenIdExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserOpenIdExistException(Throwable cause) {
		super(cause);
	}

}
