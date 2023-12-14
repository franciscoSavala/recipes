package com.example.backend.controller;

import com.example.backend.model.Recipe;
import com.example.backend.request.RecipeRequest;
import com.example.backend.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "http://localhost:3000")
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
        try{
            return ResponseEntity.ok().body(recipeService.getRecipe(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getRecipes(@RequestParam(required = false, name = "q") String name){
        if(name != null){
            return ResponseEntity.ok().body(recipeService.getRecipesByName(name));
        }
        return ResponseEntity.ok().body(recipeService.getRecipes());
    }
}
