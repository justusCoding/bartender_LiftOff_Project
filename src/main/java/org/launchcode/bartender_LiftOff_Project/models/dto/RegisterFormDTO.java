package org.launchcode.bartender_LiftOff_Project.models.dto;

public class RegisterFormDTO extends LoginFormDTO {
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword=verifyPassword;
    }

}
