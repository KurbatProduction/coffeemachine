package com.coffeemachine.core.service;

import com.coffeemachine.api.v1.dto.RecipeDto;

public interface RecipeService {

    void createRecipe(RecipeDto recipe);
}
