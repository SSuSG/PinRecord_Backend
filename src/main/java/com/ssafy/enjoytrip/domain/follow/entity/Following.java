package com.ssafy.enjoytrip.domain.follow.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Following {
	private int followingUserId;
	private String nickname;
	private String name;
	private String imagePath;
	
	public FollowingResponseDto toDto() throws IOException {
		byte[] imageByteArray = null;
		if(imagePath != null && imagePath.length() > 0) {
			InputStream imageStream = new FileInputStream(imagePath);
			imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
		}
		
		return FollowingResponseDto.builder()
				.followingUserId(followingUserId)
				.nickname(nickname)
				.name(name)
				.image(imageByteArray)
				.build();
	}
}
