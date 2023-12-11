package com.example.backend.service;

import com.example.backend.model.Ingredient;
import com.example.backend.model.Recipe;
import com.example.backend.model.Step;
import com.example.backend.repository.IngredientRepository;
import com.example.backend.repository.RecipeRepository;
import com.example.backend.repository.StepRepository;
import com.example.backend.request.RecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RecipeService {


    private final RecipeRepository recipeRepository;
    private final StepRepository stepRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeService(RecipeRepository recipeRepository,
                         StepRepository stepService,
                         IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.stepRepository = stepService;
        this.ingredientRepository = ingredientRepository;
    }
    public Recipe createRecipe(RecipeRequest recipeRequest){
        List<Step> steps = Arrays.stream(recipeRequest.getSteps())
                .map(step -> Step.builder()
                        .description(step)
                        .build())
                .toList();

        List<Ingredient> ingredients = Arrays.stream(recipeRequest.getIngredients())
                .map(ingredient -> Ingredient.builder()
                        .name(ingredient)
                        .build())
                .toList();

        Recipe recipe = Recipe.builder()
                .name(recipeRequest.getName())
                .description(recipeRequest.getDescription())
                .steps(steps)
                .ingredients(ingredients)
                .build();
        Recipe savedRecipe = recipeRepository.save(recipe);
        steps.forEach(step -> step.setRecipe(savedRecipe));
        ingredients.forEach(ingredient -> ingredient.setRecipe(savedRecipe));
        stepRepository.saveAll(steps);
        ingredientRepository.saveAll(ingredients);
        return savedRecipe;
    }

    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
