package com.monkoauth.model;

import lombok.Data;

@Data
public class ApiResponseModel<T> {

	private T serverObject;
	private boolean error;
	private String message;
	
	public ApiResponseModel() {}

}
