package com.ssafy.enjoytrip.domain.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelImageRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelPinRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;
import com.ssafy.enjoytrip.domain.travel.entity.Travel;
import com.ssafy.enjoytrip.domain.travel.repository.ImageRepository;
import com.ssafy.enjoytrip.domain.travel.repository.PinRepository;
import com.ssafy.enjoytrip.domain.travel.repository.TravelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService{

	private final TravelRepository travelRepository;
	private final PinRepository pinRepository;
	private final ImageRepository imageRepository;

	@Override
	@Transactional
	public void writeTravelReview(WriteTravelRequestDto writeTravelRequestDto) throws Exception {
		log.info("TravelServiceImpl_writeTravel");
		
		Travel writeTravel = writeTravelRequestDto.toTravelEntity();
		travelRepository.writeTravel(writeTravel);
		int travelId = writeTravel.getTravelId();
		
		for(WriteTravelPinRequestDto writeTravelPinRequestDto : writeTravelRequestDto.getPinList()) {
			Pin pin = writeTravelPinRequestDto.toPinEntity(travelId);
			pinRepository.insertPin(pin);
			int pinId = pin.getPinId();

			for (WriteTravelImageRequestDto writeTravelImageRequestDto : writeTravelPinRequestDto.getImageList()) {
				Image image = writeTravelImageRequestDto.toImageEntity(pinId);
				log.info("인코딩 이미지 : {}",image.getEncodedBase64());
				imageRepository.insertImage(image);
			}
		}
	}

	@Override
	public TravelResponseDto getTravelByTravelId(int travelId) {
		log.info("TravelServiceImpl_getTravelListByTravelId");
		return travelRepository.getTravelByTravelId(travelId);
	}

	@Override
	public List<TravelResponseDto> getTravelListByUserId(int userId) {
		log.info("TravelServiceImpl_getTravelListByUserId");
		return travelRepository.getTravelListByUserId(userId);
	}

	@Override
	public List<TravelResponseDto> getZzimTravelListByUserId(int userId) {
		log.info("TravelServiceImpl_getZzimTravelListByUserId");
		return travelRepository.getZzimTravelListByUserId(userId);
	}

	@Override
	public List<TravelResponseDto> getTravelListForHomeView() {
		log.info("TravelServiceImpl_getTravelListForHomeView");
		return travelRepository.getTravelListForHomeView();
	}

	@Override
	public List<TravelResponseDto> searchTravel(String state, String city) {
		log.info("TravelServiceImpl_searchTravel");
		return travelRepository.searchTravel(state, city);
	}

	@Override
	public int deleteTravel(int travelId) {
		log.info("TravelServiceImpl_deleteTravel");
		// TODO : 로그인유저가 여행의 작성자인지 확인
		return travelRepository.deleteTravel(travelId);
	}


}
