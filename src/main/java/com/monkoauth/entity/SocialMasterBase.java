package com.monkoauth.entity;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;


public class SocialMasterBase extends BaseEntity {
	
	@BsonId
	private String id;
	private String imcId;

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

	
	
	
}
