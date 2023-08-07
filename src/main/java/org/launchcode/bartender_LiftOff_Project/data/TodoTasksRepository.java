package org.launchcode.bartender_LiftOff_Project.data;

import org.launchcode.bartender_LiftOff_Project.models.TodoTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTasksRepository extends CrudRepository<TodoTask, Integer> {
}
