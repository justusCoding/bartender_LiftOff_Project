package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.data.TodoTasksRepository;
import org.launchcode.bartender_LiftOff_Project.models.TodoTasks;
import org.launchcode.bartender_LiftOff_Project.models.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("tasks/todo")
public class TodoTasksController {
    @Autowired
    private TodoTasksRepository todoTasksRepository;

    @GetMapping("add")
    public String displayAddTodoTasksPage(Model model) {
        model.addAttribute(new TodoTasks());
        model.addAttribute("todoTaskTypes", TaskType.values());
        return "tasks/add-todo";
    }

    @PostMapping("add")
    public String processAddToDoTasksPage(@ModelAttribute @Valid TodoTasks todoTasks, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("todoTasks", todoTasks);
            model.addAttribute("errors", errors);
            return "tasks/add-todo";
        } else {
            todoTasksRepository.save(todoTasks);
        }
        return "redirect:list";
    }

    @GetMapping("list")
    public String displayListToDoTasksPage(Model model) {
        model.addAttribute("todotasks", todoTasksRepository.findAll());
        return "tasks/list-todo";
    }

    @GetMapping("delete")
    public String displayDeleteToDoTasksPage(Model model) {
        model.addAttribute("todotasks", todoTasksRepository.findAll());
        return "tasks/delete-todo";
    }

    @PostMapping("delete")
    public String processDeleteToDoTasksPage(@RequestParam(required = false) int[] todoTaskIds) {
        for (int id : todoTaskIds) {
            todoTasksRepository.deleteById(id);
        }
        return "redirect:list";
    }
}
