package com.ssafy.enjoytrip.domain.travel.entity;

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
public class Tag {
	private int tagId;
	private int pinId;
	private String name;
}
