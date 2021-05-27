package com.cg.bookmydoctor.exception;

public class AvailabilityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public AvailabilityException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;

	}
}
