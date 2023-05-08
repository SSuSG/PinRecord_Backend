package com.ssafy.enjoytrip.domain.travel.service;


import java.util.List;

import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;

public interface TravelService {
	void writeTravelReview(WriteTravelRequestDto writeTravelRequestDto) throws Exception;
	TravelResponseDto getTravelByTravelId(int travelId);
	List<TravelResponseDto> getTravelListByUserId(int userId);
	List<TravelResponseDto> getZzimTravelListByUserId(int userId);
	List<TravelResponseDto> getTravelListForHomeView();
	List<TravelResponseDto> searchTravelByLocation(String state, String city);
	List<TravelPinResponseDto> searchTravelByTag(List<String> tagList);
	int deleteTravel(int travelId);
}
