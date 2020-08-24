package dev.codescreen.entity;

public class TaxSlab {
    private double lowerLimit;

    private double upperLimit;

    private double percent;

    public double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "TaxSlab{" +
                "lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                ", percent=" + percent +
                '}';
    }
}
