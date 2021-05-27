package com.cg.bookmydoctor.exception;

public class FeedBackException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public FeedBackException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
		
	}
}
