package com.ssafy.enjoytrip.domain.travel.service;

import java.io.FileNotFoundException;

import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelPinRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;

public interface TravelService {
	void writeTravelReview(WriteTravelRequestDto writeTravelRequestDto) throws Exception;
}
