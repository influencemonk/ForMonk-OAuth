package com.monkoauth.utils;

public class CustomException extends Exception {

	public CustomException(String e){
		super(e);
	}
	
	@Override
	public void printStackTrace() {
		super.printStackTrace();
		System.out.println(getMessage());
	}
	
}
