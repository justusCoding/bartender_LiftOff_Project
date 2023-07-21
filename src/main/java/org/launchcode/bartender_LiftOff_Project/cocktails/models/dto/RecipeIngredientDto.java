package org.launchcode.bartender_LiftOff_Project.cocktails.models.dto;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDto {

    @NotNull
    private Recipe recipe;
    @NotNull
    private List<Ingredient> ingredients = new ArrayList<>();

    public RecipeIngredientDto(Recipe recipe, List<Ingredient> ingredients) {
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    public RecipeIngredientDto() {}

    public Recipe getRecipe() {
        return recipe;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
