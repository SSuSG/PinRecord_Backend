package com.ssafy.enjoytrip.domain.follow.dto.response;


import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "(FollowingResponseDto) 팔로잉 반환 DTO" , description = "특정유저가 팔로잉한 사람들의 닉네임과 USERID(PK)를 반환")
public class FollowingResponseDto {
	@NotBlank
	@ApiModelProperty(value = "특정 유저가 팔로우한 유저ID(PK)")
    private int followingUserId;

    @NotBlank
    @ApiModelProperty(value = "특정 유저가 팔로우한 유저의 닉네임")
    private String nickname;
    
    @NotBlank
    @ApiModelProperty(value = "특정 유저가 팔로우한 유저의 이름")
    private String name;
    
    @NotBlank
    @ApiModelProperty(value = "특정 유저의 이미지")
    private byte[] image;
}
