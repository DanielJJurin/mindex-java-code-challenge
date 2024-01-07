package com.mindex.challenge.exception;

public class CompensationNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7664715504201455953L;
	public CompensationNotFoundException() {
		super();
	}
	public CompensationNotFoundException(Exception e) {
		super(e);
	}
	public CompensationNotFoundException(String string) {
		super(string);
	}

}
