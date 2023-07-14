package org.launchcode.bartender_LiftOff_Project.models.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail extends AbstractEntity {

    @Size(min = 3, max = 50)
    @NotBlank(message = "Cocktail name is required")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private Recipe recipe;

    // CONSTRUCTORS

    public Cocktail(String name) {
        this.name = name;
    }

    public Cocktail() {}

    // GETTERS

    public String getName() {
        return name;
    }



    // SETTERS

    public void setName(String name) {
        this.name = name;
    }
}