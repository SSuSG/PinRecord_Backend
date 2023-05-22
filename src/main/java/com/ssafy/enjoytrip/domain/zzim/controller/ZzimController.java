package com.ssafy.enjoytrip.domain.zzim.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.comment.controller.CommentController;
import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.service.CommentService;
import com.ssafy.enjoytrip.domain.zzim.dto.request.ZzimRequestDto;
import com.ssafy.enjoytrip.domain.zzim.service.ZzimService;
import com.ssafy.enjoytrip.global.response.ResponseResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class ZzimController {

	private final ZzimService zzimService;
	
	@ApiOperation(value = "찜 하기" , notes = "사용자가 여행후기에 대해 찜을 하거나 취소합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "찜(찜 취소) 성공"),
            @ApiResponse(code = 400, message = "찜(찜 취소) 실패"),
    })
    @PostMapping("/zzims")
    public ResponseResult doZzim(@Valid @RequestBody ZzimRequestDto zzimRequestDto) throws Exception {
        log.info("ZzimController_doZzim -> 사용자가 여행후기에 대해 찜을 하거나 취소합니다.");
        zzimService.doZzim(zzimRequestDto);
        return ResponseResult.successResponse;
    }
	
	@ApiOperation(value = "유저의 찜유무 확인" , notes = "사용자가 여행후기에 대해 찜을 한지 안한지 확인")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 400, message = "조회 실패"),
    })
    @PostMapping("/zzims")
    public ResponseResult IsZzim(@Valid @RequestBody ZzimRequestDto zzimRequestDto) throws Exception {
        log.info("ZzimController_IsZzim -> 사용자가 여행후기에 대해 찜을 한지 안한지 확인");
        zzimService.doZzim(zzimRequestDto);
        return ResponseResult.successResponse;
    }
}
