package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.RecipeRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.IngredientRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cocktail")
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
        model.addAttribute("title", "Cocktail Recipes");
        model.addAttribute("cocktails", cocktailRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());

        return "cocktails/index";
    }

    @GetMapping("create")
    public String displayCreateCocktailForm(Model model) {
        model.addAttribute("title", "Create New Cocktail Recipe");

        Cocktail cocktail = new Cocktail();
        cocktail.setRecipe(new Recipe());
        model.addAttribute("ingredientValidatior", new Ingredient());

        model.addAttribute("cocktail", cocktail);
        return "cocktails/create";
    }

    @PostMapping(value = "create", params = {"addIngredient"})
    public String addIngredient(Model model, Cocktail cocktail){
        model.addAttribute("title", "Create New Cocktail Recipe");
        if(null!=cocktail){
            if(null==cocktail.getRecipe().getIngredients()){
                cocktail.getRecipe().getIngredients().add(new Ingredient());
            } else {
                cocktail.getRecipe().getIngredients().add(new Ingredient());
            }
        }
        return "cocktails/create";
    }

    @PostMapping(value = "create", params = {"removeIngredient"})
    public String removeIngredient(Model model, Cocktail cocktail, HttpServletRequest request) {
        model.addAttribute("title", "Create New Cocktail Recipe");
        cocktail.getRecipe().getIngredients().remove(Integer.parseInt(request.getParameter("removeIngredient")));
        return "cocktails/create";
    }

    @PostMapping("create")
    public String processCreateCocktailForm(Model model, @ModelAttribute @Valid Cocktail cocktail, Errors errors, SessionStatus status){
        List<Ingredient> ingredientList = cocktail.getRecipe().getIngredients();
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create New Cocktail Recipe");
            return "cocktails/create";
        }
        else {
            //checking for duplicates
            for (int i = 0; i < ingredientList.size(); i++) {
                Ingredient ingredient = ingredientList.get(i);
                Optional<Ingredient> existingIngredient = ingredientRepository.findByNameIgnoreCase(ingredient.getName());
                if (existingIngredient.isPresent()) {
                    ingredientList.remove(ingredient);
                    ingredientList.add(i, existingIngredient.get());
                }
            }
            cocktailRepository.save(cocktail);
            status.setComplete();
            return "redirect:recipe?cocktailId=" + cocktail.getId();
        }
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
