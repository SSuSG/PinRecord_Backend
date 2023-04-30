package com.ssafy.enjoytrip.global.exception;

public class InValidPasswordException extends RuntimeException{

    public InValidPasswordException() {
        super(ExceptionCode.INVALID_PASSWORD_EXCEPTION.getErrorMessage());
    }

    public InValidPasswordException(String message) {
        super(message);
    }
}
