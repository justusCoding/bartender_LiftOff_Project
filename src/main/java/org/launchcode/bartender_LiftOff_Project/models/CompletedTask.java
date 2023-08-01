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

    public Employees getEmployeeCompletedBy() {
        return employeeCompletedBy;
    }

    public void setEmployeeCompletedBy(Employees employeeCompletedBy) {
        this.employeeCompletedBy = employeeCompletedBy;
    }

    @Override
    public String toString() {
        return "Name: " + completedTaskName + '\n' +
                "Notes: " + completedTaskNotes + '\n' +
                "Date Completed: " + dateCompleted + '\n' +
                "Employee Completed By: ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompletedTask)) return false;
        CompletedTask that = (CompletedTask) o;
        return getCompletedTaskId() == that.getCompletedTaskId() && Objects.equals(getCompletedTaskName(), that.getCompletedTaskName()) && Objects.equals(getCompletedTaskNotes(), that.getCompletedTaskNotes()) && Objects.equals(getDateCompleted(), that.getDateCompleted()) && getCompletedTaskType() == that.getCompletedTaskType() && getEmployeeCompletedBy() == that.getEmployeeCompletedBy();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompletedTaskId(), getCompletedTaskName(), getCompletedTaskNotes(), getDateCompleted(), getCompletedTaskType(), getEmployeeCompletedBy());
    }
}
