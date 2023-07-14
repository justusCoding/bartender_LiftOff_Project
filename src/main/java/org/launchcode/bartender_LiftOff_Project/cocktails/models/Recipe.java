package org.launchcode.bartender_LiftOff_Project.models.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Recipe extends AbstractEntity {

    @Size(max = 500, message = "Instructions must be less than 500 characters")
    private String instructions;

    public Recipe(@Size(max = 500, message = "Description too long!") String instructions) {
       this.instructions = instructions;
    }

    public Recipe() {}

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
