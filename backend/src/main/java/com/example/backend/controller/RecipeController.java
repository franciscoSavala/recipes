package com.example.backend.controller;

import com.example.backend.model.Recipe;
import com.example.backend.request.RecipeRequest;
import com.example.backend.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Recipe> postRecipe(@RequestBody RecipeRequest recipeRequest){
        return ResponseEntity.ok().body(recipeService.createRecipe(recipeRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id){
        return ResponseEntity.ok().body(recipeService.getRecipe(id));
    }
}
