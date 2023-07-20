package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {
    List<Cocktail> findByNameContainingIgnoreCase(String name);
    @Query("SELECT c FROM Cocktail c JOIN c.recipe r JOIN r.ingredients i WHERE i.name = :ingredientName")
    List<Cocktail> findCocktailsByIngredientName(@Param("ingredientName") String ingredientName);
}
