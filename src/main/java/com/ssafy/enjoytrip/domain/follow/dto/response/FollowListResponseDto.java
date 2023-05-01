package com.ssafy.enjoytrip.domain.follow.dto.response;


import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(FollowListResponseDto) 팔로우 리스트 반환 DTO" , description = "특정 유저의 팔로워,팔로잉 리스트를 반환해준다. ")
public class FollowListResponseDto {
	
}
