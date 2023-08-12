package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query("SELECT r FROM Recipe r WHERE r.dateAdded >= :startDate ORDER BY r.dateAdded DESC")
    List<Recipe> findRecipesCreatedAfterOrderByDateAddedDesc(@Param("startDate") LocalDateTime startDate);

    @Query("SELECT DISTINCT r FROM Recipe r LEFT JOIN r.ingredients i LEFT JOIN r.cocktail c WHERE c.name LIKE %:searchTerm% OR i.name LIKE %:searchTerm% OR c.name LIKE %:searchTerm%")
    List<Recipe> findByCocktailNameOrIngredientNameContaining(@Param("searchTerm") String searchTerm);
}
