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
public class Travel {
	private int travelId;
	private int userId;
	private String title;
	private int cost;
	private String content;
	private String state;
	private String city;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private LocalDateTime createdDate;
}
