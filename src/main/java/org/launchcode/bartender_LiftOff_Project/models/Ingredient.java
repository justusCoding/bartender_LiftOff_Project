package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank
    @Size(min = 3, message = "Ingredient name must be at least 3 characters long.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
