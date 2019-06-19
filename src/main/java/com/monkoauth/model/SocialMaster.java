package com.monkoauth.model;

import com.monkoauth.entity.SocialMasterBase;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "SocialMaster")
public class SocialMaster extends SocialMasterBase {
	
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
	public void setExpiresIn(Date expriesIn) {
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
