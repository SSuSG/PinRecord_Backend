package com.ssafy.enjoytrip.domain.travel.repository;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.dto.response.MentionResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;
import com.ssafy.enjoytrip.domain.travel.entity.Travel;

@Mapper
public interface TravelRepository {
	int writeTravel(Travel travel);
	TravelResponseDto getTravelByTravelId(int travelId);
	List<TravelResponseDto> getTravelListByUserId(int userId);
	List<TravelResponseDto> getZzimTravelListByUserId(int userId);
	List<TravelResponseDto> searchTravelByLocation(String state , String city);
	int deleteTravel(int travelId);
//	List<TravelResponseDto> getTravelListForHomeView();
//	List<TravelResponseDto> getTravelListForHomeViewOrderByZzim();
//	List<TravelResponseDto> getTravelListForHomeViewOrderByCommentCnt();
	List<TravelResponseDto> getTravelListForHomeView(int pageNum);
	List<TravelResponseDto> getTravelListForHomeViewOrderByZzim(int pageNum);
	List<TravelResponseDto> getTravelListForHomeViewOrderByCommentCnt(int pageNum);
}
