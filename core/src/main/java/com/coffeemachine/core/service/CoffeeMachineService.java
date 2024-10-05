package com.coffeemachine.core.service;

import com.coffeemachine.api.v1.dto.RecipeDto;

public interface CoffeeMachineService {

    RecipeDto getDrink(String name);

    void createRecipe(RecipeDto recipe);

    RecipeDto getPopularDrink();
}
