package com.example.backend.repository;

import com.example.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
    public List<Recipe> findByNameContainingIgnoreCase(String name);
}
