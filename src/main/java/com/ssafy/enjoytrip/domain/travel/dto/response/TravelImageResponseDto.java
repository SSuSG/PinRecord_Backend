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
@ApiModel(value = "(TravelImageResponseDto) 여행후기 핀 이미지 DTO" , description = "PIN의 이미지 정보를 지님")
public class TravelImageResponseDto {
		
	@ApiModelProperty(value = "핀ID")
	private int pinId;
	
	@ApiModelProperty(value = "이미지 ID")
	private int imageId;
	
	@ApiModelProperty(value = "사진을 base64로 인코딩한 문자열")
    private String encodedBase64;
}
