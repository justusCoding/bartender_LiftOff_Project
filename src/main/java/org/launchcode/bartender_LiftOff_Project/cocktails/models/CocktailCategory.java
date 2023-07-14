package org.launchcode.bartender_LiftOff_Project.models.cocktails;

import org.launchcode.bartender_LiftOff_Project.models.AbstractEntity;
import javax.persistence.Entity;

@Entity
public class CocktailCategory extends AbstractEntity {
   private String categoryName;
}
