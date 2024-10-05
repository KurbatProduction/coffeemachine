package com.coffeemachine.api.v1.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Builder
@Getter
public class RecipeDto {

    @NotNull
    private String name;

    @NotEmpty
    private List<IngredientDto> ingredients;
}
