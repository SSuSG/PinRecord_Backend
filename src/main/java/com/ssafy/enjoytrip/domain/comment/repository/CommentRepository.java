package com.ssafy.enjoytrip.domain.comment.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.comment.entity.Comment;

@Mapper
public interface CommentRepository {
	int writeComment(Comment comment);
}
