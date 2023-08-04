package org.launchcode.bartender_LiftOff_Project.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

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

    public int getId() {
        return id;
    }
}

