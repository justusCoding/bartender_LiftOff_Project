package org.launchcode.bartender_LiftOff_Project.models;

public enum TaskType {

    CLEANING("Cleaning"),
    STOCKING("Stocking"),
    ROTATING("Rotating"),
    ORDERING("Ordering"),
    MISCELLANEOUS("Miscellaneous");

    private final String displayName;

    TaskType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
