package com.ssafy.enjoytrip.global.exception;
public class NotExistFollowException extends RuntimeException{
    public NotExistFollowException() {
        super(ExceptionCode.NOT_EXIST_FOLLOW_EXCEPTION.getErrorMessage());
    }

    public NotExistFollowException(String message) {
        super(message);
    }
}
