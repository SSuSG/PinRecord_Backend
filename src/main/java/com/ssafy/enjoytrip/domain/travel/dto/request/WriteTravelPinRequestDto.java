package com.ssafy.enjoytrip.domain.travel.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ssafy.enjoytrip.domain.travel.entity.Pin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(value = "(WriteTravelPinRequestDto) 여행후기 작성시 PIN DTO" , description = "여행후기 작성시 PIN(장소,이미지)에 관한 정보를 지님")
public class WriteTravelPinRequestDto {
	
	@NotBlank
	@ApiModelProperty(value = "장소 이름")
    private String placeName;
	
	@NotBlank
	@ApiModelProperty(value = "장소 url")
    private String placeUrl;
	
	@NotBlank
	@ApiModelProperty(value = "카테고리 이름")
    private String categoryName;

	@NotBlank
	@ApiModelProperty(value = "지번 주소")
    private String addressName;
	
	@NotBlank
	@ApiModelProperty(value = "도로명 주소")
    private String roadAddressName;
	
	@NotBlank
	@ApiModelProperty(value = "장소 연락처")
    private String phone;
	
	@NotBlank
	@ApiModelProperty(value = "장소 카테고리 그룹 코드")
    private String categoryGroupCode;
	
	@NotBlank
	@ApiModelProperty(value = "장소 카테고리 그룹 이름")
    private String categoryGroupName;
	
	@NotBlank
	@ApiModelProperty(value = "장소에 대한 코멘트")
    private String content;
	
	@ApiModelProperty(value = "장소 x")
    private float x;
	
	@ApiModelProperty(value = "장소 y")
    private float y;
	
	@ApiModelProperty(value = "장소에 대한 이미지들")
    private List<WriteTravelImageRequestDto> imageList;
	
	public Pin toPinEntity(int travelId) {
		return Pin.builder()
				.travelId(travelId)
				.placeName(placeName)
				.placeUrl(placeUrl)
				.categoryName(categoryName)
				.addressName(addressName)
				.roadAddressName(roadAddressName)
				.phone(phone)
				.categoryGroupCode(categoryGroupCode)
				.categoryGroupName(categoryGroupName)
				.content(content)
				.x(x)
				.y(y)
				.build();
	}
}
