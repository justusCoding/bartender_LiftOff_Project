package org.launchcode.bartender_LiftOff_Project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TasksController {

    @GetMapping("tasks/task-manager")
    public String displayTasksPage() {
        return "tasks/task-manager";
    }

    @PostMapping("tasks/task-manager")
    public String processTasksPage() {
        return "tasks/task-manager";
    }
}
