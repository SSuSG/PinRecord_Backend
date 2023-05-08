package com.ssafy.enjoytrip.domain.travel.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;

@Mapper
public interface PinRepository {
	int insertPin(Pin pin);
	TravelPinResponseDto findPinByTravelId(int travelId);
	List<TravelPinResponseDto> searchTravelByTag(List<String> tagList);
}
