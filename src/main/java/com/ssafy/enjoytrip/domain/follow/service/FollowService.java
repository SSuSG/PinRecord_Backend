package com.ssafy.enjoytrip.domain.follow.service;

import java.util.List;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;

public interface FollowService {
	FollowListResponseDto findUserFollowListByUserId(int userId);
	List<FollowerResponseDto> findFollowerByUserId(int userId);
	List<FollowingResponseDto> findFollowingByUserId(int userId);
	int follow(FollowRequestDto followRequestDto);
}
