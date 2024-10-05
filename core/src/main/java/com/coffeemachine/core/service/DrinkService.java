package com.coffeemachine.core.service;

import com.coffeemachine.api.v1.dto.RecipeDto;

public interface DrinkService {

    RecipeDto getDrink(String name);

    RecipeDto getPopularDrink();
}
