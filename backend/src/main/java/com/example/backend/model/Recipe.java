package com.example.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "recipe")
    private List<Step> steps;
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;
}
