package com.ssafy.enjoytrip.global.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.ssafy.enjoytrip.domain.user.entity.User;

@Component
public class PasswordHash {
	// 사용할 해시 알고리즘
	private static final String HASH_ALGORITHM = "SHA-256";
	// 솔트 생성을 위한 난수 생성기 알고리즘
	private static final String RNG_ALGORITHM = "SHA1PRNG";
	// 솔트의 길이
	private static final int SALT_LENGTH = 32;
	// 해시 반복 횟수
	private static final int HASH_ITERATIONS = 10000;
	// 출력값의 길이
	private static final int HASH_OUTPUT_LENGTH = 32;

	// 비밀번호를 해싱하여 출력값을 반환하는 메소드
	public static String hashPassword(String password, User user) throws NoSuchAlgorithmException {
		// 랜덤한 솔트 생성
		SecureRandom random = SecureRandom.getInstance(RNG_ALGORITHM);
		byte[] salt = new byte[SALT_LENGTH];
		random.nextBytes(salt);

		// 솔트와 비밀번호를 결합한 문자열 생성
		String saltedPassword = Base64.getEncoder().encodeToString(salt) + password;
		// 유저에게 솔트도 같이 저장
		user.setSalt(Base64.getEncoder().encodeToString(salt));

		// 해시 함수 생성 및 초기화
		MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
		digest.reset();

		// 반복하여 해싱
		byte[] hashValue = saltedPassword.getBytes();
		for (int i = 0; i < HASH_ITERATIONS; i++) {
			hashValue = digest.digest(hashValue);
		}

		// 솔트와 해싱 결과를 Base64 인코딩하여 하나의 문자열로 생성
		return Base64.getEncoder().encodeToString(hashValue);
	}

	// 입력된 비밀번호가 저장된 비밀번호와 일치하는지 확인하는 메소드
	public static boolean checkPassword(String password, String hashedPassword, String userSalt)
			throws NoSuchAlgorithmException {
		byte[] salt = new byte[SALT_LENGTH];
		salt = Base64.getDecoder().decode(userSalt);

		// 솔트와 비밀번호를 결합한 문자열 생성
		String saltedPassword = userSalt + password;

		// 해시 함수 생성 및 초기화
		MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
		digest.reset();

		// 반복하여 해싱
		byte[] hashValue = saltedPassword.getBytes();
		for (int i = 0; i < HASH_ITERATIONS; i++) {
			hashValue = digest.digest(hashValue);
		}

		// 저장된 해시값과 일치하는지 확인
		if (Base64.getEncoder().encodeToString(hashValue).equals(hashedPassword))
			return true;
		return false;
	}

}
