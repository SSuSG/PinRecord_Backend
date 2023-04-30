package com.ssafy.enjoytrip.global.exception;

public class FailLoginException extends RuntimeException{

    public FailLoginException() {
        super(ExceptionCode.FAIL_LOGIN_EXCEPTION.getErrorMessage());
    }

    public FailLoginException(String message) {
        super(message);
    }
}
