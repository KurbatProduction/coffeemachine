package com.coffeemachine.api.v1.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionDto {

    private String error;

    private String message;
}
