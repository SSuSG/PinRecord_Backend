package com.ssafy.enjoytrip.domain.follow.dto.response;


import java.util.List;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(FollowListResponseDto) 팔로우 리스트 반환 DTO" , description = "특정 유저의 팔로워,팔로잉 리스트를 반환해준다. ")
public class FollowListResponseDto {
	
	@NotBlank
	@ApiModelProperty(value = "특정 유저의 팔로잉 리스트")
    private List<FollowingResponseDto> followingList;

    @NotBlank
    @ApiModelProperty(value = "특정 유저의 팔로워 리스트")
    private List<FollowerResponseDto> followerList;
}
