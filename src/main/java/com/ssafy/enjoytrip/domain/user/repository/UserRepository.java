package com.ssafy.enjoytrip.domain.user.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.user.dto.request.UpdateProfileImageRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.response.UserResponseDto;
import com.ssafy.enjoytrip.domain.user.entity.User;
import com.ssafy.enjoytrip.domain.user.entity.UserInfo;
import com.ssafy.enjoytrip.domain.user.entity.UserProfileImage;

@Mapper
public interface UserRepository {
	boolean existsByEmail(String email);
	boolean existsByLoginId(String loginId);
	int createUserAccount(User user);
	User findUserByEmail(String email);
	User findUserByLoginId(String loginId);
	int addMismatchCnt(String loginId);
	int initMismatchCnt(String loginId);
	int unlockAccount(User user);
	int updateAuthStatus(String loginId);
	int updatePassword(User user);
	int updateLockStatus(Map<String, String> map);
	int updateProfileImage(UpdateProfileImageRequestDto updateProfileImageRequestDto);
	int updateProfileImage(UserProfileImage userProfileImage);
	UserInfo getUserByUserId(int userId);
	String getUserProfileImage(int userId);
	int saveRefreshToken(Map<String, String> map);
	int deleRefreshToken(Map<String, String> map);
	List<UserInfo> getUserListByNickname(String nickname);
}
