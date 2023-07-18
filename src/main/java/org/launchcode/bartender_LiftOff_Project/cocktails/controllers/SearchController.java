package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("cocktails/search")
public class SearchController {

    @Autowired
    private CocktailRepository cocktailRepository;

    @GetMapping("")
    public String cocktailSearch(@RequestParam("search-term") String searchTerm, Model model) {
        model.addAttribute("title", "Search");
        model.addAttribute("search-term", searchTerm);
        List<Cocktail> searchResults = cocktailRepository.findByNameContainingIgnoreCase(searchTerm);
        List<Cocktail> searchResults2 = cocktailRepository.findByIngredientContainingIgnoreCase(searchTerm);

        model.addAttribute("results", searchResults);
        model.addAttribute("results2", searchResults2);
        return "cocktails/search";
    }
}
