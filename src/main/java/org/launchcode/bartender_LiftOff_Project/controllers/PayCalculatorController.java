package org.launchcode.bartender_LiftOff_Project.controllers;

import org.launchcode.bartender_LiftOff_Project.data.PayRepository;
import org.launchcode.bartender_LiftOff_Project.models.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
public class PayCalculatorController {

    @Autowired
    private PayRepository payRepository;

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
            model.addAttribute("title", "Calculate Take-Home Pay");
            return "pay/payCalculator";
        }
        // Calculate the totalPay after form data has been processed
        Double totalPay = ((newPay.getHourlyRate() * newPay.getHoursWorked())
                + newPay.getCreditCardTips() + newPay.getCashTips())
                * (1 - (newPay.getTaxRate() / 100));

        Double roundedTotalPay = (double) Math.round(totalPay * 100) / 100;

        newPay.setTotalPay(roundedTotalPay);
        payRepository.save(newPay);
        model.addAttribute("payCalculations", payRepository.findAll());
        model.addAttribute("title", "Total Take-Home Pay");
        return "pay/totalPayResults";
    }

}

