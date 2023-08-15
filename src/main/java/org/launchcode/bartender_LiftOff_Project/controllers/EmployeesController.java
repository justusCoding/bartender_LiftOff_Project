package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.Employees2;
import org.launchcode.bartender_LiftOff_Project.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.launchcode.bartender_LiftOff_Project.data.EmployeesRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("employees")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("list")
    public String displayListEmployeePage(Model model) {
        model.addAttribute("title", "Employees");
        model.addAttribute("employeeList", employeesRepository.findAll());
        return "tasks/list-employee";
    }

    @GetMapping("add")
    public String displayAddEmployeePage(Model model) {
        model.addAttribute("title", "Add Employee");
        model.addAttribute("positionType", Position.values());
        model.addAttribute(new Employees2());
        return "tasks/add-employee";
    }

    @PostMapping("add")
    public  String processAddEmployeePage(@ModelAttribute @Valid Employees2 employees2, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("employees", employees2);
            model.addAttribute("errors", errors);
            return "tasks/add-employee";
        } else {
            employeesRepository.save(employees2);
        }
        return "redirect:list";
    }

    @GetMapping("delete")
    public String displayDeleteEmployeePage(Model model) {
        model.addAttribute("title", "Delete Employee");
        model.addAttribute("employeeList", employeesRepository.findAll());
        return "tasks/delete-employee";
    }

    @PostMapping("delete")
    public String processDeleteEmployeePage(@RequestParam(required = false) int[] employeeIds) {
        for (int id : employeeIds) {
            employeesRepository.deleteById(id);
        }
        return "redirect:list";
    }
}
