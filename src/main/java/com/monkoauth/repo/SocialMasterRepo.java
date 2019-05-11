package com.monkoauth.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.monkoauth.entity.SocialMaster;


@Repository
public interface SocialMasterRepo extends MongoRepository<SocialMaster, String> {

	public SocialMaster findByImcId(String imcId);
	
}
