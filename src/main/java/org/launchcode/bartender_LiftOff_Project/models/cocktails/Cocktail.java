package org.launchcode.bartender_LiftOff_Project.models.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cocktail extends AbstractEntity {

    @Size(min = 3, max = 50)
    @NotBlank
    private String name;


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