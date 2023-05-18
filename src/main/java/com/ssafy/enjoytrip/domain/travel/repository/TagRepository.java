package com.ssafy.enjoytrip.domain.travel.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.entity.Tag;

@Mapper
public interface TagRepository {
	int insertTag(Tag tag);
	List<String> findTagByPinId(int pinId);
	List<Integer> findPinByTag(List<String> tagList);
}
