package com.ssafy.enjoytrip.global.exception;

public class FailReadUserException extends RuntimeException{
    public FailReadUserException() {
        super(ExceptionCode.FAIL_READ_USER_EXCEPTION.getErrorMessage());
    }

    public FailReadUserException(String message) {
        super(message);
    }
}
