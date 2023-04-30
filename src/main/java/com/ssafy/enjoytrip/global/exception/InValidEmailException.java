package com.ssafy.enjoytrip.global.exception;

public class InValidEmailException extends RuntimeException{

    public InValidEmailException() {
        super(ExceptionCode.INVALID_EMAIL_EXCEPTION.getErrorMessage());
    }

    public InValidEmailException(String message) {
        super(message);
    }
}
