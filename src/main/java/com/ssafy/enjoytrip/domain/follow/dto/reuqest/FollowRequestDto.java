package com.ssafy.enjoytrip.domain.follow.dto.reuqest;

import javax.validation.constraints.NotBlank;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(FollowRequestDto) 팔로우 요청 DTO" , description = "from유저가 to유저를 팔로우한다. ")
public class FollowRequestDto {

	@NotBlank
	@ApiModelProperty(value = "팔로우 건 사람")
    private String from;

    @NotBlank
    @ApiModelProperty(value = "팔로우 받는 사람")
    private String to;
}
