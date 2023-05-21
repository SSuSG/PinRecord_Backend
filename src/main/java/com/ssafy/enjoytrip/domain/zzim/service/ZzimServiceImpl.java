package com.ssafy.enjoytrip.domain.zzim.service;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.domain.zzim.dto.request.ZzimRequestDto;
import com.ssafy.enjoytrip.domain.zzim.entity.Zzim;
import com.ssafy.enjoytrip.domain.zzim.repository.ZzimRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ZzimServiceImpl implements ZzimService{
	
	private final ZzimRepository zzimRepository;

	@Override
	public int doZzim(ZzimRequestDto zzimRequestDto) {
		log.info("ZzimServiceImpl_ZzimRequestDto");
		// TODO : USERID 가 로그인 유저와 같은지 확인
		
		Zzim zzim = zzimRequestDto.toZzimEntity();
		if(zzimRepository.isExistsZzim(zzim))
			return zzimRepository.cancelZzim(zzim);
		return zzimRepository.doZzim(zzim);
	}

	@Override
	public boolean isZzim(ZzimRequestDto zzimRequestDto) {
		log.info("ZzimServiceImpl_isZzim");
		return zzimRepository.isExistsZzim(zzimRequestDto.toZzimEntity());
	}
}
