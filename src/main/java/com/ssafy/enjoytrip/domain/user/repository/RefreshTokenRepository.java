package com.ssafy.enjoytrip.domain.user.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
public class RefreshTokenRepository {

	private static final String REFRESH_TOKEN_KEY_PREFIX = "refreshToken:";

	private final RedisTemplate<String, String> redisTemplate;

	public RefreshTokenRepository(RedisTemplate<String, String> redisTemplate,
                                  RedisConnectionFactory redisConnectionFactory) {
		this.redisTemplate = redisTemplate;
		this.redisTemplate.setConnectionFactory(redisConnectionFactory);
		this.redisTemplate.afterPropertiesSet();
	}

	public void saveRefreshToken(String userLoginId, String refreshToken) {
		log.info("RefreshTokenRepository_saveRefreshToken -> 토큰 저장");
		String key = getRefreshTokenKey(userLoginId);
		redisTemplate.opsForValue().set(key, refreshToken); // 7일 동안 저장
		redisTemplate.expire(key, 14, TimeUnit.DAYS);
	}

	public boolean existsByRefreshToken(String userLoginId) {
		String key = getRefreshTokenKey(userLoginId);
		return redisTemplate.hasKey(key);
	}
	
	public String getRefreshToken(String userLoginId) {
		return redisTemplate.opsForValue().get(userLoginId);
	}

	public void deleteRefreshToken(String userLoginId) {
		log.info("RefreshTokenRepository_deleteRefreshToken -> 토큰 삭제");
		String key = getRefreshTokenKey(userLoginId);
		redisTemplate.delete(key);
	}

	private String getRefreshTokenKey(String userLoginId) {
		return REFRESH_TOKEN_KEY_PREFIX + userLoginId;
	}

}

