package com.ssafy.enjoytrip.global.exception;

public class NoLoginException extends RuntimeException{
    public NoLoginException() {
        super(ExceptionCode.NO_LOGIN_EXCEPTION.getErrorMessage());
    }

    public NoLoginException(String message) {
        super(message);
    }
}
