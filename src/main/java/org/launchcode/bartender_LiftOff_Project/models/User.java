package org.launchcode.bartender_LiftOff_Project.models;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @OneToMany(mappedBy = "author")
    private final List<@Valid Recipe> createdRecipes = new ArrayList<>();

    public User(){}

    public User(String username, String password){
        this.username=username;
        this.pwHash=encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public List<Recipe> getCreatedRecipes() {
        return createdRecipes;
    }
}

