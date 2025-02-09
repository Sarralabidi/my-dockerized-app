package com.example.cookingapp.Model;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "recipes", schema = "cookapp", catalog = "")
public class RecipesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recipe_id")
    private int recipeId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "preparation_steps", columnDefinition = "TEXT")
    private String preparationSteps;
    @Basic
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Basic
    @Column(name = "servings")
    private Integer servings;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(String preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipesEntity that = (RecipesEntity) o;
        return recipeId == that.recipeId && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(preparationSteps, that.preparationSteps) && Objects.equals(totalCost, that.totalCost) && Objects.equals(servings, that.servings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, description, preparationSteps, totalCost, servings);
    }
}
