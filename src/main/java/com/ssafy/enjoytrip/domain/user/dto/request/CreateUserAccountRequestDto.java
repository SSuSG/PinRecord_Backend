package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.NotBlank;

import com.ssafy.enjoytrip.domain.user.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(CreateUserAccountRequestDto) 회원가입 요청 DTO" , description = "아이디 , 패스워드 , 이메일 , 이름 , 닉네임을 가졌음")
public class CreateUserAccountRequestDto {
	
	@NotBlank
	@ApiModelProperty(value = "사용자 로그인 ID")
    private String loginId;

    @NotBlank
    @ApiModelProperty(value = "사용자 비밀번호")
    private String password;
    
    @NotBlank
    @ApiModelProperty(value = "사용자 이메일")
    private String email;
    
    @NotBlank
    @ApiModelProperty(value = "사용자 실명")
    private String name;
    
    @NotBlank
    @ApiModelProperty(value = "사용자 닉네임")
    private String nickname;
    
    
    public User toUserEntity() {
    	return User.builder()
    			.loginId(loginId)
    			.password(password)
    			.email(email)
    			.name(name)
    			.nickname(nickname)
    			.isAuth(false)
    			.authKey("")
    			.isLock(false)
    			.lockKey("")
    			.mismatchCnt(0)
    			.build();
    }
}
