package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @Size(max = 32)
    @NotBlank(message = "Name of ingredient required")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @NotNull
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
