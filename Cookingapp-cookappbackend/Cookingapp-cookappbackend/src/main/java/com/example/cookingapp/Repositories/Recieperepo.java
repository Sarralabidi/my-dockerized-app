package com.example.cookingapp.Repositories;

import com.example.cookingapp.Model.RecipesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Recieperepo extends JpaRepository<RecipesEntity, Long> {



        @Query("SELECT r FROM RecipesEntity r " +
                "JOIN RecipeIngredientsEntity ri ON r.recipeId = ri.recipeId " +
                "WHERE ri.idItem IN :itemIds " +
                "GROUP BY r.recipeId " +
                "HAVING COUNT(ri.idItem) = (SELECT COUNT(ri2.id) FROM RecipeIngredientsEntity ri2 WHERE ri2.recipeId = r.recipeId)")
        List<RecipesEntity> findRecipesByIngredients(@Param("itemIds") List<Integer> itemIds);
    }


