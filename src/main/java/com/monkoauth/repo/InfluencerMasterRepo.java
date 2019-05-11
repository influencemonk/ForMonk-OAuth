package com.monkoauth.repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.monkoauth.entity.InfluencerMaster;


@Repository
public interface InfluencerMasterRepo extends MongoRepository<InfluencerMaster , String> {

	public InfluencerMaster findBysocialAccounts(String socialHandleId , String clientId);
	
}
