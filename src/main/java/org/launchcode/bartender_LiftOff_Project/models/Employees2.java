package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Employees2 {

    @Id
    @GeneratedValue
    private int employeeId;

    @NotBlank(message = "First name is required.")
    @Size(min = 0, max = 50, message = "First name must be 50 characters or less.")
    private String employeeFirstName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 0, max = 50, message = "Last name must be 50 characters or less.")
    private String employeeLastName;

    private Position position;

    private String dateOfBirth;

    public Employees2() {

    }

    public Employees2(int employeeId, String employeeFirstName, String employeeLastName, Position position, String dateOfBirth) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employees2{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", position=" + position +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees2)) return false;
        Employees2 that = (Employees2) o;
        return getEmployeeId() == that.getEmployeeId() && Objects.equals(getEmployeeFirstName(), that.getEmployeeFirstName()) && Objects.equals(getEmployeeLastName(), that.getEmployeeLastName()) && getPosition() == that.getPosition() && Objects.equals(getDateOfBirth(), that.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getEmployeeFirstName(), getEmployeeLastName(), getPosition(), getDateOfBirth());
    }
}
