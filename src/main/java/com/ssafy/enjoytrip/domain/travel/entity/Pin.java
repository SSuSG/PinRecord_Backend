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
public class Pin {
	private int pinId;
	private int travelId;
	private String placeName;
	private String placeUrl;
	private String categoryName;
	private String addressName;
	private String roadAddressName;
	private String phone;
	private String categoryGroupCode;
	private String categoryGroupName;
	private String content;
	private float x;
	private float y;
}
