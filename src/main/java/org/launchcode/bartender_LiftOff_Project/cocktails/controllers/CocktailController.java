package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.RecipeRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.IngredientRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.dto.RecipeIngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("cocktails")
public class CocktailController {

    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;


    @GetMapping
    public String displayCocktails(Model model) {
        model.addAttribute("title", "Recently Added Cocktails");
        model.addAttribute("cocktails", cocktailRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());

        return "cocktails/index";
    }
    @GetMapping("create")
    public String displayCreateCocktailForm(Model model) {
        model.addAttribute("title", "Create New Cocktail Recipe");

        Cocktail newCocktail = new Cocktail();
        RecipeIngredientDto recipeIngredients = new RecipeIngredientDto();

        for (int i = 0; i < 3; i++) {
            recipeIngredients.addIngredient(new Ingredient());
        }

        recipeIngredients.setRecipe(newCocktail.getRecipe());
        model.addAttribute("cocktail", newCocktail);
        model.addAttribute("recipe", recipeIngredients);

        return "cocktails/create";
    }

    @PostMapping("create")
    public String processCreateCocktailForm(@ModelAttribute @Valid Cocktail newCocktail, @ModelAttribute @Valid RecipeIngredientDto recipeIngredients, Errors error, Model model) {
        if (error.hasErrors()) {
            model.addAttribute("title", "Create New Cocktail Recipe");
            return "cocktails/create";
        }
        else {
            Recipe recipe = newCocktail.getRecipe();
            for (Ingredient ingredient : recipeIngredients.getIngredients()) {
                Optional<Ingredient> existingIngredient = ingredientRepository.findByNameIgnoreCase(ingredient.getName());
                if (existingIngredient.isPresent()) {
                    recipe.addIngredient((existingIngredient.get()));
                }
                else {
                    recipe.addIngredient(ingredient);
                }
            }
        }

        cocktailRepository.save(newCocktail);

        return "redirect:recipe?cocktailId=" + newCocktail.getId();
    }

    @GetMapping("recipe")
    public String displayCocktailRecipe(@RequestParam Integer cocktailId, Model model) {
        Optional<Cocktail> result = cocktailRepository.findById(cocktailId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid ID");
        } else {
            Cocktail cocktail = result.get();
            model.addAttribute("title", cocktail.getName() + " Recipe");
            model.addAttribute("cocktail", cocktail);
            model.addAttribute("ingredients", cocktail.getRecipe().getIngredients());
        }

        return "cocktails/recipe";
    }

}
