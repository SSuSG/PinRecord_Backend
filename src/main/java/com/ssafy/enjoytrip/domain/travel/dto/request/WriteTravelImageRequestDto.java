package com.ssafy.enjoytrip.domain.travel.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.enjoytrip.domain.travel.entity.Image;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ApiModel(value = "(WriteTravelImageRequestDto) 여행후기 작성시 PIN에 들어가는 사진정보 DTO" , description = "PIN의 이미지에 관한 정보를 지님")
public class WriteTravelImageRequestDto {
	
	@NotBlank
	@ApiModelProperty(value = "사용자가 업로드한 사진 이름")
    private String uploadName;
	
	@NotBlank
	@ApiModelProperty(value = "핀 장소에 대한 이미지")
    private String image;
	
	public Image toImageEntity(int pinId , String path) {
		return Image.builder()
				.pinId(pinId)
				.path(path)
				.build();
	}
}
