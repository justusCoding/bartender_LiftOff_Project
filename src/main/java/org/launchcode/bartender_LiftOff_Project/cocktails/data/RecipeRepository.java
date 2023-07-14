package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
