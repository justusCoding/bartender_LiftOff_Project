package org.launchcode.bartender_LiftOff_Project.data.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.cocktails.Cocktail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {
}
