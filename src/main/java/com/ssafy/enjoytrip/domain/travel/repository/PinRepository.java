package com.ssafy.enjoytrip.domain.travel.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;

@Mapper
public interface PinRepository {
	int insertPin(Pin pin);
}
