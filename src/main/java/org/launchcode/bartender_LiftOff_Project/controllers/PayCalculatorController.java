package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.Pay;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("pay")
public class PayCalculatorController {

    private static List<Pay> payCalculations = new ArrayList<>();

    @GetMapping
    public String renderPayCalculatorForm(Model model) {
        model.addAttribute("title", "Calculate Take-Home Pay");
        return "pay/payCalculator";
    }


    @PostMapping
    public String processPayCalculatorForm(@RequestParam Date dateWorked,
                                            @RequestParam double totalPay,
                                            Model model) {
        payCalculations.add(new Pay(dateWorked, totalPay));
        model.addAttribute("totalPay", "totalPay");
        return "pay/totalPayResults";
    }

    //TODO: Add method to view all pay calculations
}

