package com.ssafy.enjoytrip.domain.user.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.ssafy.enjoytrip.domain.user.dto.response.LoginResponseDto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private int userId;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String salt;
	private String nickname;
	private String lockKey;
	private String imagePath;
	private int mismatchCnt;
	private boolean isAuth;
	private boolean isLock;
	private String authKey;
	
	public void passwordHashing(String hashedPassword) {
		this.password = hashedPassword;
	}
	
	public LoginResponseDto toLoginResponseDto() throws IOException {
		byte[] imageByteArray = null;
		if(imagePath != null && imagePath.length() > 0) {
			InputStream imageStream = new FileInputStream(imagePath);
			imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
		}
		
		return LoginResponseDto.builder()
				.userId(userId)
				.loginId(loginId)
				.nickname(nickname)
				.name(name)
				.image(imageByteArray)
				.build();
	}

	public void addMismatchCnt() {
		this.mismatchCnt += 1;
	}

	public void initMismatchCnt() {
		this.mismatchCnt = 0;
	}

	public void initialAuthKeyAndHashingPw(String authKey , String hashPassword) {
		this.authKey = authKey;
		this.password = hashPassword;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
}
