package com.ssafy.enjoytrip.domain.follow.service;

import java.io.IOException;
import java.util.List;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;

public interface FollowService {
	List<FollowerResponseDto> findFollowerByUserId(int userId) throws IOException;
	List<FollowingResponseDto> findFollowingByUserId(int userId) throws IOException;
	int follow(FollowRequestDto followRequestDto);
	int cancelFollow(FollowRequestDto followRequestDto);
}
