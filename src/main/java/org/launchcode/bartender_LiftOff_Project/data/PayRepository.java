package org.launchcode.bartender_LiftOff_Project.data;

import org.launchcode.bartender_LiftOff_Project.models.Pay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends CrudRepository<Pay, Integer> {
}
