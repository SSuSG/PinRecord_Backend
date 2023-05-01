package com.ssafy.enjoytrip.domain.user.dto.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(LoginResponseDto) 로그인 요청 후 반환 DTO" , description = "로그인 성공한 유저의 아이디,닉네임 지님")
public class LoginResponseDto {
	@ApiModelProperty(value = "로그인유저 PK")
	private int userId;
	
	@ApiModelProperty(value = "로그인유저 로그인 ID")
	private String loginId;
	
	@ApiModelProperty(value = "로그인유저 닉네임")
	private String nickname;
	
}
