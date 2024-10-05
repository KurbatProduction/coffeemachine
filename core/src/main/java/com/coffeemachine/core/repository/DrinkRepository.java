package com.coffeemachine.core.repository;

import com.coffeemachine.core.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DrinkRepository extends JpaRepository<Drink, UUID> {
}
