package org.launchcode.bartender_LiftOff_Project.models;

public enum Employees {
    ALI("Ali"),
    AURORA("Aurora"),
    ANDREW("Andrew"),
    KATHERINE("Katherine"),
    JUSTUS("Justus"),
    AMR("Amr"),
    OTHER("Other");

    private final String displayName;
    Employees(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }

}
