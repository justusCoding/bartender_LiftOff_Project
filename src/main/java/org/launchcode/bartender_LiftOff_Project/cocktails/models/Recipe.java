package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import org.hibernate.annotations.CreationTimestamp;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import org.launchcode.bartender_LiftOff_Project.models.User;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @Size(max = 500, message = "Instructions must be less than 500 characters")
    private String instructions;

    @ManyToOne(cascade=CascadeType.ALL)
    @Valid
    private Cocktail cocktail;

    @CreationTimestamp
    private LocalDateTime dateAdded;

    @ManyToOne
    @NotNull
    private User author;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<@Valid Ingredient> ingredients = new ArrayList<>();


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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Cocktail getCocktail() {
        return cocktail;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setCocktail(Cocktail cocktail) {
        this.cocktail = cocktail;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFormattedDateAdded() {
       return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(this.dateAdded);
    }
}
