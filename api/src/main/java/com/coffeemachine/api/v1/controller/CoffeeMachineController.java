package com.coffeemachine.api.v1.controller;

import com.coffeemachine.api.v1.dto.RecipeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RequestMapping("/api/v1")
public interface CoffeeMachineController {

    @GetMapping("/drink")
    @Operation(summary = "Get drink by name")
    @ApiResponse(responseCode = "200", description = "Drink has been sent")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<RecipeDto> getDrink(
            @RequestParam("drink_name") String name);

    @PostMapping("/recipe")
    @Operation(summary = "Create new recipe")
    @ApiResponse(responseCode = "200", description = "New recipe has been created")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<Void> postRecipe(
            @Valid @RequestBody RecipeDto recipe);

    @GetMapping("/drink/popular")
    @Operation(summary = "Get most popular drink")
    @ApiResponse(responseCode = "200", description = "Most popular drink has been sent")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<RecipeDto> getPopularDrink();
}
