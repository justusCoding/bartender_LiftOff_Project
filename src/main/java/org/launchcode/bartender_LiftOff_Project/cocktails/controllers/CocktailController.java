package org.launchcode.bartender_LiftOff_Project.cocktails.controllers;

import net.bytebuddy.asm.Advice;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.CocktailRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.RecipeRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.data.IngredientRepository;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.launchcode.bartender_LiftOff_Project.controllers.AuthenticationController;
import org.launchcode.bartender_LiftOff_Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@SessionAttributes("recipe")
@RequestMapping("cocktails")
public class CocktailController {

    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping
    public String displayCocktails(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Cocktail Recipes");

        model.addAttribute("recipes", recipeRepository.findTop10RecipesOrderByDateAddedDesc());

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            List<Recipe> userRecipes = user.getCreatedRecipes();
            model.addAttribute("userRecipes", userRecipes);
        }

        return "cocktails/index";
    }

    @GetMapping("create")
    public String displayCreateCocktailForm(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Create New Cocktail Recipe");
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        Recipe recipe = new Recipe();
        recipe.setCocktail(new Cocktail());
        recipe.setAuthor(user);
        model.addAttribute("recipe", recipe);

        return "cocktails/create";
    }

    @PostMapping(value = {"create", "edit"}, params = {"addIngredient"})
    public String addIngredient(Model model, Recipe recipe, HttpServletRequest request){
        String path = request.getServletPath();

        if(null!=recipe){
            if(null==recipe.getIngredients()){
                recipe.getIngredientQuantities().add(0.0);
                recipe.getIngredientMeasurements().add("");
                recipe.getIngredients().add(new Ingredient());
            } else {
                recipe.getIngredientQuantities().add(0.0);
                recipe.getIngredientMeasurements().add("");
                recipe.getIngredients().add(new Ingredient());
            }
        }

        if (path.endsWith("edit")) {
            model.addAttribute("title", "Edit " + recipe.getAuthor().getUsername() + "'s " + recipe.getCocktail().getName());
            return "cocktails/edit";
        }
        else {
            model.addAttribute("title", "Create New Cocktail Recipe");
            return "cocktails/create";
        }
    }

    @PostMapping(value = {"create", "edit"}, params = {"removeIngredient"})
    public String removeIngredient(Model model, Recipe recipe, HttpServletRequest request) {
        String path = request.getServletPath();
        recipe.getIngredients().remove(Integer.parseInt(request.getParameter("removeIngredient")));
        recipe.getIngredientQuantities().remove(Integer.parseInt(request.getParameter("removeIngredient")));
        recipe.getIngredientMeasurements().remove(Integer.parseInt(request.getParameter("removeIngredient")));

        if (path.endsWith("edit")) {
            model.addAttribute("title", "Edit " + recipe.getAuthor().getUsername() + "'s " + recipe.getCocktail().getName());
            return "cocktails/edit";
        }
        else {
            model.addAttribute("title", "Create New Cocktail Recipe");
            return "cocktails/create";
        }
    }

    @Transactional
    @PostMapping({"create", "edit"})
    public String processCreateCocktailForm(Model model, @ModelAttribute @Valid Recipe recipe, Errors errors, HttpServletRequest request, SessionStatus status){
        List<Ingredient> ingredientList = recipe.getIngredients();
        String path = request.getServletPath();

        if (errors.hasErrors()) {
            if (path.endsWith("create")) {
                model.addAttribute("title", "Create New Cocktail Recipe");
                return "cocktails/create";
            }
            else {
                model.addAttribute("title", "Edit " + recipe.getAuthor().getUsername() + "'s " + recipe.getCocktail().getName());
                return "cocktails/edit";
            }
        }
        else {
            //Check if cocktail already exists; if so, add recipe to list. Otherwise, create new cocktail & add recipe
            Optional<Cocktail> existingCocktail = cocktailRepository.findByNameIgnoreCase(recipe.getCocktail().getName());
            if (existingCocktail.isPresent()) {
                recipe.setCocktail(existingCocktail.get());
            }

                for (int i = 0; i < ingredientList.size(); i++) {

                Ingredient ingredient = ingredientList.get(i);

                //TODO: this functionality feels pretty hacky; should refactor to be cleaner & more efficient
                //don't edit an existing ingredient; if it's being renamed, swap with a new one; if it's not being used by other recipes, delete the old one
                Optional<Ingredient> oldIngredient = ingredientRepository.findById(ingredient.getId());
                if (oldIngredient.isPresent()) {
                    if (!ingredient.getName().equals(oldIngredient.get().getName())) {
                        ingredientList.add(i, new Ingredient(ingredient.getName()));
                        ingredientList.remove(oldIngredient.get());
                    }
                }

                //checking for duplicate ingredient names; if found, replace with existing
                Optional<Ingredient> existingIngredientName = ingredientRepository.findByNameIgnoreCase(ingredient.getName());
                if (existingIngredientName.isPresent()) {
                    ingredientList.remove(ingredient);
                    ingredientList.add(i, existingIngredientName.get());
                }
            }

            recipeRepository.save(recipe);

            status.setComplete();
            return "redirect:recipe?recipeId=" + recipe.getId();
        }
    }

    @GetMapping("recipe")
    public String displayCocktailRecipe(@RequestParam Integer recipeId, Model model) {
        Optional<Recipe> result = recipeRepository.findById(recipeId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid ID");
            model.addAttribute("errorMessage", "Recipe not found");
            return "error";
        } else {
            Recipe recipe = result.get();
            model.addAttribute("title", "View Recipe");
            model.addAttribute("recipeText", recipe.toString());
        }

        return "cocktails/recipe";
    }

    @Transactional
    @GetMapping("edit")
    public String displayEditRecipeForm(@RequestParam Integer recipeId, Model model) {
        Optional<Recipe> result = recipeRepository.findById(recipeId);

        if (result.isEmpty()) {
            model.addAttribute("errorMessage", "Recipe not found");
            return "error";
        }
        else {
            Recipe recipe = result.get();
            model.addAttribute("title", "Edit " + recipe.getAuthor().getUsername() + "'s " + recipe.getCocktail().getName());
            model.addAttribute("recipe", recipe);
        }
        return "cocktails/edit";
    }

    @Transactional
    @PostMapping(value = "edit", params = {"deleteRecipe"})
    public String deleteRecipe(Model model, Recipe recipe, SessionStatus status) {

        Optional<Cocktail> cocktailResult = cocktailRepository.findByNameIgnoreCase(recipe.getCocktail().getName());
        Optional<Recipe> recipeResult = recipeRepository.findById(recipe.getId());

        if (recipeResult.isPresent()) {
            Recipe persistantRecipe = recipeResult.get();
            for (Iterator<Ingredient> itr = persistantRecipe.getIngredients().iterator(); itr.hasNext();) {
                itr.next();
                itr.remove();
            }
        }
        if (cocktailResult.isPresent()) {
            Cocktail cocktail = cocktailResult.get();
            cocktail.getRecipes().remove(recipe);
        }

        recipeRepository.deleteById(recipe.getId());
        status.setComplete();

        return "redirect:/cocktails";
    }


}
