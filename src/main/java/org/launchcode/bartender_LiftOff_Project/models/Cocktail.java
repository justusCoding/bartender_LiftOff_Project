package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail extends AbstractEntity {

    @Size(min = 1, max = 50)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "cocktail")
    private final List<Ingredient> ingredientList = new ArrayList<>();

    private String recipe;

    public Cocktail(String name) {
        this.name = name;
    }

    public Cocktail() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}