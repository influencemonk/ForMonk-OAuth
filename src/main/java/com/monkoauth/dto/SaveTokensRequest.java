package com.monkoauth.dto;

public class SaveTokensRequest {
	
	private String accessToken;
	private String refreshToken;
	private String clientId;
	private String expiresIn;
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
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
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
