package com.ssafy.enjoytrip.domain.user.entity;

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
	private int mismatchCnt;
	private boolean isAuth;
	private boolean isLock;
	private String authKey;
	
	public void passwordHashing(String hashedPassword) {
		this.password = hashedPassword;
	}
	
	public LoginResponseDto toLoginResponseDto() {
		return LoginResponseDto.builder()
				.userId(userId)
				.loginId(loginId)
				.nickname(nickname)
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
