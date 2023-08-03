package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import org.hibernate.annotations.CreationTimestamp;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail extends AbstractEntity {

    @Size(min = 3, max = 50, message="Cocktail name must be between 3 and 50 characters")
    @NotBlank(message = "Cocktail name is required")
    private String name;

    @OneToMany(mappedBy = "cocktail")
    @Valid
    private final List<Recipe> recipes = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime dateAdded;

    public Cocktail() {}

    public String getName() {
        return name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setName(String name) {
        this.name = name;
    }
}