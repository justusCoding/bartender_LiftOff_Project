package org.launchcode.bartender_LiftOff_Project.cocktails.data;

import org.launchcode.bartender_LiftOff_Project.cocktails.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Optional <Ingredient> findByNameIgnoreCase(String name);
}
