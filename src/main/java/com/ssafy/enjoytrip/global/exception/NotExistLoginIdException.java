package com.ssafy.enjoytrip.global.exception;

public class NotExistLoginIdException extends RuntimeException{
    public NotExistLoginIdException() {
        super(ExceptionCode.NOT_EXIST_LOGINID_EXCEPTION.getErrorMessage());
    }

    public NotExistLoginIdException(String message) {
        super(message);
    }
}
