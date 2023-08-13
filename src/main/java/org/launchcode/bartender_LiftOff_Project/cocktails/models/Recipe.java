package org.launchcode.bartender_LiftOff_Project.cocktails.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.CreationTimestamp;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import org.launchcode.bartender_LiftOff_Project.models.User;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Recipe extends AbstractEntity {

    @Size(min = 3, max = 500, message = "Instructions are required and must be less than 500 characters")
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
    private final List<@Valid Ingredient> ingredients = new ArrayList<>();

    @ElementCollection
    private final List<Double> ingredientQuantities = new ArrayList<>();
    @ElementCollection
    private final List<String> ingredientMeasurements = new ArrayList<>();

    public Recipe(String instructions) {
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

    public List<Double> getIngredientQuantities() {
        return ingredientQuantities;
    }

    public List<String> getIngredientMeasurements() {
        return ingredientMeasurements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(author.getUsername() + "'s " + cocktail.getName() + " Recipe\n\nRequired Ingredients:\n\n");
        for (int i = 0; i < ingredients.size(); i++) {
            stringBuilder.append(ingredientQuantities.get(i)).append(" ").append(ingredientMeasurements.get(i)).append(" ").append(ingredients.get(i).getName()).append("\n");
        }
        stringBuilder.append("\n").append(instructions);

        return stringBuilder.toString();
    }
}
