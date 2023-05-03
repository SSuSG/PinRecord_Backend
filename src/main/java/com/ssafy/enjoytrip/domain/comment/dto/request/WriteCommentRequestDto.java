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
@ApiModel(value = "(CommentRequestDto) 댓글 작성 DTO" , description = "여행후기에 대한 댓글 작성")
public class WriteCommentRequestDto {

	@NotNull
	@ApiModelProperty(value = "작성자 Id")
    private Integer userId;
	
	@NotNull
	@ApiModelProperty(value = "작성자 여행Id")
    private Integer travelId;
	
	@NotBlank
	@ApiModelProperty(value = "댓글 내용")
    private String content;

	public Comment toCommentEntity() {
		return Comment.builder()
				.userId(userId)
				.travelId(travelId)
				.content(content)
				.createdDate(LocalDateTime.now())
				.build();
	}
}
