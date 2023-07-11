package org.launchcode.bartender_LiftOff_Project.models;


public class TipsCalculator {


    private double hoursWorked;
    private double hourlyRate;
    private double creditCardTips;
    private double cashTips;
    private double taxRate;


    public TipsCalculator(double hoursWorked, double hourlyRate, double creditCardTips,
                          double cashTips, double taxRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.creditCardTips = creditCardTips;
        this.cashTips = cashTips;
        this.taxRate = taxRate;
    }


    public double getTotalTipsClaimed(double hoursWorked, double hourlyRate,
                                      double creditCardTips, double cashTips) {
        return (hoursWorked * hourlyRate) + creditCardTips + cashTips;
    }


    public double getTotalNetPay (double taxRate, double hoursWorked) {
        return ((hoursWorked * hourlyRate) + creditCardTips + cashTips) - (taxRate * hoursWorked);
    }


}

