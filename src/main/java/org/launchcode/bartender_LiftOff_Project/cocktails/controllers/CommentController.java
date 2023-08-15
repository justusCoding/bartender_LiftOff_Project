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
import java.time.LocalDate;
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

    @PostMapping("/cocktails/recipe/comment")
    public String processAddCommentForm(@RequestParam Integer recipeId,
                                        @RequestParam String commentContents,
                                        @ModelAttribute Comment newComment,
                                        HttpServletRequest request, Model model) {
        try {
            HttpSession session = request.getSession();
            User user = authenticationController.getUserFromSession(session);
            Optional<Recipe> result = recipeRepository.findById(recipeId);

            if (user == null) {
                model.addAttribute("errorMessage", "User not found");
                return "error";
            }


            newComment.setDateAdded(LocalDate.now());
            newComment.setUserName(user);
            newComment.setContents(commentContents);

            Recipe recipe = result.get();
            recipe.addComment(newComment);
            commentRepository.save(newComment);

            return "redirect:/cocktails/recipe?recipeId=" + recipeId;

        }

            catch (Exception e) {
                model.addAttribute("title", "Error");
                model.addAttribute("errorMessage", "You're in the catch!");
                e.printStackTrace();
                return "error";
                }





    }





}
