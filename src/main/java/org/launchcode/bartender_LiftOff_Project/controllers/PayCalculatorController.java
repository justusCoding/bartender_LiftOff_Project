package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.models.Pay;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PayCalculatorController {

    private static List<Pay> payCalculations = new ArrayList<>();

    @GetMapping ("pay")
    public String renderPayCalculatorForm(Model model) {
        model.addAttribute("title", "Calculate Take-Home Pay");
        model.addAttribute("pay", new Pay());
        return "pay/payCalculator";
    }

    @PostMapping ("pay/totalPayResults")
    public String processPayCalculatorForm(@ModelAttribute @Valid Pay newPay,
                                           Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "pay/payCalculator";
        }
        // Calculate the totalPay after form data has been processed
        Double totalPay = ((newPay.getHourlyRate() * newPay.getHoursWorked())
                + newPay.getCreditCardTips() + newPay.getCashTips())
                * (1 - (newPay.getTaxRate() / 100));
        newPay.setTotalPay(totalPay);
        payCalculations.add(newPay);
        model.addAttribute("payCalculations", payCalculations);
        return "pay/totalPayResults";
    }

}

