package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.data.CompletedTasksRepository;
import org.launchcode.bartender_LiftOff_Project.models.CompletedTasks;
import org.launchcode.bartender_LiftOff_Project.models.Employees;
import org.launchcode.bartender_LiftOff_Project.models.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CompletedTasksController {
    @Autowired
    private CompletedTasksRepository completedTasksRepository;

    @GetMapping("tasks/add-completed")
    public String displayCompletedTasksPage(Model model) {
        model.addAttribute(new CompletedTasks());
        model.addAttribute("completedTaskTypes", TaskType.values());
        model.addAttribute("employees", Employees.values());
        return "tasks/add-completed";
    }

    @PostMapping("tasks/add-completed")
    public String processAddCompletedTasksPage(@ModelAttribute @Valid CompletedTasks completedTasks, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("completedTasks", completedTasks);
            model.addAttribute("errors", errors);
        } else {
            completedTasksRepository.save(completedTasks);
        }
        return "tasks/add-completed";
    }

    @GetMapping("tasks/list-completed")
    public String displayListCompletedTasksPage(Model model) {
        model.addAttribute("completedtasks", completedTasksRepository.findAll());
        return "tasks/list-completed";
    }

    @GetMapping("tasks/delete-completed")
    public String displayDeleteCompletedTaskPage(Model model) {
        model.addAttribute("completedtasks", completedTasksRepository.findAll());
        return "tasks/delete-completed";
    }

    @PostMapping("tasks/delete-completed")
    public String processDeleteCompletedTaskPage(@RequestParam(required = false) int[] completedTaskIds) {
        for (int id : completedTaskIds) {
            completedTasksRepository.deleteById(id);
        }
        return "tasks/list-completed";
    }
}

