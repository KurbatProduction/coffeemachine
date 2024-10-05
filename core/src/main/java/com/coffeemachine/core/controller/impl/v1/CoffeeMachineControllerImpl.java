package com.coffeemachine.core.controller.impl.v1;

import com.coffeemachine.api.v1.controller.CoffeeMachineController;
import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.service.CoffeeMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CoffeeMachineControllerImpl implements CoffeeMachineController {

    private final CoffeeMachineService coffeeMachineService;

    @Override
    public ResponseEntity<RecipeDto> getDrink(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Void> postRecipe(RecipeDto recipe) {
        return null;
    }

    @Override
    public ResponseEntity<RecipeDto> getPopularDrink() {
        return null;
    }
}
