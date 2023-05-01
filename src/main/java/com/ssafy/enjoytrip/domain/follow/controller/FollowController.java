package com.ssafy.enjoytrip.domain.follow.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.follow.service.FollowService;
import com.ssafy.enjoytrip.domain.user.controller.AccountController;
import com.ssafy.enjoytrip.domain.user.dto.request.UpdatePasswordRequestDto;
import com.ssafy.enjoytrip.domain.user.service.AccountService;
import com.ssafy.enjoytrip.global.response.ResponseResult;
import com.ssafy.enjoytrip.global.response.SingleResponseResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class FollowController {
	
	private final FollowService followService;

	@ApiOperation(value = "팔로워,팔로잉 리스트 조회" , notes = "특정 유저의 팔로워,팔로잉 리스트 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "조회 실패"),
    })
	@ApiImplicitParam(name = "userId" , value = "유저ID", required = true , paramType = "path" ,dataType = "string")
    @GetMapping("/follows/{userId}")
    public ResponseResult findFollowListByUserId(@PathVariable String userId) {
        log.info("FollowController_findFollowListByUserId -> 특정 유저의 팔로워,팔로잉 리스트 조회");
        
        return ResponseResult.successResponse;
    }
	
	@ApiOperation(value = "팔로우 하기" , notes = "followee_id유저가 follower_id 유저를 팔로우한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "팔로우 성공"),
            @ApiResponse(code = 400, message = "팔로우 실패"),
    })
    @PostMapping("/follows")
    public ResponseResult follow(@RequestBody FollowRequestDto followRequestDto) {
        log.info("AccountController_follow -> 팔로우 하기");
        
    	return ResponseResult.successResponse;
    }
	
}
