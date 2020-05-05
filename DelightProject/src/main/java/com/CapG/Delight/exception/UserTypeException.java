package com.CapG.Delight.exception;

public class UserTypeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public UserTypeException(String msg)
	{
		super(msg);
	}
}