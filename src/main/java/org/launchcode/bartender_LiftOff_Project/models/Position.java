package org.launchcode.bartender_LiftOff_Project.models;

public enum Position {
    GENERAL_MANAGER("General Manager"),
    ASSISTANT_MANAGER("Assistant Manager"),
    BARTENDER("Bartender"),
    SERVER("Server"),
    BAR_BACK("Bar Back"),
    COOK("Cook");

    private final String positionDisplayName;

    Position(String positionDisplayName) {
        this.positionDisplayName = positionDisplayName;
    }

    public String getPositionDisplayName() {
        return positionDisplayName;
    }

}
