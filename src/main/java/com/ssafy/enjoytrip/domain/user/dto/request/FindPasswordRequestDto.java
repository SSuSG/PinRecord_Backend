package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "(FindPasswordRequestDto) 비밀번호 찾기 요청 DTO" , description = "아이디 , 이메일을 가졌음")
public class FindPasswordRequestDto {

	@NotBlank
	@ApiModelProperty(value = "사용자 로그인 ID")
    private String loginid;

    @NotBlank
    @ApiModelProperty(value = "사용자 이메일")
    private String email;
    
}
