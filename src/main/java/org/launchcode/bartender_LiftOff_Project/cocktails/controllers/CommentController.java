package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.RecipeRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Comment;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.launchcode.bartender_LiftOff_Project.controllers.AuthenticationController;
import org.launchcode.bartender_LiftOff_Project.data.CommentRepository;
import org.launchcode.bartender_LiftOff_Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @PostMapping("/cocktails/recipe(recipeId={recipeId})")
    public String processAddCommentForm(@RequestParam String commentContents,
                                        @PathVariable Integer recipeId,
                                        @ModelAttribute @Valid Comment newComment,
                                        HttpServletRequest request,
                                        Model model, Errors errors) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        if (user == null) {
            model.addAttribute("title", "Invalid ID");
            model.addAttribute("errorMessage", "User not found");
            System.out.println("User not found");
            return "error";
        }
//
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        if(errors.hasErrors()) {
            model.addAttribute("errorMessage", "Different issue!");
            System.out.println("Other issue");
            return "error";
        }
            newComment.setDateAdded(LocalDateTime.now());
            newComment.setUserName(user);
            newComment.setContents(commentContents);

        if (result.isPresent()) {
            Recipe recipe = result.get();
            recipe.addComment(newComment);
        } else {
            model.addAttribute("title", "Invalid ID");
            model.addAttribute("errorMessage", "Recipe not found");
            System.out.println("Recipe not found");
            return "error";        }

        commentRepository.save(newComment);

        return "redirect:/cocktails/recipe?recipeId=" + recipeId;
    }
}
