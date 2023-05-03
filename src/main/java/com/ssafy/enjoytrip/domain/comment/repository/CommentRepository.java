package com.ssafy.enjoytrip.domain.comment.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;
import com.ssafy.enjoytrip.domain.comment.entity.Comment;

@Mapper
public interface CommentRepository {
	int writeComment(Comment comment);
	int deleteComment(int commentId , int userId);
	TravelCommentResponseDto findCommentByTravelId(int travelId);
}
