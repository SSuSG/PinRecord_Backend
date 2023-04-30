package com.ssafy.enjoytrip.global.response;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ListResponseResult<T> extends ResponseResult{

    private List<T> data;

    public ListResponseResult(List<T> data) {
        super(successResponse.statusCode, successResponse.messages, successResponse.developerMessage, successResponse.timestamp);
        this.data = data;
    }
}
