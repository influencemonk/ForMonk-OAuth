package com.monkoauth.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monkoauth.constants.ApiConstants.RESPONSE;
import com.monkoauth.dao.SocialMasterDao;
import com.monkoauth.dto.SaveTokensRequest;
import com.monkoauth.dto.SaveTokensResponse;
import com.monkoauth.entity.SocialMaster;
import com.monkoauth.model.ApiResponseModel;
import com.monkoauth.model.SocialMasterCredential;

@Component
public class OAuthDataHelper {

	@Autowired
	private SocialMasterDao socialMasterDao;

	@Autowired
	private InfluencerMasterHelper influencerMasterHelper;
	
	
	/**
	 * Method to save access and refresh token in Social Master
	 * 
	 * @param request
	 * @return IMCId
	 */
	public ApiResponseModel<SaveTokensResponse> saveTokens (SaveTokensRequest request) {
		
		ApiResponseModel<SaveTokensResponse> apiResponse = null;
		
		try {
			String socialHandleId = request.getSocialHandleId();
			String clientId = request.getClientId();
			String socialHandle = request.getSocialHandle();
			
			// Get IMCId of the user:
			String imcId = influencerMasterHelper.getIMCId(socialHandleId, socialHandle, clientId);
			
			SocialMaster smcRecord = socialMasterDao.findByImcId(imcId);
			
			if(null == smcRecord) {
				smcRecord = new SocialMaster();
				smcRecord.setImcId(imcId);
			}
			
			String accessToken = request.getAccessToken();
			String refreshToken = request.getRefreshToken();
			String expiresIn = request.getExpiresIn();
			
			// Save data in Social Master Collection:
			saveOrUpdateRecord(smcRecord, accessToken, refreshToken, expiresIn, clientId, socialHandleId);
			
			apiResponse = new ApiResponseModel<>();
			SaveTokensResponse response = new SaveTokensResponse();
			response.setImcId(imcId);
			response.setStatus(RESPONSE.SUCCESS);
			response.setMessage("Data updated successfully");
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return apiResponse;
	}

	
	/**
	 * Method to save or update Social Master record with new access and refresh tokens
	 * 
	 * @param smcRecord
	 * @param accessToken
	 * @param refreshToken
	 * @param expiresIn
	 * @param clientId
	 * @param socialHandleId
	 */
	private void saveOrUpdateRecord(SocialMaster smcRecord, String accessToken, String refreshToken, String expiresIn,
			String clientId, String socialHandleId) {
		
		// Prepare new SMC credential using new token details:
		SocialMasterCredential smcCredential = new SocialMasterCredential();
		smcCredential.setAccessToken(accessToken);
		smcCredential.setClientId(clientId);
		smcCredential.setExpiresIn(expiresIn);
		smcCredential.setRefreshToken(refreshToken);
		smcCredential.setSocialHandleId(socialHandleId);
		
		List<SocialMasterCredential> smcCredentialList = smcRecord.getCredentials();
		if(null != smcCredentialList) {
			
			boolean clientIdFound = false;
			
			for(int i = 0; i < smcCredentialList.size(); i++) {
				SocialMasterCredential credential = smcCredentialList.get(i);
				if(credential.getClientId().equals(clientId)) {
					smcCredentialList.set(i, smcCredential);
					clientIdFound = true;
				}
			}
			
			if(!clientIdFound) {
				smcCredentialList.add(smcCredential);
			}
			
		}
		else {
			smcCredentialList = new ArrayList<>();
			smcCredentialList.add(smcCredential);
		}
		
		smcRecord.setCredentials(smcCredentialList);
		
		// Save the data:
		socialMasterDao.insert(smcRecord);
		
	}
	
	
	
	
	
}
