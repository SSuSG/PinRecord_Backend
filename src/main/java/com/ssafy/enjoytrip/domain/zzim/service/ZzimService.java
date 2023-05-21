package com.ssafy.enjoytrip.domain.zzim.service;

import com.ssafy.enjoytrip.domain.zzim.dto.request.ZzimRequestDto;

public interface ZzimService {
	int doZzim(ZzimRequestDto zzimRequestDto);
	boolean isZzim(ZzimRequestDto zzimRequestDto);
}
