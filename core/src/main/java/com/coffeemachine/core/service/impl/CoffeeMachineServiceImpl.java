package com.coffeemachine.core.service.impl;

import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.repository.DrinkRepository;
import com.coffeemachine.core.repository.IngredientRepository;
import com.coffeemachine.core.repository.OrderRepository;
import com.coffeemachine.core.repository.RecipeRepository;
import com.coffeemachine.core.service.CoffeeMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

//    private final DrinkRepository drinkRepository;
//    private final IngredientRepository ingredientRepository;
//    private final OrderRepository orderRepository;
//    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDto getDrink(String name) {
        return null;
    }

    @Override
    public void createRecipe(RecipeDto recipe) {

    }

    @Override
    public RecipeDto getPopularDrink() {
        return null;
    }
}
