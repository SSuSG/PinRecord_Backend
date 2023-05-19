package com.ssafy.enjoytrip.global.exception;

import lombok.Getter;


/**
 *  ErrorCode는 임의로 지정하였음
 */
@Getter
public enum ExceptionCode {

    PARSE_EXCEPTION(400,"날짜형식이 올바르지 않습니다."),
    INVALID_REQUEST_DATA_EXCEPTION(403,"요청 데이터가 비어있거나 올바르지 않습니다."),
    INVALID_PASSWORD_EXCEPTION(405,"잘못된 비밀번호 형식입니다."),
    INVALID_EMAIL_EXCEPTION(406,"잘못된 이메일 형식입니다."),
    NOT_EXIST_ACCOUNT_EXCEPTION(407,"일치하는 계정이 존재하지 않습니다."),
    NOT_EXIST_LOGINID_EXCEPTION(408,"존재하지 않는 아이디입니다."),
    EXIST_LOGINID_EXCEPTION(409,"이미 존재하는 아이디 입니다."),
    EXIST_EMAIL_EXCEPTION(410,"이미 존재하는 이메일 입니다."),
    EXIST_FOLLOW_EXCEPTION(411,"이미 팔로우 관계 입니다."),
    NOT_EXIST_FOLLOW_EXCEPTION(412,"팔로우 관계가 존재하지 않습니다."),
    FAIL_LOGIN_EXCEPTION(413,"아이디 또는 비밀번호가 일치하지 않습니다."),
    FAIL_READ_USER_EXCEPTION(414,"조회할 수 있는 유저가 존재하지 않습니다."),
    FAIL_SEND_EMAIL_EXCEPTION(415,"이메일 전송에 에러가 발생했습니다."),
    FAIL_PASSWORD_HASHING_EXCEPTION(416,"비밀번호 암호화 도중 문제가 발생했습니다."),
    NO_AUTH_EXCEPTION(418,"인증이 이루어지지 않았습니다. 이메일을 확인해주세요."),
    NO_LOGIN_EXCEPTION(419,"로그인상태가 아닙니다. 로그인 해주세요."),
    N0_CONNECTION_EXCEPTION(420,"연결시간이 초과되었습니다."),
    LOCK_ACCOUNT_EXCEPTION(423,"계정이 비밀번호 오입력 5회로 잠금되어있습니다."),
    EXPIRED_REFRESH_TOKEN_EXCEPTION(425,"RefreshToken이 만료되었습니다."),
    SERVER_EXCEPTION(500,"서버에서 예측하지 못한 에러가 발생했습니다.");

    private int errorCode;
    private String errorMessage;

    ExceptionCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
