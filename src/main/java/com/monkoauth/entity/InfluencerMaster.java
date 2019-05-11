package com.monkoauth.entity;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.monkoauth.model.SocialAccount;


@Document(collection = "InfluencerMasterCollection")
public class InfluencerMaster {
	
	
	@BsonId
	private String id;
	private List<SocialAccount> socialAccounts;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<SocialAccount> getSocialAccounts() {
		return socialAccounts;
	}
	public void setSocialAccounts(List<SocialAccount> socialAccounts) {
		this.socialAccounts = socialAccounts;
	}
	
	
	
}
