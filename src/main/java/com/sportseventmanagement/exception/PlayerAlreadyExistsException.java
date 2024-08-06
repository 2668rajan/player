package com.sportseventmanagement.exception;

public class PlayerAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PlayerAlreadyExistsException() {
		super();
	}
	
	public PlayerAlreadyExistsException(String message) {
		super(message);
	}

}
