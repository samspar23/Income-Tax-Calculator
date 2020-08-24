package dev.codescreen.entity;

public class TaxDetails {
    private int year;

    private int age;

    private double income;

    private double investment;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    @Override
    public String toString() {
        return "TaxDetails{" +
                "year=" + year +
                ", age=" + age +
                ", income=" + income +
                ", investment=" + investment +
                '}';
    }
}
