package com.coffeemachine.core.repository;

import com.coffeemachine.core.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
