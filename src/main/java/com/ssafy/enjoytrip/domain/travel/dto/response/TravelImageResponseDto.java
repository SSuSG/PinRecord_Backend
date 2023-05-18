package com.ssafy.enjoytrip.domain.travel.dto.response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.ssafy.enjoytrip.domain.comment.dto.response.TravelCommentResponseDto;

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
@ApiModel(value = "(TravelImageResponseDto) 여행후기 핀 이미지 DTO" , description = "PIN의 이미지 정보를 지님")
public class TravelImageResponseDto {
		
	@ApiModelProperty(value = "핀ID")
	private int pinId;
	
	@ApiModelProperty(value = "이미지 ID")
	private int imageId;
	
	@ApiModelProperty(value = "사진을 저장된 경로")
    private String path;
	
	@ApiModelProperty(value = "사진을 base64로 인코딩한 문자열")
    private byte[] image;
	
	public void imageToBase64() throws IOException {
		InputStream imageStream = new FileInputStream(path);
		byte[] imageByteArray = IOUtils.toByteArray(imageStream);
		imageStream.close();
		
		this.image = imageByteArray;
	}
}
