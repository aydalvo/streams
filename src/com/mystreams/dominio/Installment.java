package com.mystreams.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Installment {

    private int number;
    private LocalDate dueDate;
    private double installmentPrice;
    private String paid;

    public Installment(int number, LocalDate dueDate, double installmentPrice, String paid) {
        this.number = number;
        this.dueDate = dueDate;
        this.installmentPrice = installmentPrice;
        this.paid = paid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(double installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "number=" + number +
                ", dueDate=" + dueDate +
                ", installmentPrice=" + installmentPrice +
                ", pending=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Installment that = (Installment) o;
        return number == that.number && Double.compare(that.installmentPrice, installmentPrice) == 0 && dueDate.equals(that.dueDate) && paid.equals(that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, dueDate, installmentPrice, paid);
    }
}
