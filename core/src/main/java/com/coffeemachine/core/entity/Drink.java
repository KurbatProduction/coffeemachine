package com.coffeemachine.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    // Связь с рецептами
    @OneToMany(mappedBy = "drink", cascade = CascadeType.ALL)
    private List<Recipe> recipes;
}
