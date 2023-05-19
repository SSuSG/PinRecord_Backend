package com.ssafy.enjoytrip.domain.follow.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.follow.entity.Follower;
import com.ssafy.enjoytrip.domain.follow.entity.Following;

@Mapper
public interface FollowRepository {
	List<Following> findFollowingByUserId(int userId);
	List<Follower> findFollowerByUserId(int userId);
	boolean isExistsFollow(FollowRequestDto followRequestDto);
	int follow(FollowRequestDto followRequestDto);
	int cancelFollow(FollowRequestDto followRequestDto);
}
