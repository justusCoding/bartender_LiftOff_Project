package org.launchcode.bartender_LiftOff_Project.models.dto;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Comment;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.launchcode.bartender_LiftOff_Project.models.User;

import javax.validation.constraints.NotNull;

public class CommentDTO {

    @NotNull
    private Comment comment;

    @NotNull
    private Recipe recipe;

    @NotNull
    private User user;

    public CommentDTO() {};

    public Comment getComment() {
        return comment;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public String getCommentContents() {
        return comment.getContents();
    }

    public int getRecipeId() {
        return recipe.getId();
    }
    public String getUsername () {
        return user.getUsername();
    }

}
