package com.ssafy.enjoytrip.domain.follow.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.follow.dto.response.FollowListResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowerResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.response.FollowingResponseDto;
import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.follow.service.FollowService;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;
import com.ssafy.enjoytrip.domain.user.controller.UserController;
import com.ssafy.enjoytrip.domain.user.dto.request.UpdatePasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.service.UserService;
import com.ssafy.enjoytrip.global.response.ListResponseResult;
import com.ssafy.enjoytrip.global.response.ResponseResult;
import com.ssafy.enjoytrip.global.response.SingleResponseResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class FollowController {
	
	private final FollowService followService;

	@ApiOperation(value = "팔로잉 조회" , notes = "특정 유저의 팔로잉 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "조회 실패"),
    })
	@ApiImplicitParam(name = "userId" , value = "유저ID", required = true , paramType = "path" ,dataTypeClass = Integer.class)
    @GetMapping("/follows/following/{userId}")
    public ResponseResult findFollowingByUserId(@PathVariable int userId) throws IOException {
        log.info("FollowController_findFollowingByUserId -> 특정 유저의 팔로잉 조회");
        return new ListResponseResult<FollowingResponseDto>(followService.findFollowingByUserId(userId));
    }
	
	@ApiOperation(value = "팔로워 조회" , notes = "특정 유저의 팔로워 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "조회 실패"),
    })
	@ApiImplicitParam(name = "userId" , value = "유저ID", required = true , paramType = "path" ,dataTypeClass = Integer.class)
    @GetMapping("/follows/follower/{userId}")
    public ResponseResult findFollowerByUserId(@PathVariable int userId) throws IOException {
        log.info("FollowController_findFollowerByUserId -> 특정 유저의 팔로워 조회");
        return new ListResponseResult<FollowerResponseDto>(followService.findFollowerByUserId(userId));
    }
	
	@ApiOperation(value = "팔로우 하기" , notes = "followee_id유저가 follower_id 유저를 팔로우한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "팔로우 성공"),
            @ApiResponse(code = 411, message = "팔로우 관계가 이미 존재"),
            @ApiResponse(code = 400, message = "팔로우 실패"),
    })
    @PostMapping("/follows")
    public ResponseResult follow(@RequestBody FollowRequestDto followRequestDto) {
        log.info("AccountController_follow -> 팔로우 하기");
        followService.follow(followRequestDto);
    	return ResponseResult.successResponse;
    }
	
	@ApiOperation(value = "팔로우 취소" , notes = "followee_id유저가 follower_id 유저를 팔로우 취소 한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "팔로우 취소 성공"),
            @ApiResponse(code = 412, message = "팔로우 관계가 존재하지 않음"),
            @ApiResponse(code = 400, message = "팔로우 취소 실패"),
    })
    @PostMapping("/follows/delete")
    public ResponseResult cancelFollow(@RequestBody FollowRequestDto followRequestDto) {
        log.info("AccountController_cancelFollow -> 팔로우 취소 하기");
        followService.cancelFollow(followRequestDto);
    	return ResponseResult.successResponse;
    }
	
}
