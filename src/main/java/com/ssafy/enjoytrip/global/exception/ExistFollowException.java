package com.ssafy.enjoytrip.global.exception;
public class ExistFollowException extends RuntimeException{
    public ExistFollowException() {
        super(ExceptionCode.EXIST_FOLLOW_EXCEPTION.getErrorMessage());
    }

    public ExistFollowException(String message) {
        super(message);
    }
}
