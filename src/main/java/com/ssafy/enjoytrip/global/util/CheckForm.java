package com.ssafy.enjoytrip.global.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CheckForm {
	
	public boolean checkEmail(String email){
        log.info("CheckForm_checkEmail -> 이메일 형식 검사");
        //이메일 정규식
        String regx = "^[A-Za-z0-9+_.-]+@(.+)$";
        //정규식 패턴
        Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(email).matches();
    }
	
	public boolean checkPassword(String password){
        log.info("CheckForm_checkPassword -> 비밀번호 형식 검사");
        //비밀번호 정규식
        String regx = "^(?=.*[!@#$%^&*()+-_])(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d!@#$%^&*()+-_]{8,}$";
        //정규식 패턴
        Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(password).matches();
    }
}
