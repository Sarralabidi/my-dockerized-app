package com.example.cookingapp.Controller;

import com.example.cookingapp.Model.RecipesEntity;
import com.example.cookingapp.Service.ReciepeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "http://172.18.0.4:4200")  // Allow CORS from the Angular app
public class ReceipeController {

    @Autowired
    private ReciepeService recipeService;

    @PostMapping("/findByIngredients")
    public ResponseEntity<List<RecipesEntity>> getRecipesByIngredients(@RequestBody List<Integer> itemIds) {
        List<RecipesEntity> recipes = recipeService.findRecipesByIngredients(itemIds);
        return ResponseEntity.ok(recipes);
    }
}
