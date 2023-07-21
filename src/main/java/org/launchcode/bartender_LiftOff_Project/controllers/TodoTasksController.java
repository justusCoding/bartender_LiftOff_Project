package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.data.TodoTasksRepository;
import org.launchcode.bartender_LiftOff_Project.models.TodoTasks;
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
public class TodoTasksController {
    @Autowired
    private TodoTasksRepository todoTasksRepository;

    @GetMapping("tasks/add-todo")
    public String displayAddTODOTasksPage(Model model) {
        model.addAttribute(new TodoTasks());
        model.addAttribute("todoTaskTypes", TaskType.values());
        return "tasks/add-todo";
    }

    @PostMapping("tasks/add-todo")
    public String processAddTODOTasksPage(@ModelAttribute @Valid TodoTasks todoTasks, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("todoTasks", todoTasks);
            model.addAttribute("errors", errors);
        } else {
            todoTasksRepository.save(todoTasks);
        }
        return "tasks/add-todo";
    }

    @GetMapping("tasks/list-todo")
    public String displayTODOTasksPage(Model model) {
        model.addAttribute("todotasks", todoTasksRepository.findAll());
        return "tasks/list-todo";
    }

    @GetMapping("tasks/delete-todo")
    public String displayDeleteTODOTaskPage(Model model) {
        model.addAttribute("todotasks", todoTasksRepository.findAll());
        return "tasks/delete-todo";
    }

    @PostMapping("tasks/delete-todo")
    public String processDeleteTODOTaskPage(@RequestParam(required = false) int[] todoTaskIds) {
        for (int id : todoTaskIds) {
            todoTasksRepository.deleteById(id);
        }
        return "tasks/list-todo";
    }
}
