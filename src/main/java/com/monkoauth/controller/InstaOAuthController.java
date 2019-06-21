package com.monkoauth.controller;

import com.monkoauth.model.SocialMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.monkoauth.dto.SaveTokensRequest;
import com.monkoauth.dto.SaveTokensResponse;
import com.monkoauth.helper.OAuthDataHelper;
import com.monkoauth.model.ApiResponseModel;
import com.monkoauth.utils.GeneralUtils;

@Controller
@Validated
@RequestMapping("/OAuth")
public class InstaOAuthController {
	
	@Autowired
	private OAuthDataHelper oAuthDataHelper;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaUrl;

	@PutMapping("/saveTokens")
	public @ResponseBody ResponseEntity<?> saveTokens(@RequestBody SaveTokensRequest request) {
		
		ApiResponseModel<SaveTokensResponse> response = oAuthDataHelper.saveTokens(request);

		if(response == null )
			return GeneralUtils.throwGenericErrorResponse();
	
		return new ResponseEntity<>(response , response.isError() ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}

	@GetMapping("getAuthTokens")
	public @ResponseBody ResponseEntity<?> getAuthTokens(@RequestHeader("ClientId") String clientId , @RequestParam String socialHandleId)
	{
		SocialMaster socialMaster = oAuthDataHelper.findValidAuthToken(clientId , socialHandleId);
		return new ResponseEntity<>(socialMaster , socialMaster == null ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}
	@GetMapping("/ping2")
	public @ResponseBody ResponseEntity<?> ping(){
		return new ResponseEntity<>(eurekaUrl , HttpStatus.OK);
	}
	
}
