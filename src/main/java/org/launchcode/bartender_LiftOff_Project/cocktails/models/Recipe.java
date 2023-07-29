package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @Size(max = 500, message = "Instructions must be less than 500 characters")
    private String instructions;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<Ingredient> ingredients = new ArrayList<>();


    public Recipe(@Size(max = 500, message = "Instructions must be less than 500 characters") String instructions) {
       this.instructions = instructions;
    }

    public Recipe() {}

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
