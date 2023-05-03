package com.ssafy.enjoytrip.domain.zzim.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ssafy.enjoytrip.domain.follow.dto.reuqest.FollowRequestDto;
import com.ssafy.enjoytrip.domain.zzim.entity.Zzim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(ZzimRequestDto) 찜 요청 DTO" , description = "사용자가 여행 후기에 대해 찜을(취소)할때 필요한 데이터")
public class ZzimRequestDto {
	
	@NotNull(message = "사용자ID는 필수값 입니다.")
	@ApiModelProperty(value = "찜을 한 사용자ID")
    private Integer userId;

	@NotNull(message = "여행ID는 필수값 입니다.")
    @ApiModelProperty(value = "사용자가 찜을 한 여행ID")
    private Integer travelId;
	
	public Zzim toZzimEntity() {
		return Zzim.builder()
				.userId(userId)
				.travelId(travelId)
				.build();
	}
}
