package com.ssafy.enjoytrip.domain.follow.dto.response;


import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(FolloweeResponseDto) 팔로우 반환 DTO" , description = "특정유저가 팔로잉한 사람들의 이름과 USERID(PK)를 반환")
public class FollowToResponseDto {
	@NotBlank
	@ApiModelProperty(value = "특정 유저가 팔로우한 유저ID(PK)")
    private String to_user_id;

    @NotBlank
    @ApiModelProperty(value = "특정 유저가 팔로우한 유저의 이름")
    private String name;
}
