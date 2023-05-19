package com.ssafy.enjoytrip.domain.follow.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.follow.entity.Follower;
import com.ssafy.enjoytrip.domain.follow.entity.Following;
import com.ssafy.enjoytrip.domain.follow.repository.FollowRepository;
import com.ssafy.enjoytrip.global.exception.ExistFollowException;
import com.ssafy.enjoytrip.global.exception.NotExistFollowException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService{

	private final FollowRepository followRepository;


	@Override
	@Transactional
	public int follow(FollowRequestDto followRequestDto) {
		log.info("FollowServiceImpl_follow");
		
		if(followRepository.isExistsFollow(followRequestDto))
			throw new ExistFollowException();
		return followRepository.follow(followRequestDto);
	}
	
	@Override
	public int cancelFollow(FollowRequestDto followRequestDto) {
		
		if(!followRepository.isExistsFollow(followRequestDto))
			throw new NotExistFollowException();
		
		return followRepository.cancelFollow(followRequestDto);
	}
	

	@Override
	public List<FollowerResponseDto> findFollowerByUserId(int userId) throws IOException {
		log.info("FollowServiceImpl_findFollowerByUserId");
		List<FollowerResponseDto> followerResponseDtoList = new ArrayList<FollowerResponseDto>();
		List<Follower> followerList = followRepository.findFollowerByUserId(userId);
		
		for (Follower follower : followerList) {
			followerResponseDtoList.add(follower.toDto());
		}
		
		return followerResponseDtoList;
	}

	@Override
	public List<FollowingResponseDto> findFollowingByUserId(int userId) throws IOException {
		log.info("FollowServiceImpl_findFollowingByUserId");
		
		List<FollowingResponseDto> followingResponseDtoList = new ArrayList<FollowingResponseDto>();
		List<Following> followingList =  followRepository.findFollowingByUserId(userId);
		
		for (Following following : followingList) {
			followingResponseDtoList.add(following.toDto());
		}
		
		return followingResponseDtoList;
	}

}
