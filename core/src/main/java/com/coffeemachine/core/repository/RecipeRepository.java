package com.coffeemachine.core.repository;

import com.coffeemachine.core.entity.Drink;
import com.coffeemachine.core.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    List<Recipe> findByDrink(Drink drink);
}
