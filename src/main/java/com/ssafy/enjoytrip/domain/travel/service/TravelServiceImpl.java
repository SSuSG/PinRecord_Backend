package com.ssafy.enjoytrip.domain.travel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelImageRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelPinRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;
import com.ssafy.enjoytrip.domain.travel.entity.Image;
import com.ssafy.enjoytrip.domain.travel.entity.Mention;
import com.ssafy.enjoytrip.domain.travel.entity.Pin;
import com.ssafy.enjoytrip.domain.travel.entity.Tag;
import com.ssafy.enjoytrip.domain.travel.entity.Travel;
import com.ssafy.enjoytrip.domain.travel.repository.ImageRepository;
import com.ssafy.enjoytrip.domain.travel.repository.MentionRepository;
import com.ssafy.enjoytrip.domain.travel.repository.PinRepository;
import com.ssafy.enjoytrip.domain.travel.repository.TagRepository;
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
	private final TagRepository tagRepository;
	private final MentionRepository mentionRepository; 

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

			// TODO : 핀에 엮인 태그들 저장
			for (String tag : writeTravelPinRequestDto.getTagList()) 
				tagRepository.insertTag(Tag.builder().pinId(pinId).name(tag).build());
			
			for (WriteTravelImageRequestDto writeTravelImageRequestDto : writeTravelPinRequestDto.getImageList()) {
				Image image = writeTravelImageRequestDto.toImageEntity(pinId);
				log.info("인코딩 이미지 : {}",image.getEncodedBase64());
				imageRepository.insertImage(image);
			}
		}
		// TODO : 멘션리스트 저장하기!!
		for (int userId : writeTravelRequestDto.getMentionList())
			mentionRepository.insertMention(Mention.builder().userId(userId).travelId(travelId).createdDate(LocalDateTime.now()).build());
		
		// TODO : 멘션리스트 저장후 알림정보 생성해서 웹 소켓을통해 메시지를 전송한다. (SimpMessagingTemplate 사용) 이를 vue에서 받고 ui를 업데이트 시킨다!!
		
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
	public List<TravelResponseDto> searchTravelByLocation(String state, String city) {
		log.info("TravelServiceImpl_searchTravel");
		return travelRepository.searchTravelByLocation(state, city);
	}

	@Override
	public int deleteTravel(int travelId) {
		log.info("TravelServiceImpl_deleteTravel");
		// TODO : 로그인유저가 여행의 작성자인지 확인

		return travelRepository.deleteTravel(travelId);
	}

	@Override
	public List<TravelPinResponseDto> searchTravelByTag(List<String> tagList) {
		log.info("TravelServiceImpl_searchTravelByTag");
		return pinRepository.searchTravelByTag(tagList);
	}


}
