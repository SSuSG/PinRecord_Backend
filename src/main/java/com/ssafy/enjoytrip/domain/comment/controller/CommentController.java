package com.ssafy.enjoytrip.domain.comment.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.comment.dto.request.UpdateCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;
import com.ssafy.enjoytrip.domain.comment.service.CommentService;
import com.ssafy.enjoytrip.global.response.ResponseResult;
import com.ssafy.enjoytrip.global.response.SingleResponseResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class CommentController {
	
	private final CommentService commentService;
	
	@ApiOperation(value = "댓글 작성" , notes = "사용자가 여행후기에 대해 댓글을 작성합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "댓글 작성 성공"),
            @ApiResponse(code = 400, message = "댓글 작성 실패"),
    })
    @PostMapping("/comments")
    public ResponseResult writeComment(@Valid @RequestBody WriteCommentRequestDto writeCommentRequestDto) throws Exception {
        log.info("CommentController_writeComment -> 사용자가 댓글을 작성");
        return new SingleResponseResult<TravelCommentResponseDto>(commentService.writeComment(writeCommentRequestDto));
    }
	
	@ApiOperation(value = "댓글 수정" , notes = "사용자가 여행후기에 대해 댓글을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "댓글 수정 성공"),
            @ApiResponse(code = 400, message = "댓글 수정 실패"),
    })
    @PutMapping("/comments")
    public ResponseResult updateComment(@Valid @RequestBody UpdateCommentRequestDto updateCommentRequestDto) throws Exception {
        log.info("CommentController_updateComment -> 사용자가 댓글을 수정");
        if(commentService.updateComment(updateCommentRequestDto) == 1)
        	return ResponseResult.successResponse;
        return ResponseResult.failResponse;
    }
	
	@ApiOperation(value = "댓글 삭제" , notes = "사용자가 본인의 댓글을 삭제 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "댓글 삭제 성공"),
            @ApiResponse(code = 400, message = "댓글 삭제 실패"),
    })
    @DeleteMapping("/comments/{commentId}")
    public ResponseResult deleteComment(@PathVariable int commentId) throws Exception {
        log.info("CommentController_deleteComment -> 사용자가 댓글을 삭제");
        commentService.deleteComment(commentId);
    	return ResponseResult.successResponse;
    }
	
	
}
