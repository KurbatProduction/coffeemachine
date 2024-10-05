package com.coffeemachine.api.v1.dto;

import lombok.Getter;

@Getter
public class ExceptionDto {

    private final String error;

    private final String message;

    public ExceptionDto(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
