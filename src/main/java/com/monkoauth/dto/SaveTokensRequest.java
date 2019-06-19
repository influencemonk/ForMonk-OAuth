package com.monkoauth.dto;

import java.util.Date;

public class SaveTokensRequest {
	
	private String accessToken;
	private String refreshToken;
	private String clientId;
	private Date expiresIn;
	private String socialHandle;
	private String socialHandleId;
	
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String authToken) {
		this.accessToken = authToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public Date getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Date expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getSocialHandle() {
		return socialHandle;
	}
	public void setSocialHandle(String socialHandle) {
		this.socialHandle = socialHandle;
	}
	public String getSocialHandleId() {
		return socialHandleId;
	}
	public void setSocialHandleId(String socialHandleId) {
		this.socialHandleId = socialHandleId;
	}
	
	
	
}
