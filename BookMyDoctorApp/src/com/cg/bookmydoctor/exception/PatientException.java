package com.cg.bookmydoctor.exception;

public class PatientException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public PatientException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
		
	}
}
