package com.ssafy.enjoytrip.domain.travel.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.travel.dto.response.MentionResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Mention;

@Mapper
public interface MentionRepository {
	int insertMention(Mention mention);
	List<MentionResponseDto> findMentionByUserId(int userId);
}
