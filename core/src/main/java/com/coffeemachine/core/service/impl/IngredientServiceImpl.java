package com.coffeemachine.core.service.impl;

import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.api.v1.dto.IngredientsDto;
import com.coffeemachine.core.entity.Ingredient;
import com.coffeemachine.core.repository.IngredientRepository;
import com.coffeemachine.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public void updateIngredient(IngredientDto ingredientDto) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findByName(ingredientDto.getName());

        Ingredient ingredient;
        if (ingredientOptional.isPresent()) {
            ingredient = ingredientOptional.get();
            ingredient.setQuantity(ingredient.getQuantity() + ingredientDto.getAmount());
        } else {
            ingredient = new Ingredient();
            ingredient.setName(ingredientDto.getName());
            ingredient.setQuantity(ingredientDto.getAmount());
        }
        ingredientRepository.save(ingredient);
    }

    @Override
    @Transactional
    public void updateIngredients(IngredientsDto ingredients) {
        ingredients.getIngredients().forEach(this::updateIngredient);
    }

    @Override
    public IngredientsDto getIngredients() {
        List<IngredientDto> ingredients = ingredientRepository.findAllIngredients();
        return new IngredientsDto(ingredients);
    }
}
