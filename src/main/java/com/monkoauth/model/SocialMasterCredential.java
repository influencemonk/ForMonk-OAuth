package com.monkoauth.model;

public class SocialMasterCredential {
	
	private String accessToken;
	private String refreshToken;
	private String expiresIn;
	private String clientId;
	private String socialHandleId;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expriesIn) {
		this.expiresIn = expiresIn;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getSocialHandleId() {
		return socialHandleId;
	}
	public void setSocialHandleId(String socialHandleId) {
		this.socialHandleId = socialHandleId;
	}
	
	
	
}
