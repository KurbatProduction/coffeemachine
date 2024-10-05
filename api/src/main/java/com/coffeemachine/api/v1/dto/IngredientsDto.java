package com.coffeemachine.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;

@Getter
public class IngredientsDto {

    @NotEmpty
    private final List<IngredientDto> ingredients;

    @JsonCreator
    public IngredientsDto(@JsonProperty("ingredients") List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public IngredientsDto() {
        this.ingredients = null;
    }
}
