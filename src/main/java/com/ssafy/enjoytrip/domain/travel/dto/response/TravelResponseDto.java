package com.ssafy.enjoytrip.domain.travel.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;
import com.ssafy.enjoytrip.domain.user.dto.response.LoginResponseDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "(TravelDetailResponseDto) 여행후기 정보 DTO" , description = "여행후기에 관한 정보,PIN,이미지,댓글 정보등이 담김")
public class TravelResponseDto {
	
	@ApiModelProperty(value = "여행후기 ID")
	private int travelId;
	
	@ApiModelProperty(value = "작성자 userId")
	private int userId;
	
	@ApiModelProperty(value = "여행후기 찜 갯수")
	private int zzimCnt;
	
	@ApiModelProperty(value = "작성자 닉네임")
	private String writer;
	
	@ApiModelProperty(value = "여행후기 타이틀")
	private String title;
	
	@ApiModelProperty(value = "여행후기 글 내용")
	private String content;
	
	@ApiModelProperty(value = "여행 경비")
	private int cost;
	
	@ApiModelProperty(value = "여행 장소(특별시/도)")
	private String state;
	
	@ApiModelProperty(value = "여행 장소(시/군)")
	private String city;
	
	@ApiModelProperty(value = "여행 시작 날짜")
	private LocalDateTime startDate;
	
	@ApiModelProperty(value = "여행 종료 날짜")
	private LocalDateTime endDate;
	
	@ApiModelProperty(value = "여행의 핀 정보")
	private List<TravelPinResponseDto> pinList;
	
	@ApiModelProperty(value = "여행후기의 댓글 정보")
	private List<TravelCommentResponseDto> commentList;
}
