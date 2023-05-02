package com.ssafy.enjoytrip.domain.follow.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.follow.repository.FollowRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService{

	private final FollowRepository followRepository;

	@Override
	public FollowListResponseDto findUserFollowListByUserId(String userId) {
		log.info("FollowServiceImpl_findUserFollowListByUserId");
		
		List<FollowerResponseDto> followerList = followRepository.findFollowerByUserId(userId);
		List<FollowingResponseDto> followingList = followRepository.findFollowingByUserId(userId);
		
		return FollowListResponseDto.builder().followerList(followerList).followingList(followingList).build();
	}

	@Override
	@Transactional
	public int follow(FollowRequestDto followRequestDto) {
		log.info("FollowServiceImpl_follow");
		
		if(followRepository.isExistsFollow(followRequestDto))
			return followRepository.cancelFollow(followRequestDto);
		return followRepository.follow(followRequestDto);
	}
}
