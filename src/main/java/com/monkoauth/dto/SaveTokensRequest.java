package com.monkoauth.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SaveTokensRequest {
	
	private String accessToken;
	private String refreshToken;
	private String clientId;
	private Date expiresIn;
	private String socialHandle;
	private String socialHandleId;

}
