package com.ssafy.enjoytrip.domain.follow.entity;

import com.ssafy.enjoytrip.domain.user.entity.User;

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
public class Follow {

	private int userIdFrom;
	private String nameFrom;
	private int userIdTo;
	private String nameTo;
}
