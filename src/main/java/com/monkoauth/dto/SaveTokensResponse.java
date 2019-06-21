package com.monkoauth.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class SaveTokensResponse extends BaseResponse {

    private String imcId;
}
