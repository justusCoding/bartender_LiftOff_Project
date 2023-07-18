package org.launchcode.bartender_LiftOff_Project.models;

        public class Pay {

            private final int id;
            private int nextId = 1;

            private String dateWorked;
            private double hoursWorked;
            private String shiftWorked;
            private double hourlyRate;
            private double creditCardTips;
            private double cashTips;
            private double taxRate;
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


