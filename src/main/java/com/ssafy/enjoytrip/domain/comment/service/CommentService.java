package com.ssafy.enjoytrip.domain.comment.service;

import javax.validation.Valid;

import com.ssafy.enjoytrip.domain.comment.dto.request.UpdateCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;

public interface CommentService {
	TravelCommentResponseDto writeComment(WriteCommentRequestDto writeCommentRequestDto);
	int deleteComment(int commentId);
	int updateComment(UpdateCommentRequestDto updateCommentRequestDto);
}
