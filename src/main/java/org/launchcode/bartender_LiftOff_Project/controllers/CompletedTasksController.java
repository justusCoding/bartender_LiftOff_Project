package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.data.CompletedTasksRepository;
import org.launchcode.bartender_LiftOff_Project.models.CompletedTask;
import org.launchcode.bartender_LiftOff_Project.models.Employees;
import org.launchcode.bartender_LiftOff_Project.models.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("tasks/completed")
public class CompletedTasksController {
    @Autowired
    private CompletedTasksRepository completedTasksRepository;

    @GetMapping("add")
    public String displayAddCompletedTasksPage(Model model) {
        model.addAttribute(new CompletedTask());
        model.addAttribute("completedTaskTypes", TaskType.values());
        model.addAttribute("employees", Employees.values());
        return "tasks/add-completed";
    }

    @PostMapping("add")
    public String processAddCompletedTasksPage(@ModelAttribute @Valid CompletedTask completedTask, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("completedTasks", completedTask);
            model.addAttribute("errors", errors);
            return "tasks/add-completed";
        } else {
            completedTasksRepository.save(completedTask);
        }
        return "redirect:list";
    }

    @GetMapping("list")
    public String displayListCompletedTasksPage(Model model) {
        model.addAttribute("completedTasksList", completedTasksRepository.findAll());
        return "tasks/list-completed";
    }

    @GetMapping("delete")
    public String displayDeleteCompletedTasksPage(Model model) {
        model.addAttribute("completedTasksList", completedTasksRepository.findAll());
        return "tasks/delete-completed";
    }

    @PostMapping("delete")
    public String processDeleteCompletedTasksPage(@RequestParam(required = false) int[] completedTaskIds) {
        for (int id : completedTaskIds) {
            completedTasksRepository.deleteById(id);
        }
        return "redirect:list";
    }
}

