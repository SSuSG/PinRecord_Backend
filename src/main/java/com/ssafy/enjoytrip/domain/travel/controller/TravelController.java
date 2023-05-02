package com.ssafy.enjoytrip.domain.travel.controller;


import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ssafy.enjoytrip.domain.travel.dto.request.WriteTravelRequestDto;
import com.ssafy.enjoytrip.domain.travel.service.TravelService;
import com.ssafy.enjoytrip.global.response.ResponseResult;
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
    @PostMapping("/travel")
    public ResponseResult writeTravel(@Valid @RequestBody WriteTravelRequestDto writeTravelRequestDto) throws Exception {
        log.info("TravelController_writeTravel -> 사용자가 여행후기를 작성");
        travelService.writeTravelReview(writeTravelRequestDto);
        return ResponseResult.successResponse;
    }
	
}
