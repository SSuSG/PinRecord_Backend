package com.ssafy.enjoytrip.domain.user.dto.response;

import java.net.MalformedURLException;

import org.springframework.core.io.UrlResource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(UserResponseDto) 유저 정보 DTO" , description = "유저의 다양한 정보 반환")
public class UserResponseDto {

	@ApiModelProperty(value = "유저 PK")
	private int userId;
	
	@ApiModelProperty(value = "유저 이름")
	private String name;
	
	@ApiModelProperty(value = "유저 이메일")
	private String email;
	
	@ApiModelProperty(value = "유저 닉네임")
	private String nickname;
	
	@ApiModelProperty(value = "유저 프로필 이미지")
	private String profileImage;
	
	@ApiModelProperty(value = "유저 프로필 이미지")
	private byte[] urlProfileImage;
	
	@ApiModelProperty(value = "유저의 팔로워 수")
	private String followerCnt;
	
	@ApiModelProperty(value = "유저의 팔로잉 수")
	private String followingCnt;
	
}
