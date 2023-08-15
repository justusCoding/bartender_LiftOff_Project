package org.launchcode.bartender_LiftOff_Project.data;

import org.launchcode.bartender_LiftOff_Project.models.Employees2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees2, Integer> {
}
