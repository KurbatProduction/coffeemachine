package com.coffeemachine.api.v1.controller;

import com.coffeemachine.api.v1.dto.RecipeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/v1/drink")
@Tag(name = "Drink Controller")
public interface DrinkController {

    @GetMapping("")
    @Operation(summary = "Get drink by name")
    @ApiResponse(responseCode = "200", description = "Drink has been sent")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<RecipeDto> getDrink(
            @RequestParam("drink_name") String name);

    @GetMapping("/popular")
    @Operation(summary = "Get most popular drink")
    @ApiResponse(responseCode = "200", description = "Most popular drink has been sent")
    @ApiResponse(responseCode = "400", description = "Bad request")
    ResponseEntity<RecipeDto> getPopularDrink();
}
