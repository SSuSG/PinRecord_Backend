package com.ssafy.enjoytrip.domain.follow.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;

@Mapper
public interface FollowRepository {
	List<FollowingResponseDto> findFollowingByUserId(int userId);
	List<FollowerResponseDto> findFollowerByUserId(int userId);
	boolean isExistsFollow(FollowRequestDto followRequestDto);
	int follow(FollowRequestDto followRequestDto);
	int cancelFollow(FollowRequestDto followRequestDto);
}
