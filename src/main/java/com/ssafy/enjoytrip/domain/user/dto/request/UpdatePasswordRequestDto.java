package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "(UpdatePasswordRequestDto) 비밀번호 변경 요청 DTO" , description = "로그인ID와 변경하고싶은 비밀번호를 지님")
public class UpdatePasswordRequestDto {

	@NotBlank
	@ApiModelProperty(value = "사용자 로그인 ID")
    private String loginId;

    @NotBlank
    @ApiModelProperty(value = "사용자의 새로운 비밀번호")
    private String newPassword;
}
