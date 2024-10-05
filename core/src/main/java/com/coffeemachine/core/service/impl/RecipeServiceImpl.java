package com.coffeemachine.core.service.impl;

import com.coffeemachine.api.v1.CoffeeMachineExceptionEnum;
import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.entity.Drink;
import com.coffeemachine.core.entity.Ingredient;
import com.coffeemachine.core.entity.Recipe;
import com.coffeemachine.core.exception.CoffeeMachineException;
import com.coffeemachine.core.repository.DrinkRepository;
import com.coffeemachine.core.repository.IngredientRepository;
import com.coffeemachine.core.repository.RecipeRepository;
import com.coffeemachine.core.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final DrinkRepository drinkRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void createRecipe(RecipeDto recipeDto) {

        try {

            Drink drink = new Drink();
            drink.setName(recipeDto.getName());
            drinkRepository.save(drink);

            List<Recipe> recipes = new ArrayList<>();
            recipeDto.getIngredients().forEach(ingredientDto -> {
                Ingredient requieredIngredient = ingredientRepository.findByName(ingredientDto.getName())
                        .orElseThrow(() -> new CoffeeMachineException(CoffeeMachineExceptionEnum.NOT_FOUND_INGREDIENT));
                Recipe recipe = new Recipe();
                recipe.setDrink(drink);
                recipe.setIngredient(requieredIngredient);
                recipe.setAmount(ingredientDto.getAmount());
                recipes.add(recipe);
            });
            recipeRepository.saveAll(recipes);

        } catch (DataIntegrityViolationException e) {
            throw new CoffeeMachineException(CoffeeMachineExceptionEnum.DUPLICATE_VALUE);
        }
    }
}
