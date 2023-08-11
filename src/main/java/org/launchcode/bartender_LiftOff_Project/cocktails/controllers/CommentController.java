package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Comment;
import org.launchcode.bartender_LiftOff_Project.data.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("cocktails/recipe/addcomment")
    public String renderAddCommentForm(Model model) {
        model.addAttribute("title", "Add Comment");
        model.addAttribute("comment", new Comment());
        return "redirect:";
    }

    @PostMapping("cocktails/recipe/addcomment")
    public String processAddCommentForm(@ModelAttribute @Valid Comment newComment,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "cocktails/recipe/addcomment";
        }
        commentRepository.save(newComment);
        return "cocktails/recipe";
    }
}
