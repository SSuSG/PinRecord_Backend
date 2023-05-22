package com.ssafy.enjoytrip.domain.travel.dto.response;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "(MentionResponseDto) 여행의 Mention Dto" , description = "Mention의 정보를 지님")
public class MentionResponseDto {
	
	@ApiModelProperty(value = "멘션 ID")
	private int mentionId;
	
	@ApiModelProperty(value = "여행후기 ID")
	private int travelId;
	
	@ApiModelProperty(value = "멘션된 유저 ID")
    private int userId;
	
	@ApiModelProperty(value = "여행 제목")
    private String title;
	
	@ApiModelProperty(value = "멘션한 사람 닉네임")
    private String nickname;
	
	@ApiModelProperty(value = "멘션된 시간")
	private LocalDateTime createdDate;
	
	
	
}
