package com.coffeemachine.core.service;

import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.api.v1.dto.IngredientsDto;

public interface IngredientService {

    void updateIngredient(IngredientDto ingredient);

    void updateIngredients(IngredientsDto ingredients);

    IngredientsDto getIngredients();
}
