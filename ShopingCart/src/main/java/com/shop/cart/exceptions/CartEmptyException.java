package com.shop.cart.exceptions;

public class CartEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
