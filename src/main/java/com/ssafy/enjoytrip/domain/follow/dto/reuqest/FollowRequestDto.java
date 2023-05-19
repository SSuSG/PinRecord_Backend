package com.ssafy.enjoytrip.domain.follow.dto.reuqest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	@NotNull(message = "userIdFrom 은 필수값 입니다.")
	@ApiModelProperty(value = "팔로우 건 사람")
    private int userIdFrom;

    @NotBlank
    @ApiModelProperty(value = "팔로우 받는 사람")
    private int userIdTo;
}
