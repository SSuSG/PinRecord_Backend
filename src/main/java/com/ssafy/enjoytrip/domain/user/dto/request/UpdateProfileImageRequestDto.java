package com.ssafy.enjoytrip.domain.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

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
@ApiModel(value = "(ChangeProfileImageRequestDto) 유저 프로필 이미지 변경 DTO" , description = "유저ID와 BASE64로 인코딩된 이미지 문자열을 지님")
public class UpdateProfileImageRequestDto {
	@ApiModelProperty(value = "사용자 ID")
    private int userId;

    @NotBlank
    @ApiModelProperty(value = "BASE64로 인코딩된 이미지 문자열")
    private String profileImage;
    
}
