package com.ssafy.enjoytrip.domain.user.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.user.entity.User;

@Mapper
public interface AccountRepository {
	boolean existsByEmail(String email);
	boolean existsByLoginId(String loginId);
	int createUserAccount(User user);
	User findUserByEmail(String email);
	User findUserByLoginId(String loginId);
	int addMismatchCnt(String loginId);
	int initMismatchCnt(String loginId);
	int unlockAccount(User user);
	int updateAuthStatus(String email);
	int updatePassword(User user);
	int updateLockStatus(String loginId , String lockKey);
}
