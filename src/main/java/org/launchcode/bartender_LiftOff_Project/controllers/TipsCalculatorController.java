package org.launchcode.bartender_LiftOff_Project.controllers.tips;


import org.launchcode.bartender_LiftOff_Project.models.TipsCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("tips")
public class TipsCalculatorController {


    @GetMapping
    public String renderTipsCalculatorForm() {
        return "tips/tipsCalculator";
    }


    @PostMapping
    public String processTipsCalculatorForm(Model model, new TipsCalculator()) {
        double totalTakeHome = getTotalNetPay
        model.addAttribute()
        return "tips/totalTakeHome";
    }
}

