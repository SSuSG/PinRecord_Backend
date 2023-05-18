package com.ssafy.enjoytrip.domain.travel.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.enjoytrip.domain.travel.entity.Image;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(WriteTravelImageRequestDto) 여행후기 작성시 PIN에 들어가는 사진정보 DTO" , description = "PIN의 이미지에 관한 정보를 지님")
public class WriteTravelImageRequestDto {
	
	@NotBlank
	@ApiModelProperty(value = "사용자가 업로드한 사진 이름")
    private String uploadName;
	
	@NotBlank
	@ApiModelProperty(value = "사진을 base64로 인코딩한 문자열")
    private MultipartFile image;
	
	public Image toImageEntity(int pinId , String path) {
		return Image.builder()
				.pinId(pinId)
				.path(path)
				.build();
	}
}
