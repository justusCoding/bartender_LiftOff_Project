package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.EmployeesList;
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
        model.addAttribute(new EmployeesList());
        return "tasks/add-employee";
    }

    @PostMapping("add")
    public  String processAddEmployeePage(@ModelAttribute @Valid EmployeesList employeesList, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("employees", employeesList);
            model.addAttribute("errors", errors);
            return "tasks/add-employee";
        } else {
            employeesRepository.save(employeesList);
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
