package com.monkoauth.model;

import com.monkoauth.entity.SocialMasterBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper=true)
@Data
@Document(collection = "SocialMaster")
public class SocialMaster extends SocialMasterBase {
	private String accessToken;
	private String refreshToken;
	private Date expiryDate;
	private String clientId;
	private String socialHandleId;
}
