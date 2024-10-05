package com.coffeemachine.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class IngredientDto {

    @NotBlank
    private final String name;

    @NotNull @Positive
    private final Integer amount;

    @JsonCreator
    public IngredientDto(@JsonProperty("name") String name, @JsonProperty("amount") Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public IngredientDto() {
        this.name = null;
        this.amount = null;
    }
}
