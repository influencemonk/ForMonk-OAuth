package com.monkoauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monkoauth.utils.GeneralUtils;
import com.monkoauth.dto.SaveTokensRequest;
import com.monkoauth.dto.SaveTokensResponse;
import com.monkoauth.model.ApiResponseModel;

@Controller
@RequestMapping("/OAuth")
public class InstaOAuthController {

	@PutMapping("/saveTokens")
	public @ResponseBody ResponseEntity<?> saveTokens(@RequestBody SaveTokensRequest request) {
		ApiResponseModel<SaveTokensResponse> response = null;
		
		if(response == null )
			return GeneralUtils.throwGenericErrorResponse();
	
		return new ResponseEntity<>(response , response.getError() ? HttpStatus.BAD_REQUEST : HttpStatus.OK);
	}
	
}
