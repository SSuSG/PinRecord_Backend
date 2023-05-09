package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "(LoginRequestDto) 로그인 요청 DTO" , description = "아이디 , 패스워드를 가졌음")
public class LoginRequestDto {
	
	@NotBlank
	@ApiModelProperty(value = "사용자 로그인 ID")
    private String loginId;

    @NotBlank
    @ApiModelProperty(value = "사용자 로그인 PASSWORD")
    private String password;
    
}
