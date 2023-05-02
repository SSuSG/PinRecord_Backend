package com.ssafy.enjoytrip.domain.travel.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;
import com.ssafy.enjoytrip.domain.travel.entity.Travel;

@Mapper
public interface TravelRepository {
	int writeTravel(Travel travel);
}
