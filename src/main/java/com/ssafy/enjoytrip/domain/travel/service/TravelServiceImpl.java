package com.ssafy.enjoytrip.domain.travel.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelImageRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelPinRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelImageResponseDto;
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
import com.ssafy.enjoytrip.global.util.ImageService;

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
	private final ImageService imageService;

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
				String path = imageService.storeFile(writeTravelImageRequestDto.getImage());
				Image image = writeTravelImageRequestDto.toImageEntity(pinId,path);
				imageRepository.insertImage(image);
			}
		}
		// TODO : 멘션리스트 저장하기!!
//		for (int userId : writeTravelRequestDto.getMentionList())
//			mentionRepository.insertMention(Mention.builder().userId(userId).travelId(travelId).createdDate(LocalDateTime.now()).build());
		
		// TODO : 멘션리스트 저장후 알림정보 생성해서 웹 소켓을통해 메시지를 전송한다. (SimpMessagingTemplate 사용) 이를 vue에서 받고 ui를 업데이트 시킨다!!
		
	}

	@Override
	public TravelResponseDto getTravelByTravelId(int travelId) throws IOException {
		log.info("TravelServiceImpl_getTravelListByTravelId");
		TravelResponseDto travel = travelRepository.getTravelByTravelId(travelId);
		travel.imageListToBase64();
		return travel;
	}

	@Override
	public List<TravelResponseDto> getTravelListByUserId(int userId) throws IOException{
		log.info("TravelServiceImpl_getTravelListByUserId");
		List<TravelResponseDto> travelList = travelRepository.getTravelListByUserId(userId);
		for (TravelResponseDto travel : travelList) {
			travel.imageListToBase64();
			travel.hash();
		}
		
		return travelList;
	}

	@Override
	public List<TravelResponseDto> getZzimTravelListByUserId(int userId) throws IOException{
		log.info("TravelServiceImpl_getZzimTravelListByUserId");
		List<TravelResponseDto> travelList = travelRepository.getZzimTravelListByUserId(userId);
		for (TravelResponseDto travel : travelList) {
			travel.imageListToBase64();
			travel.hash();
		}
		return travelList;
		
	}

	@Override
	public List<TravelResponseDto> getTravelListForHomeView() throws IOException{
		log.info("TravelServiceImpl_getTravelListForHomeView");
		List<TravelResponseDto> travelList = travelRepository.getTravelListForHomeView();
		for (TravelResponseDto travel : travelList) {
			travel.imageListToBase64();
			travel.hash();
		}
		return travelList;
	}

	@Override
	public List<TravelResponseDto> searchTravelByLocation(String state, String city) throws IOException {
		log.info("TravelServiceImpl_searchTravel");
		List<TravelResponseDto> travelList = travelRepository.searchTravelByLocation(state, city);
		for (TravelResponseDto travel : travelList) {
			travel.imageListToBase64();
			travel.hash();
		}
		return travelList;
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
