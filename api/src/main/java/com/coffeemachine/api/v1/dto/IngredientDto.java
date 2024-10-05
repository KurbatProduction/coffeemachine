package com.coffeemachine.api.v1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IngredientDto {

    @NotBlank
    private final String name;

    @NotNull
    @Positive
    private final Integer amount;
}
