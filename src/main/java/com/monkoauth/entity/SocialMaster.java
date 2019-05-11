package com.monkoauth.entity;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.monkoauth.model.SocialMasterCredential;


@Document(collection = "SocialMaster")
public class SocialMaster extends BaseEntity {
	
	@BsonId
	private String id;
	private String imcId;
	private List<SocialMasterCredential> credentials;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImcId() {
		return imcId;
	}
	public void setImcId(String imcId) {
		this.imcId = imcId;
	}
	public List<SocialMasterCredential> getCredentials() {
		return credentials;
	}
	public void setCredentials(List<SocialMasterCredential> credentials) {
		this.credentials = credentials;
	}
	
	
	
}
