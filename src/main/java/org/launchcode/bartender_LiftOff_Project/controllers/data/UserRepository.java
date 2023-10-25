package org.launchcode.bartender_LiftOff_Project.controllers.data;
import org.launchcode.bartender_LiftOff_Project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

}

