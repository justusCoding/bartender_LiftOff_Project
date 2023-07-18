package org.launchcode.bartender_LiftOff_Project.models;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Pay {

            private final int id;
            private int nextId = 1;

            @NotBlank
            private String dateWorked;

            @NotBlank
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "24")
            private double hoursWorked;

            @NotBlank
            private String shiftWorked;

            @NotBlank
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private double hourlyRate;

            @NotBlank
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private double creditCardTips;

            @NotBlank
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private double cashTips;

            @NotBlank
            @Size(min = 0, max = 100)
            private double taxRate;
//            TODO: Make taxRate an enum?

            private double totalPay;

            public Pay(String dateWorked, double hoursWorked, String shiftWorked,
                       double hourlyRate, double creditCardTips, double cashTips, double taxRate) {
                this.id = nextId;
                nextId++;
                this.dateWorked = dateWorked;
                this.hoursWorked = hoursWorked;
                this.shiftWorked = shiftWorked;
                this.hourlyRate = hourlyRate;
                this.creditCardTips = creditCardTips;
                this.cashTips = cashTips;
                this.taxRate = taxRate;
                this.totalPay = ((hourlyRate * hoursWorked) + creditCardTips + cashTips) * (100 - taxRate);
            }

            public String getDateWorked() {
                return dateWorked;
            }

            public void setDateWorked(String dateWorked) {
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

            public double getHoursWorked() {
                return hoursWorked;
            }

            public void setHoursWorked(double hoursWorked) {
                this.hoursWorked = hoursWorked;
            }

            public String getShiftWorked() {
                return shiftWorked;
            }

            public void setShiftWorked(String shiftWorked) {
                this.shiftWorked = shiftWorked;
            }

            public double getHourlyRate() {
                return hourlyRate;
            }

            public void setHourlyRate(double hourlyRate) {
                this.hourlyRate = hourlyRate;
            }

            public double getCreditCardTips() {
                return creditCardTips;
            }

            public void setCreditCardTips(double creditCardTips) {
                this.creditCardTips = creditCardTips;
            }

            public double getCashTips() {
                return cashTips;
            }

            public void setCashTips(double cashTips) {
                this.cashTips = cashTips;
            }

            public double getTaxRate() {
                return taxRate;
            }

            public void setTaxRate(double taxRate) {
                this.taxRate = taxRate;
            }

            @Override
            public String toString() {
                return "On" + dateWorked +
                        ", you earned $" + totalPay +
                        ".";
            }
            //TODO: Add Equals and HashCode overrides
        }


