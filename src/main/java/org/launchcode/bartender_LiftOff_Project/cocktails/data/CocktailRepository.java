package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import net.bytebuddy.asm.Advice;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Cocktail;
import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
//    List<Cocktail> findByNameContainingIgnoreCase(String name);
//    @Query("SELECT c FROM Cocktail c JOIN c.recipe r JOIN r.ingredients i WHERE i.name = :ingredientName")
//    List<Cocktail> findCocktailsByIngredientName(@Param("ingredientName") String ingredientName);

//    @Query("SELECT DISTINCT c FROM Cocktail c LEFT JOIN c.recipe r LEFT JOIN r.ingredients i WHERE c.name LIKE %:searchTerm% OR i.name LIKE %:searchTerm%")
//    List<Cocktail> searchCocktails(@Param("searchTerm") String searchTerm);
    Optional<Cocktail> findByNameIgnoreCase(String name);

    @Query("SELECT c FROM Cocktail c WHERE c.dateAdded >= :startDate ORDER BY c.dateAdded DESC")
    List<Cocktail> findCocktailsCreatedAfterOrderByDateAddedDesc(@Param("startDate") LocalDateTime startDate);
}
