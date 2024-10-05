package com.coffeemachine.core.controller.impl.v1;

import com.coffeemachine.api.v1.controller.RecipeController;
import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecipeControllerImpl implements RecipeController {

    private final RecipeService recipeService;
    @Override
    public ResponseEntity<Void> postRecipe(RecipeDto recipe) {
        recipeService.createRecipe(recipe);
        return ResponseEntity.ok().build();
    }
}
