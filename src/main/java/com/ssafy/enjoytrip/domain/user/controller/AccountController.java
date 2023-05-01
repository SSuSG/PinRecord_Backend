package com.ssafy.enjoytrip.domain.user.controller;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.user.dto.request.AuthAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.CreateUserAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.FindPasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.LoginRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.UnlockAccountRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.request.UpdatePasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.dto.response.LoginResponseDto;
import com.ssafy.enjoytrip.domain.user.service.AccountService;
import com.ssafy.enjoytrip.global.exception.FailLoginException;
import com.ssafy.enjoytrip.global.response.ResponseResult;
import com.ssafy.enjoytrip.global.response.SingleResponseResult;
import com.ssafy.enjoytrip.global.util.CheckForm;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class AccountController {
	
	private final AccountService accountService;
	
	@ApiOperation(value = "로그인 시도" , notes = "사용자가 로그인을 시도합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "로그인 성공"),
            @ApiResponse(code = 413, message = "일치하지않는 PW"),
            @ApiResponse(code = 418, message = "인증되지않은 계정. 인증해주세요!"),
            @ApiResponse(code = 423, message = "잠금된 계정"),
    })
    @PostMapping("/accounts/login")
    public ResponseResult login(@Valid @RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request ,HttpServletResponse response) throws FailLoginException, NoSuchAlgorithmException, MailException, IllegalArgumentException, MessagingException {
        log.info("AccountController_login -> 로그인 시도");
        LoginResponseDto loginResponseDto = accountService.login(loginRequestDto, request , response);
        return new SingleResponseResult<LoginResponseDto>(loginResponseDto);
    }
	
	@GetMapping("/accounts/logout")
	public ResponseResult logout(HttpServletRequest request) {
		log.info("AccountController_logout -> 로그아웃 시도");
		accountService.logout(request);
		return ResponseResult.successResponse;
	}
	
	@ApiOperation(value = "사용자 회원가입" , notes = "사용자가 회원가입을 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "회원가입 성공"),
            @ApiResponse(code = 405, message = "잘못된 비밀번호 형식"),
            @ApiResponse(code = 406, message = "잘못된 이메일 형식"),
            @ApiResponse(code = 409, message = "중복아이디 존재"),
            @ApiResponse(code = 410, message = "중복이메일 존재"),
            @ApiResponse(code = 415, message = "이메일 전송 실패"),
    })
    @PostMapping("/accounts")
    public ResponseResult createUserAccount(@Valid @RequestBody CreateUserAccountRequestDto createUserAccountRequestDto) throws MessagingException, MailException, IllegalArgumentException, NoSuchAlgorithmException {
        log.info("AccountController_createUserAccount -> 사용자의 회원가입");
        if(accountService.createUserAccount(createUserAccountRequestDto) == 1)
            return ResponseResult.successResponse;
        return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "이메일 인증" , notes = "사용자가 회원가입후 첫 로그인시 인증을 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "인증 성공"),
            @ApiResponse(code = 400, message = "인증 실패"),
    })
    @PostMapping("/accounts/auth")
    public ResponseResult authAccount(@RequestBody AuthAccountRequestDto authAccountRequestDto) {
        log.info("AccountController_authAccount -> 사용자의 계정 인증");
        if(accountService.authAccount(authAccountRequestDto) == 1)
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
        
    }
	
	@ApiOperation(value = "이메일 중복확인" , notes = "회원가입 도중 이메일이 중복되는지 확인")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "이메일이 중복되지 않음"),
            @ApiResponse(code = 400, message = "이메일이 중복"),
    })
	@ApiImplicitParam(name = "email" , value = "이메일", required = true , paramType = "path" ,dataType = "String")
    @GetMapping("/accounts/duplication-email/{email}")
    public ResponseResult isEmailDuplicate(@PathVariable String email) {
        log.info("AccountController_isEmailDuplicate -> 이메일이 중복 확인");
        if(!accountService.isEmailDuplicate(email))
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "로그인ID 중복확인" , notes = "회원가입 도중 로그인ID가 중복되는지 확인")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "로그인ID가 중복되지 않음"),
            @ApiResponse(code = 400, message = "로그인ID가 중복"),
    })
	@ApiImplicitParam(name = "loginId" , value = "로그인ID", required = true , paramType = "path" ,dataType = "String")
    @GetMapping("/accounts/duplication-loginId/{loginId}")
    public ResponseResult isLoginDuplicate(@PathVariable String loginId) {
        log.info("AccountController_isLoginDuplicate -> 로그인ID가 중복되는지 확인");
        if(!accountService.isLoginIdDuplicate(loginId))
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "아이디 찾기" , notes = "이메일을 이용한 아이디 찾기")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "아이디 찾기 성공"),
            @ApiResponse(code = 400, message = "입력받은 이메일로 등록된 계정이 존재하지 않음"),
    })
	@ApiImplicitParam(name = "email" , value = "이메일", required = true , paramType = "path" ,dataType = "String")
    @GetMapping("/accounts/loginId/{email}")
    public ResponseResult findLoginIdByEmail(@PathVariable String email) {
        log.info("AccountController_findLoginIdByEmail -> 로그인ID 찾기");
    	return new SingleResponseResult<String>(accountService.findLoginIdByEmail(email));
    }
	
	@ApiOperation(value = "비밀번호 찾기" , notes = "로그인ID와 이메일을 이용해서 임시 비밀번호 발급")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "비밀번호 찾기 성공(임시 비밀번호 발송 성공)"),
            @ApiResponse(code = 400, message = "로그인ID와 이메일이 일치하는 계정이 존재하지 않음"),
            @ApiResponse(code = 415, message = "이메일 전송 실패"),
    })
    @PostMapping("/accounts/new-password")
    public ResponseResult findPasswordByLoginIdAndEmail(@RequestBody FindPasswordRequestDto findPasswordRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException {
        log.info("AccountController_findPasswordByLoginIdAndEmail -> 비밀번호 찾기");
        if(accountService.findPasswordByLoginIdAndEmail(findPasswordRequestDto) == 1)
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "비밀번호 변경" , notes = "로그인ID와  임시 비밀번호 발급")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "비밀번호 찾기 성공(임시 비밀번호 발송 성공)"),
            @ApiResponse(code = 400, message = "로그인ID와 이메일이 일치하는 계정이 존재하지 않음"),
            @ApiResponse(code = 415, message = "이메일 전송 실패"),
    })
    @PostMapping("/accounts/password")
    public ResponseResult updatePassword(@RequestBody UpdatePasswordRequestDto updatePasswordRequestDto) throws NoSuchAlgorithmException {
        log.info("AccountController_updatePassword -> 비밀번호 변경");
        if(accountService.updatePassword(updatePasswordRequestDto) == 1)
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "계정잠금해제 인증번호 인증" , notes = "사용자의 계정잠금 해제를 위한 인증번호 인증")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "인증 성공"),
            @ApiResponse(code = 400, message = "인증 실패"),
    })
    @PostMapping("/accounts/unlock")
    public ResponseResult unlockAccount(@RequestBody UnlockAccountRequestDto unlockAccountRequestDto) throws MailException, IllegalArgumentException, MessagingException, NoSuchAlgorithmException {
        log.info("AccountController_unLockAccount -> 사용자의 계정 잠금해제");
        if(accountService.unlockAccount(unlockAccountRequestDto) == 1)
        	return ResponseResult.successResponse;
    	return ResponseResult.failResponse;
        
    }
}
