package com.coffeemachine.api.v1.controller;

import com.coffeemachine.api.v1.dto.RecipeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/recipe")
@Tag(name = "Recipe Controller")
public interface RecipeController {

    @PostMapping("")
    @Operation(summary = "Create new recipe")
    @ApiResponse(responseCode = "200", description = "New recipe has been created")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<Void> postRecipe(
            @Valid @RequestBody RecipeDto recipe);
}
