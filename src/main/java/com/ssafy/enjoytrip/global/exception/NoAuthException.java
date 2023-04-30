package com.ssafy.enjoytrip.global.exception;

public class NoAuthException extends RuntimeException{
    public NoAuthException() {
        super(ExceptionCode.NO_AUTH_EXCEPTION.getErrorMessage());
    }

    public NoAuthException(String message) {
        super(message);
    }
}
