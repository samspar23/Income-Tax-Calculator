package dev.codescreen.calculator;

import dev.codescreen.entity.TaxDetails;
import dev.codescreen.entity.TaxRules;
import dev.codescreen.entity.TaxSlab;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IncomeTaxCalculator {
    public IncomeTaxCalculator() {}

    /**
     * Calculates the total tax amount for the provided details based on the relevant rules.
     *
     * @param  td TaxDetails entity
     * @param  tr TaxRules entity
     * @return comma separated string containing income tax, cess and total tax
     */
    public String calculate(TaxDetails td, TaxRules tr) {
        double income = td.getIncome();

        double investmentExemption = Math.min(td.getInvestment(), tr.getInvestmentLimit());
        income -= investmentExemption;

        if (tr.getAgeLimit() > 0 && td.getAge() > tr.getAgeLimit()) {
            income -= tr.getAgeExemptionAmt();
        }

        double income_tax = 0d;
        for (TaxSlab slab : tr.getSlabs()) {
            if (income <= 0) {
                break;
            }

            double taxableAmtForSlab = Math.min(slab.getUpperLimit() - slab.getLowerLimit(), income);
            income_tax += (taxableAmtForSlab * slab.getPercent())/100;
            income -= taxableAmtForSlab;
        }

        double cess = 0d;
        if (income_tax > tr.getCessLimit()) {
            cess = (income_tax * tr.getCessPercent())/100;
        }

        double total_tax = income_tax + cess;

        double[] output = { income_tax, cess, total_tax };
        return Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }
}
