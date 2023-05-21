package com.ssafy.enjoytrip.domain.comment.service;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.domain.comment.dto.request.UpdateCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.request.WriteCommentRequestDto;
import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;
import com.ssafy.enjoytrip.domain.comment.entity.Comment;
import com.ssafy.enjoytrip.domain.comment.repository.CommentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	
	@Override
	public TravelCommentResponseDto writeComment(WriteCommentRequestDto writeCommentRequestDto) {
		log.info("CommentServiceImpl_writeComment");
		Comment comment = writeCommentRequestDto.toCommentEntity();
		commentRepository.writeComment(comment);
		return commentRepository.findCommentByCommentId(comment.getCommentId());
	}

	@Override
	public int deleteComment(int commentId) {
		log.info("CommentServiceImpl_deleteComment");
		
		// TODO : 시큐리티 사용하면 토큰에서 유저ID 검출해서 로그인 유저가 작성자가 맞는지 확인!
		return commentRepository.deleteComment(commentId);
	}

	@Override
	public int updateComment(UpdateCommentRequestDto updateCommentRequestDto) {
		log.info("CommentServiceImpl_updateComment");
		return commentRepository.updateComment(updateCommentRequestDto.toCommentEntity());
	}

}
