package com.ssafy.enjoytrip.domain.travel.controller;


import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;
import com.ssafy.enjoytrip.domain.travel.service.TravelService;
import com.ssafy.enjoytrip.global.response.ListResponseResult;
import com.ssafy.enjoytrip.global.response.ResponseResult;
import com.ssafy.enjoytrip.global.response.SingleResponseResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class TravelController {
	
	private final TravelService travelService; 
	
	@ApiOperation(value = "여행후기 작성" , notes = "사용자가 여행후기를 작성합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 작성 성공"),
            @ApiResponse(code = 400, message = "여행후기 작성 실패"),
    })
    @PostMapping("/travels")
    public ResponseResult writeTravel(@Valid @RequestBody WriteTravelRequestDto writeTravelRequestDto) throws Exception {
        log.info("TravelController_writeTravel -> 사용자가 여행후기를 작성");
        travelService.writeTravelReview(writeTravelRequestDto);
        return ResponseResult.successResponse;
    }
	
	@ApiOperation(value = "여행후기 상세조회" , notes = "여행후기를 상세조회 합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 조회 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 조회 실패"),
    })
	@ApiImplicitParam(name = "travelId" , value = "여행후기ID(PK)", required = true , paramType = "path" ,dataTypeClass = Integer.class)
	@GetMapping("/travels/{travelId}")
    public ResponseResult getTravelListByTravelId(@PathVariable int travelId) throws IOException  {
        log.info("TravelController_getTravel -> 여행후기 상세조회");
        return new SingleResponseResult<>(travelService.getTravelByTravelId(travelId));
    }
	
	@ApiOperation(value = "특정 유저가 작성한 여행후기 목록" , notes = "특정 유저가 작성한 여행후기 목록을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 조회 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 조회 실패"),
    })
	@ApiImplicitParam(name = "userId" , value = "유저ID(PK)", required = true , paramType = "path" ,dataTypeClass = Integer.class)
    @GetMapping("/travels/users/{userId}")
    public ResponseResult getTravelListByUserId(@PathVariable int userId) throws IOException  {
        log.info("TravelController_getTravelListByUserId -> 유저의 여행후기 목록 조회");
        return new ListResponseResult<>(travelService.getTravelListByUserId(userId));
    }
	
	@ApiOperation(value = "특정 유저가 찜한 여행후기 목록" , notes = "특정 유저가 찜한 여행후기 목록을 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 조회 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 조회 실패"),
    })
	@ApiImplicitParam(name = "userId" , value = "유저ID(PK)", required = true , paramType = "path" ,dataTypeClass = Integer.class)
	@GetMapping("/travels/{userId}/zzims")
    public ResponseResult getZzimTravelListByUserId(@PathVariable int userId) throws IOException  {
        log.info("TravelController_getZzimTravelListByUserId -> 유저의 여행후기 목록 조회");
        return new ListResponseResult<>(travelService.getZzimTravelListByUserId(userId));
    }
	
	@ApiOperation(value = "홈 화면에 보여줄 여행후기 리스트" , notes = "홈 화면에 보여줄 여행후기 목록 정보들")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 조회 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 조회 실패"),
    })
	@GetMapping("/travels")
    public ResponseResult getTravelListForHomeView() throws IOException  {
        log.info("TravelController_getTravelListForHomeView -> 홈 화면에서의 여행 목록 조회");
        return new ListResponseResult<>(travelService.getTravelListForHomeView());
    }
	
	@ApiOperation(value = "여행 후기 검색" , notes = "여행후기를 장소기반으로 검색")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 검색 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 검색 실패"),
    })
	@ApiImplicitParams({
		@ApiImplicitParam(name = "state" , value = "특별시/도", required = true , paramType = "query" ,dataTypeClass = String.class),
		@ApiImplicitParam(name = "city" , value = "시/군", required = false , paramType = "query" ,dataTypeClass = String.class)
	})
	@GetMapping("/travels/location")
    public ResponseResult searchTravelByLocation(@RequestParam String state , @RequestParam(required = false , defaultValue = "") String city) throws IOException  {
        log.info("TravelController_searchTravelByLocation -> 여행 후기 장소 기반 검색");
        return new ListResponseResult<>(travelService.searchTravelByLocation(state,city));
    }
	
	
	@ApiOperation(value = "여행 후기 태그 기반 검색" , notes = "여행후기를 태그 기반으로 검색")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 검색 성공" , response = TravelResponseDto.class),
            @ApiResponse(code = 400, message = "여행후기 검색 실패"),
    })
	@ApiImplicitParam(name = "tagList" , value = "태그", required = true , paramType = "query" ,dataType = "List<String>")
	@GetMapping("/travels/tags")
    public ResponseResult searchTravelByTag(@RequestParam List<String> tagList) throws IOException  {
        log.info("TravelController_searchTravelByTag -> 여행 후기 장소 기반 검색");
        return new ListResponseResult<>(travelService.searchTravelByTag(tagList));
    }
    
	
	@ApiOperation(value = "여행 후기 삭제" , notes = "여행 후기를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "여행후기 삭제 성공"),
            @ApiResponse(code = 400, message = "여행후기 삭제 실패"),
    })
	@ApiImplicitParam(name = "travelId" , value = "여행ID)", required = true , paramType = "path" ,dataTypeClass = Integer.class)
	@DeleteMapping("/travels/{travelId}")
    public ResponseResult deleteTravel(@PathVariable int travelId)  {
        log.info("TravelController_deleteTravel -> 여행 후기 삭제");
        if(travelService.deleteTravel(travelId) == 1)
        	return ResponseResult.successResponse;
        return ResponseResult.failResponse;
    }
	
}
