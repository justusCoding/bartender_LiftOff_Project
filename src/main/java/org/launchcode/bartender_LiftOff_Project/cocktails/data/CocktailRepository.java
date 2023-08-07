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

    Optional<Cocktail> findByNameIgnoreCase(String name);

}
