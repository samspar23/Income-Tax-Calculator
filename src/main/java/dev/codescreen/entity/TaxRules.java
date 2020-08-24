package dev.codescreen.entity;

import java.util.List;
import java.util.Objects;

public class TaxRules {
    private final int year;

    private List<TaxSlab> slabs;

    private double investmentLimit;

    private double cessLimit;

    private double cessPercent;

    private int ageLimit;

    private double ageExemptionAmt;

    public TaxRules(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public List<TaxSlab> getSlabs() {
        return slabs;
    }

    public void setSlabs(List<TaxSlab> slabs) {
        this.slabs = slabs;
    }

    public double getInvestmentLimit() {
        return investmentLimit;
    }

    public void setInvestmentLimit(double investmentLimit) {
        this.investmentLimit = investmentLimit;
    }

    public double getCessLimit() {
        return cessLimit;
    }

    public void setCessLimit(double cessLimit) {
        this.cessLimit = cessLimit;
    }

    public double getCessPercent() {
        return cessPercent;
    }

    public void setCessPercent(double cessPercent) {
        this.cessPercent = cessPercent;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public double getAgeExemptionAmt() {
        return ageExemptionAmt;
    }

    public void setAgeExemptionAmt(double ageExemptionAmt) {
        this.ageExemptionAmt = ageExemptionAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRules taxRules = (TaxRules) o;
        return year == taxRules.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }

    @Override
    public String toString() {
        return "TaxRules{" +
                "year=" + year +
                '}';
    }
}
