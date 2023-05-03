package com.ssafy.enjoytrip.domain.travel.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.dto.response.TravelImageResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Image;

@Mapper
public interface ImageRepository {
	int insertImage(Image image);
	TravelImageResponseDto findIamgeByPinId(int pinId);
}
