package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.Pay;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PayCalculatorController {

    private static List<Pay> payCalculations = new ArrayList<>();

    @GetMapping ("pay")
    public String renderPayCalculatorForm(Model model) {
        model.addAttribute("title", "Calculate Take-Home Pay");
        return "pay/payCalculator";
    }

    @PostMapping ("pay/totalPayResults")
    public String processPayCalculatorForm(@RequestParam String dateWorked,
                                           @RequestParam double hoursWorked,
                                           @RequestParam String shiftWorked,
                                           @RequestParam double hourlyRate,
                                           @RequestParam double creditCardTips,
                                           @RequestParam double cashTips,
                                           @RequestParam double taxRate, Model model) {
        Pay newPay = new Pay(dateWorked, hoursWorked, shiftWorked, hourlyRate, creditCardTips, cashTips, taxRate);
        payCalculations.add(newPay);
        model.addAttribute("payCalculations", payCalculations);
        return "pay/totalPayResults";
    }

}

