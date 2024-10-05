package com.coffeemachine.core.service.impl;

import com.coffeemachine.api.v1.CoffeeMachineExceptionEnum;
import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.entity.Drink;
import com.coffeemachine.core.entity.Ingredient;
import com.coffeemachine.core.entity.Order;
import com.coffeemachine.core.exception.CoffeeMachineException;
import com.coffeemachine.core.repository.DrinkRepository;
import com.coffeemachine.core.repository.OrderRepository;
import com.coffeemachine.core.repository.RecipeRepository;
import com.coffeemachine.core.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;
    private final OrderRepository orderRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDto getDrink(String name) {

        Drink drink = drinkRepository.findByName(name)
                .orElseThrow(() -> new CoffeeMachineException(CoffeeMachineExceptionEnum.NOT_FOUND_DRINK));

        List<IngredientDto> ingredients = new ArrayList<>();

        recipeRepository.findByDrink(drink).forEach(recipe -> {
            Ingredient ingredient = recipe.getIngredient();
            if (ingredient.getQuantity() < recipe.getAmount()) {
                throw new CoffeeMachineException(CoffeeMachineExceptionEnum.NOT_ACCEPTABLE);
            }
            ingredients.add(IngredientDto.builder()
                    .name(ingredient.getName())
                    .amount(recipe.getAmount())
                    .build());
        });

        Order order = new Order();
        order.setDrink(drink);
        orderRepository.save(order);

        return RecipeDto.builder()
                .name(drink.getName())
                .ingredients(ingredients)
                .build();
    }

    @Override
    public RecipeDto getPopularDrink() {

        Drink drink = orderRepository.findPopularDrink()
                .orElseThrow(() -> new CoffeeMachineException(CoffeeMachineExceptionEnum.NOT_FOUND_DRINK));

        List<IngredientDto> ingredients = new ArrayList<>();

        recipeRepository.findByDrink(drink).forEach(recipe -> {
            Ingredient ingredient = recipe.getIngredient();
            ingredients.add(IngredientDto.builder()
                    .name(ingredient.getName())
                    .amount(recipe.getAmount())
                    .build());
        });

        return RecipeDto.builder()
                .name(drink.getName())
                .ingredients(ingredients)
                .build();
    }
}
