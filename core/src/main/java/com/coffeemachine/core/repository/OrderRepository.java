package com.coffeemachine.core.repository;

import com.coffeemachine.core.entity.Drink;
import com.coffeemachine.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o.drink " +
            "FROM Order o " +
            "GROUP BY o.drink " +
            "ORDER BY COUNT(o) DESC " +
            "LIMIT 1")
    Optional<Drink> findPopularDrink();
}
