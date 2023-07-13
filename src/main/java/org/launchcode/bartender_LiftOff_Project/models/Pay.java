package org.launchcode.bartender_LiftOff_Project.models;


import java.util.Date;

public class Pay {

    private int id;
    private static int nextId = 1;

    private Date dateWorked;
    private double totalPay;

    public Pay(Date dateWorked, double totalPay) {
        this.dateWorked = dateWorked;
        this.totalPay = totalPay;
        this.id = nextId;
        nextId++;
    }

    public Date getDateWorked() {
        return dateWorked;
    }

    public void setDateWorked(Date dateWorked) {
        this.dateWorked = dateWorked;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "On" + dateWorked +
                ", you earned $" + totalPay +
                ".";
    }
    //TODO: Add Equals and HashCode overrides
}

