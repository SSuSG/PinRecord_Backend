package com.ssafy.enjoytrip.domain.comment.entity;

import java.time.LocalDateTime;

import com.ssafy.enjoytrip.domain.travel.entity.Image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
	private int commentId;
	private int userId;
	private int travelId;
	private String content;
	private LocalDateTime createdDate;
}
