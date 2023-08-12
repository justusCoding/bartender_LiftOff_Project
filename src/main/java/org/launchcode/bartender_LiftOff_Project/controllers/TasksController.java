package org.launchcode.bartender_LiftOff_Project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tasks")
public class TasksController {

    @GetMapping
    public String displayTasksPage(Model model) {
        model.addAttribute("title","Task Manager");
        return "tasks/task-manager";
    }

    @PostMapping
    public String processTasksPage() {
        return "tasks/task-manager";
    }
}
