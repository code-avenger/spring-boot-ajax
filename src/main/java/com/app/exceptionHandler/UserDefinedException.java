package com.app.exceptionHandler;

public class UserDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private int errorId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorId() {
		return errorId;
	}
	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}
	public UserDefinedException(String message, int errorId) {
		super();
		this.message = message;
		this.errorId = errorId;
	}

	public UserDefinedException() {
		super();

	}

}
