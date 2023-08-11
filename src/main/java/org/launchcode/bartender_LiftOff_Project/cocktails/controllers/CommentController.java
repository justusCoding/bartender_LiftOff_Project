package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
