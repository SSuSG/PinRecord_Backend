package com.ssafy.enjoytrip.domain.comment.service;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.ssafy.enjoytrip.domain.comment.dto.request.UpdateCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;

public interface CommentService {
	int writeComment(WriteCommentRequestDto writeCommentRequestDto);
	int deleteComment(int commentId);
	int updateComment(UpdateCommentRequestDto updateCommentRequestDto);
	List<TravelCommentResponseDto> getCommentListByTravelId(int travelId) throws IOException;
}
