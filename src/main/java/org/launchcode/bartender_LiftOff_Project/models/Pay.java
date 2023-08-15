package org.launchcode.bartender_LiftOff_Project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Pay {

            @Id
            @GeneratedValue
            private int id;

            @NotNull(message = "Date is a required field")
            private String dateWorked;

            @NotNull(message = "Hours worked is a required field")
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "24")
            private Double hoursWorked;

            @NotNull(message = "Shift worked is a required field")
            private String shiftWorked;

            @NotNull(message = "Hourly rate is a required field")
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private Double hourlyRate;

            @NotNull(message = "Credit card tips is a required field")
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private Double creditCardTips;

            @NotNull(message = "Cash tips is a required field")
            @DecimalMin(value = "0.25")
            @DecimalMax(value = "1000000")
            private Double cashTips;

            @NotNull(message = "Tax rate is a required field")
            @DecimalMin(value = "0")
            @DecimalMax(value= "100")
            private Double taxRate;

//            TODO: Make taxRate an enum?

            private Double totalPay;

            public Pay(String dateWorked, Double hoursWorked, String shiftWorked,
                       Double hourlyRate, Double creditCardTips, Double cashTips, Double taxRate) {
                this.dateWorked = dateWorked;
                this.hoursWorked = hoursWorked;
                this.shiftWorked = shiftWorked;
                this.hourlyRate = hourlyRate;
                this.creditCardTips = creditCardTips;
                this.cashTips = cashTips;
                this.taxRate = taxRate;
                Double calculatedTotalPay = ((hourlyRate * hoursWorked) + creditCardTips + cashTips) * (1 - (taxRate / 100));
                this.totalPay = Math.round(calculatedTotalPay * 100.0) / 100.0;
            }

            public Pay() {}

    public String getDateWorked() {
                return dateWorked;
            }

            public void setDateWorked(String dateWorked) {
                this.dateWorked = dateWorked;
            }

            public Double getTotalPay() {
                return totalPay;
            }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public int getId() {
                return id;
            }

            public Double getHoursWorked() {
                return hoursWorked;
            }

            public void setHoursWorked(Double hoursWorked) {
                this.hoursWorked = hoursWorked;
            }

            public String getShiftWorked() {
                return shiftWorked;
            }

            public void setShiftWorked(String shiftWorked) {
                this.shiftWorked = shiftWorked;
            }

            public Double getHourlyRate() {
                return hourlyRate;
            }

            public void setHourlyRate(Double hourlyRate) {
                this.hourlyRate = hourlyRate;
            }

            public Double getCreditCardTips() {
                return creditCardTips;
            }

            public void setCreditCardTips(Double creditCardTips) {
                this.creditCardTips = creditCardTips;
            }

            public Double getCashTips() {
                return cashTips;
            }

            public void setCashTips(Double cashTips) {
                this.cashTips = cashTips;
            }

            public Double getTaxRate() {
                return taxRate;
            }

            public void setTaxRate(Double taxRate) {
                this.taxRate = taxRate;
            }

            @Override
            public String toString() {
                return "On " + dateWorked +
                        ", you earned $" + totalPay +
                        ".";
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pay pay = (Pay) o;
                return id == pay.id;
            }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


