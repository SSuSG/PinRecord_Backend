package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(AuthAccountRequestDto) 계정인증 요청 DTO" , description = "계정이메일과 인증번호를 가졌음")
public class AuthAccountRequestDto {

	@Email
	@ApiModelProperty(value = "사용자 로그인 아이디")
    private String loginId;

    @NotBlank
    @ApiModelProperty(value = "계정인증을 위한 인증번호")
    private String authKey;
}
