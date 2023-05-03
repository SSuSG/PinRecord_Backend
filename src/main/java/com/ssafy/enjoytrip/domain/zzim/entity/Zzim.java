package com.ssafy.enjoytrip.domain.zzim.entity;

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
public class Zzim {
	private int zzimId;
	private int userId;
	private int travelId;
}
