package com.coffeemachine.api.v1.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class IngredientsDto {
    List<IngredientDto> ingredients;
}
