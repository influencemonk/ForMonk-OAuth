package com.monkoauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monkoauth.dto.SaveTokensRequest;
import com.monkoauth.dto.SaveTokensResponse;
import com.monkoauth.helper.OAuthDataHelper;
import com.monkoauth.model.ApiResponseModel;
import com.monkoauth.utils.GeneralUtils;

@Controller
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
	
		return new ResponseEntity<>(response , response.getError() ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}
	
	@GetMapping("/ping2")
	public @ResponseBody ResponseEntity<?> ping(){
		return new ResponseEntity<>(eurekaUrl , HttpStatus.OK);
	}
	
}
