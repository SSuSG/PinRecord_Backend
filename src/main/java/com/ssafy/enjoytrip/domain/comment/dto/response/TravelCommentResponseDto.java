package com.ssafy.enjoytrip.domain.comment.dto.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.ssafy.enjoytrip.domain.travel.dto.response.TravelPinResponseDto;
import com.ssafy.enjoytrip.domain.travel.dto.response.TravelResponseDto;

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
@AllArgsConstructor
@ApiModel(value = "(TravelCommentResponseDto) 여행후기 댓글 DTO" , description = "여행후기에 관한 댓글 정보등이 담김")
public class TravelCommentResponseDto {
	
	@ApiModelProperty(value = "댓글 ID")
	private int commentId;
	
	@ApiModelProperty(value = "여행후기 ID")
	private int travelId;
	
	@ApiModelProperty(value = "작성자 Id")
	private int userId;
	
	@ApiModelProperty(value = "댓글 내용")
	private String content;
	
	@ApiModelProperty(value = "댓글 작성 시간")
	private LocalDateTime createdDate;
	
	@ApiModelProperty(value = "유저 닉네임")
	private String nickname;
	
	@ApiModelProperty(value = "유저 이미지 경로")
	private String imagePath;
	
	@ApiModelProperty(value = "댓글 수정 가능 유무")
	private boolean editing;
	
	@ApiModelProperty(value = "유저 이미지")
	private byte[] image;
	
	public TravelCommentResponseDto() {
		this.editing = false;
	}

	public void imageToBase64() throws IOException {
		InputStream imageStream = new FileInputStream(imagePath);
		byte[] imageByteArray = IOUtils.toByteArray(imageStream);
		imageStream.close();
		
		this.image = imageByteArray;
	}
}
