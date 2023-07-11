package org.launchcode.bartender_LiftOff_Project.data;

import org.launchcode.bartender_LiftOff_Project.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
