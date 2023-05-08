package com.ssafy.enjoytrip.domain.travel.entity;

import java.time.LocalDateTime;

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
public class Mention {
	private int mentionId;
	private int userId;
	private int travelId;
	private LocalDateTime createdDate;
}
