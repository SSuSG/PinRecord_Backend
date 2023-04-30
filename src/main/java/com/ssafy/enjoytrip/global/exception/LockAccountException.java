package com.ssafy.enjoytrip.global.exception;

public class LockAccountException extends RuntimeException{
    public LockAccountException() {
        super(ExceptionCode.LOCK_ACCOUNT_EXCEPTION.getErrorMessage());
    }

    public LockAccountException(String message) {
        super(message);
    }
}
