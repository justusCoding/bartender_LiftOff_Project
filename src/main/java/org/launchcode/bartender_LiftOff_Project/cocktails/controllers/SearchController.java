package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.RecipeRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
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
    private RecipeRepository recipeRepository;

    @GetMapping("")
    public String cocktailSearch(@NotBlank @RequestParam("search-term") String searchTerm, Model model) {

        model.addAttribute("title", "Search");
        model.addAttribute("searchTerm", searchTerm);
        List<Recipe> searchResults = recipeRepository.findByCocktailNameOrIngredientNameContaining(searchTerm);
        model.addAttribute("results", searchResults);

        return "cocktails/search";
    }
}
