package com.coffeemachine.api.v1.controller;

import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.api.v1.dto.IngredientsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/ingredient")
@Tag(name = "Ingredient Controller")
public interface IngredientController {

    @PostMapping("")
    @Operation(summary = "Add ingredient")
    @ApiResponse(responseCode = "200", description = "Ingredient has been added")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<Void> postIngredient(
            @Valid @RequestBody IngredientDto ingredient);

    @PostMapping("/list")
    @Operation(summary = "Add ingredients")
    @ApiResponse(responseCode = "200", description = "Ingredients have been added")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<Void> postIngredients(
            @Valid @RequestBody IngredientsDto ingredients);

    @GetMapping("/list")
    @Operation(summary = "Get most popular drink")
    @ApiResponse(responseCode = "200", description = "Most popular drink has been sent")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<IngredientsDto> getIngredients();
}
