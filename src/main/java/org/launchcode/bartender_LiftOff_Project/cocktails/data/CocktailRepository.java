package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {
}
