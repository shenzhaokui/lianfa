package com.sinnk.web.common.exception;

public class UserKeyNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserKeyNotExistException() {
		super();
	}

	public UserKeyNotExistException(String message) {
		super(message);
	}

	public UserKeyNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserKeyNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserKeyNotExistException(Throwable cause) {
		super(cause);
	}

}
