package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import org.hibernate.annotations.CreationTimestamp;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
public class Cocktail extends AbstractEntity {

    @Size(min = 3, max = 50, message="Cocktail name must be between 3 and 50 characters")
    @NotBlank(message = "Cocktail name is required")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Recipe recipe;

    @CreationTimestamp
    private Timestamp dateAdded;

    // CONSTRUCTORS
    public Cocktail(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public Cocktail() {}

    // GETTERS
    public String getName() {
        return name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

// SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}