package com.mindex.challenge.exception;

public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7098789554422850908L;
	
	public EmployeeNotFoundException() {
		super();
	}
	public EmployeeNotFoundException(Exception e) {
		super(e);
	}
	public EmployeeNotFoundException(String string) {
		super(string);
	}

}
