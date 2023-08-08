package org.launchcode.bartender_LiftOff_Project.models;

public enum Employees {
    ALI("Ali"),
    AURORA("Aurora"),
    ANDREW("Andrew"),
    KATHERINE("Katherine"),
    JUSTUS("Justus"),
    OTHER("Other");

    private final String employeeDisplayName;
    Employees(String employeeDisplayName) {
        this.employeeDisplayName = employeeDisplayName;
    }
    public String getEmployeeDisplayName() {
        return employeeDisplayName;
    }

}
