package com.ssafy.enjoytrip.domain.user.service;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.ssafy.enjoytrip.domain.user.repository.UserRepository;
import com.ssafy.enjoytrip.global.exception.ExceptionCode;
import com.ssafy.enjoytrip.global.exception.ExistEmailException;
import com.ssafy.enjoytrip.global.exception.ExistLoginIdException;
import com.ssafy.enjoytrip.global.exception.FailLoginException;
import com.ssafy.enjoytrip.global.exception.InValidEmailException;
import com.ssafy.enjoytrip.global.exception.InValidPasswordException;
import com.ssafy.enjoytrip.global.exception.LockAccountException;
import com.ssafy.enjoytrip.global.exception.NoAuthException;
import com.ssafy.enjoytrip.global.exception.NotExistAccountException;
import com.ssafy.enjoytrip.global.util.CheckForm;
import com.ssafy.enjoytrip.global.util.MailService;
import com.ssafy.enjoytrip.global.util.PasswordHash;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final PasswordHash passwordHash;
	private final CheckForm CheckForm;
	private final MailService mailService;
	
	@Override
	@Transactional
	public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest request,
			HttpServletResponse response) throws NoSuchAlgorithmException, MailException, IllegalArgumentException, MessagingException {
		log.info("UserServiceImpl_login");
		User loginUser = findUserByLoginIdOrEmail(loginRequestDto.getLoginId(), true);
		if(loginUser == null) throw new NotExistAccountException();
		LoginResponseDto loginResponseDto = loginUser.toLoginResponseDto();
		if(loginUser.isLock())
			throw new LockAccountException();
		
		if(isLock(loginUser)) {
			log.info("비밀번호 5회 오입력으로 인하여 계정이 잠금되었습니다. 이메일로 발송된 인증번호로 잠금을 해제해주세요.");
			String lockKey = mailService.sendSimpleMessageForAuth(loginUser.getEmail());
			userRepository.updateLockStatus(loginUser.getLoginId() , lockKey);
			throw new LockAccountException();
		}
		
		if(!loginUser.isAuth())
			throw new NoAuthException();
		
		if(!passwordHash.checkPassword(loginRequestDto.getPassword(), loginUser.getPassword(), loginUser.getSalt()) ) {
			userRepository.addMismatchCnt(loginUser.getLoginId());
			log.info("로그인 실패 , 비밀번호 틀린 횟수 : {}" , loginUser.getMismatchCnt());
			throw new FailLoginException();
		}
		
		setSession(loginResponseDto,request, response);
		userRepository.initMismatchCnt(loginUser.getLoginId());
		return loginResponseDto;
	}

	@Override
	public Boolean isLock(User loginUser) {
		 if(loginUser.getMismatchCnt() >= 5){
            log.info("현재 로그인 시도계정은 잠금상태입니다.");
            return true;
        }
        return false;
	}

	@Override
	public void setSession(LoginResponseDto loginResponseDto ,HttpServletRequest request, HttpServletResponse response) {
		log.info("로그인 성공 , 세션과 쿠키 설정");
		HttpSession session = request.getSession();
        session.setAttribute("loginUser", loginResponseDto);
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/");
        response.addCookie(cookie);
	}

	@Override
	public void logout(HttpServletRequest request , HttpServletResponse response) {
		request.getSession().invalidate();
		
		//Cookie cookie = new Cookie("JSESSIONID", null);
	    //cookie.setMaxAge(0);
		//response.addCookie(cookie);
	}

	@Override
	@Transactional
	public int createUserAccount(CreateUserAccountRequestDto createUserAccountRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException {
		log.info("UserServiceImpl_createUserAccount -> 새로운 사용자 회원가입");
		User newUserAccount = createUserAccountRequestDto.toUserEntity();
		
		if(isEmailDuplicate(newUserAccount.getEmail()))
			throw new ExistEmailException();
		
		if(isLoginIdDuplicate(newUserAccount.getLoginId()))
			throw new ExistLoginIdException();
		
		if(!CheckForm.checkEmail(newUserAccount.getEmail()))
			throw new InValidEmailException();
		
		if(!CheckForm.checkPassword(newUserAccount.getPassword()))
			throw new InValidPasswordException();

        log.info("계정 성공 생성시 이메일로 인증번호 발송");
        String authKey = mailService.sendSimpleMessageForAuth(newUserAccount.getEmail());
        newUserAccount.initialAuthKeyAndHashingPw(authKey , passwordHash.hashPassword(createUserAccountRequestDto.getPassword(), newUserAccount));
        return userRepository.createUserAccount(newUserAccount);
	}

	@Override
	public boolean isEmailDuplicate(String email) {
		log.info("계정생성시 이메일 중복 체크");
        if(userRepository.existsByEmail(email))
            return true;
        return false;
	}

	@Override
	public boolean isLoginIdDuplicate(String loginId) {
		log.info("계정생성시 로그인 아이디 중복 체크");
        if(userRepository.existsByLoginId(loginId))
            return true;
        return false;
	}

	@Override
	@Transactional
	public int authAccount(AuthAccountRequestDto authAccountRequestDto) {
		log.info("UserServiceImpl_authAccount -> 회원가입후 첫 로그인시 계정인증");
		User authUser = findUserByLoginIdOrEmail(authAccountRequestDto.getEmail(), false);
		if(authUser == null) throw new NotExistAccountException();
		
		if(authAccountRequestDto.getAuthKey().equals(authUser.getAuthKey()))
			return userRepository.updateAuthStatus(authAccountRequestDto.getEmail());
		return -1;
	}

	@Override
	public String findLoginIdByEmail(String email) {
		log.info("UserServiceImpl_findLoginIdByEmail");
		User findUser = findUserByLoginIdOrEmail(email, false);
		if(findUser == null) throw new NotExistAccountException();
		
		return findUser.getLoginId();
	}

	@Override
	public int findPasswordByLoginIdAndEmail(FindPasswordRequestDto findPasswordRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException {
		log.info("UserServiceImpl_findPasswordByLoginIdAndEmail");
		User user = findUserByLoginIdOrEmail(findPasswordRequestDto.getEmail(), false);
		System.out.println(user.getLoginId() + " " + user.getName());
		System.out.println(findPasswordRequestDto.getLoginId() + " " + user.getName().equals(findPasswordRequestDto.getName()));
		if(user == null || !user.getLoginId().equals(findPasswordRequestDto.getLoginId()) || !user.getName().equals(findPasswordRequestDto.getName()))
			throw new NotExistAccountException();
		
		String tempPw = mailService.createKey();
		mailService.sendSimpleMessageForTempPw(user.getEmail(), tempPw);
		user.updatePassword(passwordHash.hashPassword(tempPw, user));
		
		return userRepository.updatePassword(user);
	}

	@Override
	public User findUserByLoginIdOrEmail(String input, boolean isLoginId) {
		log.info("로그인ID 또는 이메일로 유저 계정 찾기");
		try {
			if(isLoginId)
				return userRepository.findUserByLoginId(input);
			else
				return userRepository.findUserByEmail(input);
			
		} catch (Exception e) {
			throw new NotExistAccountException();
		}
	}

	@Override
	@Transactional
	public int updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto) throws NoSuchAlgorithmException {
		log.info("UserServiceImpl_updatePassword");
		User loginUser = findUserByLoginIdOrEmail(updatePasswordRequestDto.getLoginid(), true);
		if(loginUser == null) throw new NotExistAccountException();
		if(!CheckForm.checkPassword(updatePasswordRequestDto.getNewPassword()))
			throw new InValidPasswordException();
		
		loginUser.updatePassword(passwordHash.hashPassword(updatePasswordRequestDto.getNewPassword(), loginUser));
		
		return userRepository.updatePassword(loginUser);
	}

	@Override
	@Transactional
	public int unlockAccount(UnlockAccountRequestDto unlockAccountRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException {
		log.info("UserServiceImpl_unlockAccount");
		User lockedUser = findUserByLoginIdOrEmail(unlockAccountRequestDto.getEmail(), false);
		if(lockedUser == null) throw new NotExistAccountException();
		
		if(!lockedUser.getLockKey().equals(unlockAccountRequestDto.getLockKey()))
			return -1;
		
		log.info("잠금해제 성공 , 이메일로 임시비밀번호 발송");
		String tempPw = mailService.createKey();
		mailService.sendSimpleMessageForTempPw(lockedUser.getEmail(), tempPw);
		lockedUser.updatePassword(passwordHash.hashPassword(tempPw, lockedUser));
		
		return userRepository.unlockAccount(lockedUser);
	}

	@Override
	public int updateProfileImage(UpdateProfileImageRequestDto updateProfileImageRequestDto) {
		log.info("UserServiceImpl_updateProfileImage");
		return userRepository.updateProfileImage(updateProfileImageRequestDto);
	}

	@Override
	public UserResponseDto getUserByUserId(int userId) {
		log.info("UserServiceImpl_getUserByUserId");
		return userRepository.getUserByUserId(userId);
	}
}
