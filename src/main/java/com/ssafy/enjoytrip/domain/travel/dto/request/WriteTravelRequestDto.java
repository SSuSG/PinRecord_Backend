
package com.ssafy.enjoytrip.domain.travel.dto.request;


import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ssafy.enjoytrip.domain.travel.entity.Travel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(WriteTravelRequestDto) 여행후기 작성 DTO" , description = "여행후기 정보와 방문한 장소들에 대한 이미지와 정보데이터를 지님")
public class WriteTravelRequestDto {
	
	@ApiModelProperty(value = "작성자 userId")
    private int userId;
	
	@NotBlank
	@ApiModelProperty(value = "여행후기 제목")
    private String title;
	
	@NotBlank
	@ApiModelProperty(value = "여행후기에 대한 간략 글")
    private String content;
	
	@ApiModelProperty(value = "여행 비용")
    private int cost;
	
	@NotBlank
	@ApiModelProperty(value = "여행한 특별시/도")
    private String state;
	
	@NotBlank
	@ApiModelProperty(value = "여행한 시/군")
    private String city;
	
	@ApiModelProperty(value = "여행 시작 날짜")
    private LocalDateTime startDate;
	
	@ApiModelProperty(value = "여행 종료 날짜")
    private LocalDateTime endDate;
	
	@ApiModelProperty(value = "여행에서 방문한 장소들 정보")
    private List<WriteTravelPinRequestDto> pinList;
	
	public Travel toTravelEntity() {
		return Travel.builder()
				.userId(userId)
				.title(title)
				.content(content)
				.cost(cost)
				.state(state)
				.city(city)
				.startDate(startDate)
				.endDate(endDate)
				.createdDate(LocalDateTime.now())
				.build();
	}
	
}
