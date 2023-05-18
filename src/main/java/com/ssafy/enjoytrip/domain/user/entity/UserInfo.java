package com.ssafy.enjoytrip.domain.user.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.UrlResource;

import com.ssafy.enjoytrip.domain.user.dto.response.UserResponseDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
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
	
	@ApiModelProperty(value = "유저의 팔로워 수")
	private String followerCnt;
	
	@ApiModelProperty(value = "유저의 팔로잉 수")
	private String followingCnt;
	
	public UserResponseDto toUserResponseDto() throws IOException  {
		byte[] imageByteArray = null;
		if(profileImage != null && profileImage.length() > 0) {
			InputStream imageStream = new FileInputStream(profileImage);
			imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
		}
		
		return UserResponseDto.builder()
				.userId(userId)
				.name(name)
				.email(email)
				.nickname(nickname)
//				.profileImage(profileImage)
				.urlProfileImage(imageByteArray)
				.followerCnt(followerCnt)
				.followingCnt(followingCnt)
				.build();
	}
}
