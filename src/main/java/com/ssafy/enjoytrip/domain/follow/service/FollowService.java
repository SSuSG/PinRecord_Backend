package com.ssafy.enjoytrip.domain.follow.service;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;

public interface FollowService {
	FollowListResponseDto findUserFollowListByUserId(int userId);
	int follow(FollowRequestDto followRequestDto);
}
