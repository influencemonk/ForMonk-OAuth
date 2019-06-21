package com.monkoauth.repo;


import com.monkoauth.model.SocialMaster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocialMasterRepo extends MongoRepository<SocialMaster, String> {

	SocialMaster findByImcId(String imcId);

}
