package com.coffeemachine.core.controller.impl.v1;

import com.coffeemachine.api.v1.controller.IngredientController;
import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.api.v1.dto.IngredientsDto;
import com.coffeemachine.core.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IngredientControllerImpl implements IngredientController {

    private final IngredientService ingredientService;

    @Override
    public ResponseEntity<Void> postIngredient(IngredientDto ingredient) {
        ingredientService.updateIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> postIngredients(IngredientsDto ingredients) {
        ingredientService.updateIngredients(ingredients);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<IngredientsDto> getIngredients() {
        return ResponseEntity.ok(ingredientService.getIngredients());
    }
}
