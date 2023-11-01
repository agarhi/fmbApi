package com.fmb.api.error.handling;

public class FmbException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FmbException() {
		super();
	}

	public FmbException(final String message) {
		super(message);
	}

}
