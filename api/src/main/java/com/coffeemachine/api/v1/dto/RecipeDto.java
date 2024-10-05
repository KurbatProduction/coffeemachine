package com.coffeemachine.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class RecipeDto {

    @NotNull
    private final String name;

    @NotEmpty
    private final List<IngredientDto> ingredients;

    @JsonCreator
    public RecipeDto(@JsonProperty("name") String name, @JsonProperty("ingredients") List<IngredientDto> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public RecipeDto() {
        this.name = null;
        this.ingredients = null;
    }
}
