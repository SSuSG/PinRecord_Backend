package com.ssafy.enjoytrip.domain.travel.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;

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
@ApiModel(value = "(TravelPinResponseDto) 여행후기 핀 DTO" , description = "여행후기에 PIN,이미지 정보를 지님")
public class TravelPinResponseDto {
	
	@ApiModelProperty(value = "핀 ID")
	private int pinId;
	
	@ApiModelProperty(value = "여행 ID")
	private int travelId;
	
	@ApiModelProperty(value = "장소 이름")
	private String placeName;
	
	@ApiModelProperty(value = "장소 url")
	private String placeUrl;
	
	@ApiModelProperty(value = "장소 카테고리 이름")
	private String categoryName;
	
	@ApiModelProperty(value = "지번 주소")
	private String addressName;
	
	@ApiModelProperty(value = "도로명 주소")
	private String roadAddressName;
	
	@ApiModelProperty(value = "장소 연락처")
	private String phone;
	
	@ApiModelProperty(value = "장소 카테고립 그룹 코드")
	private String categoryGroupCode;
	
	@ApiModelProperty(value = "장소 카테고리 그룹 이름")
	private String categoryGroupName;
	
	@ApiModelProperty(value = "장소에 대한 코멘트")
	private String content;
	
	@ApiModelProperty(value = "장소의 x")
	private float x;
	
	@ApiModelProperty(value = "장소의 y")
	private float y; 
	
	@ApiModelProperty(value = "핀에 해당하는 이미지들")
	private List<TravelImageResponseDto> imageList;
	
	@ApiModelProperty(value = "장소에 대한 태그들")
    private List<String> tagList;
}
