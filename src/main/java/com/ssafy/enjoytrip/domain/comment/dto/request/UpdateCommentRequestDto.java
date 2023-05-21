package com.ssafy.enjoytrip.domain.comment.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ssafy.enjoytrip.domain.comment.entity.Comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(UpdateCommentRequestDto) 댓글 수정 DTO" , description = "여행후기에 대한 댓글 수정")
public class UpdateCommentRequestDto {
	
	@NotNull
	@ApiModelProperty(value = "작성자 Id")
    private int commentId;
	
	@NotBlank
	@ApiModelProperty(value = "댓글 내용")
    private String content;
	
	public Comment toCommentEntity() {
		return Comment.builder()
				.commentId(commentId)
				.content(content)
				.build();
	}
}
