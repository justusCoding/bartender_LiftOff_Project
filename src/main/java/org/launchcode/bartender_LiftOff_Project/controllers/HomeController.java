package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;
    @GetMapping
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("title", "Mix Muse");
        model.addAttribute("user", user);

        return "index"; }

}
