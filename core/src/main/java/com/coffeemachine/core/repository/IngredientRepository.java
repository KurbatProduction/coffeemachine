package com.coffeemachine.core.repository;

import com.coffeemachine.api.v1.dto.IngredientDto;
import com.coffeemachine.core.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    Optional<Ingredient> findByName(String name);

    @Query("SELECT new com.coffeemachine.api.v1.dto.IngredientDto(" +
            "   i.name, i.quantity)" +
            "FROM Ingredient i")
    List<IngredientDto> findAllIngredients();
}
