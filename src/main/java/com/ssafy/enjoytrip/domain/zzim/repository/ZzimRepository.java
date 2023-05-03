package com.ssafy.enjoytrip.domain.zzim.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.domain.zzim.entity.Zzim;

@Mapper
public interface ZzimRepository {
	boolean isExistsZzim(Zzim zzim);
	int doZzim(Zzim zzim);
	int cancelZzim(Zzim zzim);
	int getZzimCntByTravelId(int travelId);
}
