package com.ssafy.enjoytrip.domain.travel.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.entity.Image;

@Mapper
public interface ImageRepository {
	int insertImage(Image image);
}
