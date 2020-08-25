package dev.codescreen.calculator;

import dev.codescreen.entity.TaxDetails;
import dev.codescreen.entity.TaxRules;
import dev.codescreen.entity.TaxSlab;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IncomeTaxCalculatorTest {
    @Test
    public void calculate1() {
        // should correctly calculate income tax for given tax details and tax rules(no age exemption)
        try {
            TaxDetails td = new TaxDetails();
            td.setYear(2019);
            td.setAge(25);
            td.setIncome(825000);
            td.setInvestment(75000);

            TaxRules tr = new TaxRules(2019);
            tr.setInvestmentLimit(150000);
            tr.setCessLimit(500000);
            tr.setCessPercent(2);
            tr.setAgeLimit(60);
            tr.setAgeExemptionAmt(50000);

            List<TaxSlab> slabs = new ArrayList<>();
            TaxSlab slab1 = new TaxSlab();
            slab1.setPercent(0);
            slab1.setLowerLimit(0);
            slab1.setUpperLimit(100000);
            slabs.add(slab1);

            TaxSlab slab2 = new TaxSlab();
            slab2.setPercent(10);
            slab2.setLowerLimit(100000);
            slab2.setUpperLimit(600000);
            slabs.add(slab2);

            TaxSlab slab3 = new TaxSlab();
            slab3.setPercent(20);
            slab3.setLowerLimit(600000);
            slab3.setUpperLimit(1200000);
            slabs.add(slab3);

            TaxSlab slab4 = new TaxSlab();
            slab4.setPercent(30);
            slab4.setLowerLimit(1200000);
            slab4.setUpperLimit(Double.MAX_VALUE);
            slabs.add(slab4);
            tr.setSlabs(slabs);

            IncomeTaxCalculator calculator = new IncomeTaxCalculator();
            String actual = calculator.calculate(td, tr);

            String expected = "80000.0,0.0,80000.0";

            assertEquals(expected, actual);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void calculate2() {
        // should correctly calculate income tax for given tax details and tax rules(with age exemption)
        try {
            TaxDetails td = new TaxDetails();
            td.setYear(2020);
            td.setAge(65);
            td.setIncome(3800000);
            td.setInvestment(100000);

            TaxRules tr = new TaxRules(2020);
            tr.setInvestmentLimit(200000);
            tr.setCessLimit(500000);
            tr.setCessPercent(5);
            tr.setAgeLimit(60);
            tr.setAgeExemptionAmt(75000);

            List<TaxSlab> slabs = new ArrayList<>();
            TaxSlab slab1 = new TaxSlab();
            slab1.setPercent(0);
            slab1.setLowerLimit(0);
            slab1.setUpperLimit(100000);
            slabs.add(slab1);

            TaxSlab slab2 = new TaxSlab();
            slab2.setPercent(15);
            slab2.setLowerLimit(100000);
            slab2.setUpperLimit(1000000);
            slabs.add(slab2);

            TaxSlab slab3 = new TaxSlab();
            slab3.setPercent(25);
            slab3.setLowerLimit(1000000);
            slab3.setUpperLimit(Double.MAX_VALUE);
            slabs.add(slab3);
            tr.setSlabs(slabs);

            IncomeTaxCalculator calculator = new IncomeTaxCalculator();
            String actual = calculator.calculate(td, tr);

            String expected = "791250.0,39562.5,830812.5";

            assertEquals(expected, actual);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}