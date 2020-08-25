package dev.codescreen.rules;

import dev.codescreen.entity.TaxRules;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxRulesLoaderTest {
    @Test
    public void getTaxRulesForYear() {
        try {
            TaxRulesLoader rulesLoader = new TaxRulesLoader();
            TaxRules tr = rulesLoader.getTaxRulesForYear(2019);
            assertEquals(2019, tr.getYear());
            assertEquals(4, tr.getSlabs().size());
            assertEquals(150000, tr.getInvestmentLimit(), 0);
            assertEquals(500000, tr.getCessLimit(), 0);
            assertEquals(2, tr.getCessPercent(), 0);
            assertEquals(60, tr.getAgeLimit());
            assertEquals(50000, tr.getAgeExemptionAmt(), 0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}