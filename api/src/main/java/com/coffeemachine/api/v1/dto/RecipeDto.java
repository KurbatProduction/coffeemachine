package com.coffeemachine.api.v1.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RecipeDto {

    @NotNull
    private final String name;

    @NotEmpty
    private final List<IngredientDto> ingredients;
}
