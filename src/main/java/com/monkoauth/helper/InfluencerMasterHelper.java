package com.monkoauth.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.monkoauth.dao.InfluencerMasterDao;
import com.monkoauth.entity.InfluencerMaster;
import com.monkoauth.model.SocialAccount;


@Transactional
public class InfluencerMasterHelper {
	
	
	@Autowired
	private InfluencerMasterDao influencerMasterDao;

	
	/**
	 * Method to get IMCId of a user with provided social handle Id and saves the data if not present
	 * 
	 * @param socialHandleId
	 * @param socialHandle
	 * @param clientId
	 * @return IMCId
	 */
	public String getIMCId(String socialHandleId, String socialHandle, String clientId) {

		InfluencerMaster imcRecord = influencerMasterDao.findBysocialAccounts(socialHandleId, clientId);
		
		if(null == imcRecord) {
			imcRecord = new InfluencerMaster();
			SocialAccount socialAccount = new SocialAccount();
			socialAccount.setClientId(clientId);
			socialAccount.setSocialHandle(socialHandle);
			
			List<SocialAccount> socialAccountList = new ArrayList<>();
			socialAccountList.add(socialAccount);
			
			imcRecord.setSocialAccounts(socialAccountList);
			
			imcRecord = influencerMasterDao.insert(imcRecord);
		}
		
		return imcRecord.getId();
		
	}
	
}
