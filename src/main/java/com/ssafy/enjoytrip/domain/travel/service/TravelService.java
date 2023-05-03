package com.ssafy.enjoytrip.domain.travel.service;


import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;

public interface TravelService {
	void writeTravelReview(WriteTravelRequestDto writeTravelRequestDto) throws Exception;
	TravelResponseDto getTravel(int travelId);
	
}
