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
@ApiModel(value = "(UnlockAccountRequestDto) 계정잠금해제 요청 DTO" , description = "계정아이디와 인증번호를 가졌음")
public class UnlockAccountRequestDto {

	@Email
	@ApiModelProperty(value = "사용자 로그인ID")
    private String loginId;

    @NotBlank
    @ApiModelProperty(value = "잠금해제를 위한 인증번호")
    private String lockKey;
}
