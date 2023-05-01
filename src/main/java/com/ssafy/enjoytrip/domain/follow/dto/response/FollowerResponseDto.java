package com.ssafy.enjoytrip.domain.follow.dto.response;


import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(FollowerResponseDto) 팔로우 반환 DTO" , description = "특정유저의 팔로워들의 닉네임과 USERID(PK)를 반환")
public class FollowerResponseDto {
	@NotBlank
	@ApiModelProperty(value = "특정 유저를 팔로우한 유저ID(PK)")
    private String followerUserId;

    @NotBlank
    @ApiModelProperty(value = "특정 유저를 팔로우한 유저의 닉네임")
    private String nickname;
}
