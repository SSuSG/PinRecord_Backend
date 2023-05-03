package com.ssafy.enjoytrip.domain.travel.service;

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
	public TravelResponseDto getTravel(int travelId) {
		log.info("TravelServiceImpl_getTravel");
		return travelRepository.getTravel(travelId);
	}


}
