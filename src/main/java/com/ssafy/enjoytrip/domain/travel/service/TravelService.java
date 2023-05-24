package com.ssafy.enjoytrip.domain.travel.service;


import java.io.IOException;
import java.util.List;

import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.MentionResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;

public interface TravelService {
	void writeTravelReview(WriteTravelRequestDto writeTravelRequestDto) throws Exception;
	TravelResponseDto getTravelByTravelId(int travelId) throws IOException;
	List<TravelResponseDto> getTravelListByUserId(int userId) throws IOException;
	List<TravelResponseDto> getZzimTravelListByUserId(int userId) throws IOException;
	List<TravelResponseDto> searchTravelByLocation(String state, String city) throws IOException;
	List<TravelResponseDto> searchTravelByTag(List<String> tagList) throws IOException;
	int deleteTravel(int travelId);
	List<MentionResponseDto> getMentionListByUserId(int userId);
//	List<TravelResponseDto> getTravelListForHomeView() throws IOException;
//	List<TravelResponseDto> getTravelListForHomeViewOrderByZzim() throws IOException;
//	List<TravelResponseDto> getTravelListForHomeViewOrderByCommentCnt() throws IOException;
	List<TravelResponseDto> getTravelListForHomeView(int pageNum) throws IOException;
	List<TravelResponseDto> getTravelListForHomeViewOrderByZzim(int pageNum) throws IOException;
	List<TravelResponseDto> getTravelListForHomeViewOrderByCommentCnt(int pageNum) throws IOException;
}
