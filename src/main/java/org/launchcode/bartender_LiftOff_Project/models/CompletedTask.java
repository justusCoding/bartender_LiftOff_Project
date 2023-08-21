package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class CompletedTask {
    @Id
    @GeneratedValue
    private int completedTaskId;
    @NotBlank(message = "Name is required.")
    @Size(min = 0, max = 20, message = "Task must be 20 characters or less")
    private String completedTaskName;
    @Size(min = 0, max = 100, message = "Notes must be 100 characters or less.")
    private String completedTaskNotes;
    private String dateCompleted;
    private TaskType completedTaskType;
    private Employees employeeCompletedBy;

    public CompletedTask() {
    }

    public CompletedTask(String completedTaskName, String completedTaskDescription, String dateCompleted, TaskType completedTaskType, Employees employeeCompletedBy) {
        this.completedTaskName = completedTaskName;
        this.completedTaskNotes = completedTaskDescription;
        this.dateCompleted = dateCompleted;
        this.completedTaskType = completedTaskType;
        this.employeeCompletedBy = employeeCompletedBy;
    }

    public int getCompletedTaskId() {
        return completedTaskId;
    }

    public void setCompletedTaskId(int completedTaskId) {
        this.completedTaskId = completedTaskId;
    }

    public String getCompletedTaskName() {
        return completedTaskName;
    }

    public void setCompletedTaskName(String completedTaskName) {
        this.completedTaskName = completedTaskName;
    }

    public String getCompletedTaskNotes() {
        return completedTaskNotes;
    }

    public void setCompletedTaskNotes(String completedTaskNotes) {
        this.completedTaskNotes = completedTaskNotes;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public TaskType getCompletedTaskType() {
        return completedTaskType;
    }

    public void setCompletedTaskType(TaskType completedTaskType) {
        this.completedTaskType = completedTaskType;
    }

    public Employees getEmployeesListVariable() {
        return employeeCompletedBy;
    }

    public void setEmployeesListVariable(Employees employeeCompletedBy) {
        this.employeeCompletedBy = employeeCompletedBy;
    }

    @Override
    public String toString() {
        return "CompletedTask{" +
                "completedTaskId=" + completedTaskId +
                ", completedTaskName='" + completedTaskName + '\'' +
                ", completedTaskNotes='" + completedTaskNotes + '\'' +
                ", dateCompleted='" + dateCompleted + '\'' +
                ", completedTaskType=" + completedTaskType +
                ", employeeCompletedBy=" + employeeCompletedBy +
                '}';
    }

    public Employees getEmployeeCompletedBy() {
        return employeeCompletedBy;
    }

    public void setEmployeeCompletedBy(Employees employeeCompletedBy) {
        this.employeeCompletedBy = employeeCompletedBy;
    }
}
