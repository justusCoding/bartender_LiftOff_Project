package org.launchcode.bartender_LiftOff_Project.data.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.cocktails.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
