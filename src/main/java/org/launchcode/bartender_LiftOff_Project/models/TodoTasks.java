package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class TodoTasks {
    @Id
    @GeneratedValue
    private int todoTaskId;
    @NotBlank(message = "Name is required.")
    private String todoTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String todoTaskNotes;
    private String desiredCompletionDate;
    private TaskType todoTaskType;

    public TodoTasks() {
    }

    public TodoTasks(String todoTaskName, String todoTaskDescription, String desiredCompletionDate, TaskType todoTaskType) {
        this();
        this.todoTaskName = todoTaskName;
        this.todoTaskNotes = todoTaskDescription;
        this.desiredCompletionDate = desiredCompletionDate;
        this.todoTaskType = todoTaskType;
    }

    public int getTodoTaskId() {
        return todoTaskId;
    }

    public String getTodoTaskName() {
        return todoTaskName;
    }

    public void setTodoTaskName(String todoTaskName) {
        this.todoTaskName = todoTaskName;
    }

    public String getTodoTaskNotes() {
        return todoTaskNotes;
    }

    public void setTodoTaskNotes(String todoTaskNotes) {
        this.todoTaskNotes = todoTaskNotes;
    }

    public String getDesiredCompletionDate() {
        return desiredCompletionDate;
    }

    public void setDesiredCompletionDate(String desiredCompletionDate) {
        this.desiredCompletionDate = desiredCompletionDate;
    }

    public TaskType getTodoTaskType() {
        return todoTaskType;
    }

    public void setTodoTaskType(TaskType todoTaskType) {
        this.todoTaskType = todoTaskType;
    }

    @Override
    public String toString() {
        return "Name: " + todoTaskName + '\n' +
                "Notes: " + todoTaskNotes + '\n' +
                "Ideal Date Completed By: " + desiredCompletionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoTasks)) return false;
        TodoTasks todoTasks = (TodoTasks) o;
        return getTodoTaskId() == todoTasks.getTodoTaskId() && Objects.equals(getTodoTaskName(), todoTasks.getTodoTaskName()) && Objects.equals(getTodoTaskNotes(), todoTasks.getTodoTaskNotes()) && Objects.equals(getDesiredCompletionDate(), todoTasks.getDesiredCompletionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTodoTaskId(), getTodoTaskName(), getTodoTaskNotes(), getDesiredCompletionDate());
    }
}
