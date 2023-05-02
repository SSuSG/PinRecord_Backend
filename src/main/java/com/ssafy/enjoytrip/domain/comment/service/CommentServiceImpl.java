package com.ssafy.enjoytrip.domain.comment.service;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	
	@Override
	public int writeComment(WriteCommentRequestDto writeCommentRequestDto) {
		log.info("CommentServiceImpl_writeComment");
		return commentRepository.writeComment(writeCommentRequestDto.toCommentEntity());
	}

}
