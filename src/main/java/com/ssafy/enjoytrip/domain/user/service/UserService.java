package com.ssafy.enjoytrip.domain.user.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.MailException;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.enjoytrip.domain.user.dto.request.AcccssTokenRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.AuthAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.UpdateProfileImageRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.CreateUserAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.FindPasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.LoginRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.UnlockAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.UpdatePasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.response.LoginResponseDto;
import com.ssafy.enjoytrip.domain.user.dto.response.UserResponseDto;
import com.ssafy.enjoytrip.domain.user.entity.User;

public interface UserService {
	LoginResponseDto login(LoginRequestDto loginRequestDto,HttpServletResponse response) throws NoSuchAlgorithmException, MailException, IllegalArgumentException, MessagingException;
	Boolean isLock(User loginUser) throws NoSuchAlgorithmException;
//	void setSession(LoginResponseDto loginResponseDto  ,HttpServletRequest request , HttpServletResponse response);
	void logout(String loginId);
	int createUserAccount(CreateUserAccountRequestDto createUserAccountRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException;
	boolean isEmailDuplicate(String email);
	boolean isLoginIdDuplicate(String loginId);
	int authAccount(AuthAccountRequestDto authAccountRequestDto);
	String findLoginIdByEmail(String email);
	int findPasswordByLoginIdAndEmail(FindPasswordRequestDto findPasswordRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException;
	User findUserByLoginIdOrEmail(String input , boolean isLoginId);
	int updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto) throws NoSuchAlgorithmException;
	int unlockAccount(UnlockAccountRequestDto unlockAccountRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException;
//	int updateProfileImage(MultipartFile profileImage , int userId) throws IOException;
	int updateProfileImage(UpdateProfileImageRequestDto changeProfileImageRequestDto);
	UserResponseDto getUserByUserId(int userId);
	String getUserProfileImage(int userId);
	void setToken(User loginUser , HttpServletResponse response);
	LoginResponseDto isLoginUser(String loginId, HttpServletRequest request);
	String getNewAcccessToken(String loginId, HttpServletRequest request);
}
