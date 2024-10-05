package com.coffeemachine.core.controller.impl.v1;

import com.coffeemachine.api.v1.controller.DrinkController;
import com.coffeemachine.api.v1.dto.RecipeDto;
import com.coffeemachine.core.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DrinkControllerImpl implements DrinkController {

    private final DrinkService drinkService;

    @Override
    public ResponseEntity<RecipeDto> getDrink(String name) {
        return ResponseEntity.ok(drinkService.getDrink(name));
    }

    @Override
    public ResponseEntity<RecipeDto> getPopularDrink() {
        return ResponseEntity.ok(drinkService.getPopularDrink());
    }
}
