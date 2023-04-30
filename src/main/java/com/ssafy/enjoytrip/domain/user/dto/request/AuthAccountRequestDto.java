package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "계정인증 요청 DTO" , description = "계정이메일과 인증번호를 가졌음")
public class AuthAccountRequestDto {

	@NotBlank
	@ApiModelProperty(value = "사용자 이메일")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "계정인증을 위한 인증번호")
    private String authKey;
}
