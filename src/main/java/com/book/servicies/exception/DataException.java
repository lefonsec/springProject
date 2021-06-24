package com.book.servicies.exception;

public class DataException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataException(String message) {
		super(message);
	}

}
