package com.ssafy.enjoytrip.domain.comment.service;

import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;

public interface CommentService {
	int writeComment(WriteCommentRequestDto writeCommentRequestDto);
	int deleteComment(int commentId);
}
