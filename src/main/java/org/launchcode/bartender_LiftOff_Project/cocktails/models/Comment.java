package org.launchcode.bartender_LiftOff_Project.cocktails.models;
import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import org.launchcode.bartender_LiftOff_Project.models.User;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comment extends AbstractEntity {

    private LocalDateTime dateAdded;

    @ManyToOne
    @JoinColumn(name="username")
    @NotNull
    @Valid
    private User userName;

    @Size(min = 5, max = 500, message = "Comments must be between 5 and 500 characters.")
    private String contents;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    public Comment(LocalDateTime dateAdded, User userName, String contents) {
        this.dateAdded = dateAdded;
        this.userName = userName;
        this.contents = contents;
    }

    public Comment(){}

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
