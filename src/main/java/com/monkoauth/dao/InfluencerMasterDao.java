package com.monkoauth.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.monkoauth.entity.InfluencerMaster;
import com.monkoauth.model.SocialAccount;
import com.monkoauth.repo.InfluencerMasterRepo;
import com.monkoauth.utils.CollectionUtils;


@Repository
public class InfluencerMasterDao implements InfluencerMasterRepo {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public <S extends InfluencerMaster> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<InfluencerMaster> findAll() {
		
		return mongoTemplate.findAll(InfluencerMaster.class);
	}

	@Override
	public List<InfluencerMaster> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> S insert(S entity) {

		 mongoTemplate.insert(entity);
		 
		 return entity;
	}

	@Override
	public <S extends InfluencerMaster> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<InfluencerMaster> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<InfluencerMaster> findById(String id) {
		
		Optional<InfluencerMaster> optionInfluencerMaster = Optional.ofNullable(mongoTemplate.findById(id, InfluencerMaster.class));
		
		return optionInfluencerMaster;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<InfluencerMaster> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InfluencerMaster entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends InfluencerMaster> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends InfluencerMaster> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends InfluencerMaster> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends InfluencerMaster> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public InfluencerMaster insert(String socialHandle , String clientId) {
		
		InfluencerMaster InfluencerMaster = new InfluencerMaster();
		SocialAccount imSocialAccount = new SocialAccount();
		imSocialAccount.setClientId(clientId);
		imSocialAccount.setSocialHandle(socialHandle);
		List<SocialAccount> accounts = new ArrayList<>();
		accounts.add(imSocialAccount);
		InfluencerMaster.setSocialAccounts(accounts);
		
		return insert(InfluencerMaster);
	}

	@Override
	public InfluencerMaster findBysocialAccounts(String socialHandleId , String clientId) {
		
		MatchOperation matchStage = Aggregation.match(new Criteria("socialAccounts.socialHandleId").is(socialHandleId));
		MatchOperation clientIdMath = Aggregation.match(Criteria.where("socialAccounts.clientId").is(clientId));
		
		Aggregation aggregation 
		  = Aggregation.newAggregation(matchStage,clientIdMath);
		
		return mongoTemplate.aggregate(
				aggregation, 
				CollectionUtils.DBCollections.InfluencerMasterCollection.name(), 
				InfluencerMaster.class)
				.getUniqueMappedResult();
	}

}
