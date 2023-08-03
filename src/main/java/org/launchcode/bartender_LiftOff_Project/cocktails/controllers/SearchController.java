package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("cocktails/search")
public class SearchController {

    @Autowired
    private CocktailRepository cocktailRepository;

//    @GetMapping("")
//    public String cocktailSearch(@NotBlank @RequestParam("search-term") String searchTerm, Model model) {
//        // TODO: FIX
//
//        model.addAttribute("title", "Search");
//        model.addAttribute("search-term", searchTerm);
////        List<Cocktail> searchResults = cocktailRepository.searchCocktails(searchTerm);
//
//        model.addAttribute("results", searchResults);
//        return "cocktails/search";
//    }
}
