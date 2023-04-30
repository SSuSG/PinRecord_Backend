package com.ssafy.enjoytrip.global.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.ManifestReading.SealBaseLocator.NonSealing;

import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ssafy.enjoytrip.global.response.ResponseResult;

import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice(basePackages = "com.ssafy.enjoytrip")
public class ExceptionController {

    @ExceptionHandler(ExistEmailException.class)
    public ResponseResult ExistEmailException(ExistEmailException e) {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.EXIST_EMAIL_EXCEPTION);
    }

    @ExceptionHandler(ExistLoginIdException.class)
    public ResponseResult ExistPhoneNumberException(ExistLoginIdException e) {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.EXIST_LOGINID_EXCEPTION);
    }

    @ExceptionHandler(FailLoginException.class)
    public ResponseResult SignInFailedException(FailLoginException e) {

        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.FAIL_LOGIN_EXCEPTION);
    }

    @ExceptionHandler(NotExistLoginIdException.class)
    public ResponseResult NotExistLoginIdException(NotExistLoginIdException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.NOT_EXIST_LOGINID_EXCEPTION);
    }
    
    @ExceptionHandler(NotExistAccountException.class)
    public ResponseResult NotExistAccountException(NotExistAccountException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.NOT_EXIST_ACCOUNT_EXCEPTION);
    }
    @ExceptionHandler(NoAuthException.class)
    public ResponseResult NoAuthException(NoAuthException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.NO_AUTH_EXCEPTION);
    }
    
    @ExceptionHandler(NoLoginException.class)
    public ResponseResult NoLoginException(NoLoginException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.NO_LOGIN_EXCEPTION);
    }

    @ExceptionHandler({MailException.class , MessagingException.class ,IllegalArgumentException.class })
    public ResponseResult MailException(Exception e) {

        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.FAIL_SEND_EMAIL_EXCEPTION);
    }
    
    @ExceptionHandler({NoSuchAlgorithmException.class })
    public ResponseResult NoSuchAlgorithmException(NoSuchAlgorithmException e) {

        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.FAIL_PASSWORD_HASHING_EXCEPTION);
    }

    @ExceptionHandler({InValidEmailException.class})
    public ResponseResult InvalidException(InValidEmailException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.INVALID_EMAIL_EXCEPTION);
    }
    
    @ExceptionHandler({InValidPasswordException.class})
    public ResponseResult InValidPasswordlException(InValidPasswordException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.INVALID_PASSWORD_EXCEPTION);
    }
    
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseResult MethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.INVALID_REQUEST_DATA_EXCEPTION);
    }
    
    @ExceptionHandler({LockAccountException.class})
    public ResponseResult LockAccountException(LockAccountException e)
    {
        log.info("Error : {}",e.getClass());
        log.info("Error Message : {}",e.getMessage());
        return ResponseResult.exceptionResponse(ExceptionCode.LOCK_ACCOUNT_EXCEPTION);
    }

}
