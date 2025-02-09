package com.example.cookingapp.Service;

import com.example.cookingapp.Model.RecipesEntity;
import com.example.cookingapp.Repositories.Recieperepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciepeService {


        @Autowired
        private Recieperepo recipeRepository;

        public List<RecipesEntity> findRecipesByIngredients(List<Integer> itemIds) {
            // Custom query to fetch recipes where all ingredients are present in the itemIds list
            return recipeRepository.findRecipesByIngredients(itemIds);
        }
    }


