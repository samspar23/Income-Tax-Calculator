package dev.codescreen.rules;

import dev.codescreen.constants.AppConstants;
import dev.codescreen.entity.TaxRules;
import dev.codescreen.entity.TaxSlab;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaxRulesLoader {
    public TaxRulesLoader() {}

    /**
     * Loads tax calculation rules from config json file for a year and creates rules entity.
     *
     * @param year the year for which tax rules are required
     * @return TaxRules entity
     * @throws IOException
     * @throws ParseException
     */
    public TaxRules getTaxRulesForYear(int year) throws IOException, ParseException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(year + ".json");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new InputStreamReader(is, AppConstants.ENCODING));

        TaxRules tr = new TaxRules(year);
        if (json.containsKey("investmentLimit")) {
            tr.setInvestmentLimit((long) json.get("investmentLimit"));
        }
        if (json.containsKey("cessLimit")) {
            tr.setCessLimit((long) json.get("cessLimit"));
        }
        if (json.containsKey("cessPercent")) {
            tr.setCessPercent((long) json.get("cessPercent"));
        }
        if (json.containsKey("ageLimit")) {
            long ageLimit = (long) json.get("ageLimit");
            tr.setAgeLimit((int) ageLimit);
        }
        if (json.containsKey("ageExemptionAmt")) {
            tr.setAgeExemptionAmt((long) json.get("ageExemptionAmt"));
        }
        if (json.containsKey("slabs")) {
            List<TaxSlab> slabs = new ArrayList<>();
            JSONArray slabsArr = (JSONArray) json.get("slabs");
            for (Object obj : slabsArr) {
                JSONObject slab = (JSONObject) obj;
                TaxSlab ts = new TaxSlab();
                ts.setLowerLimit((long) slab.get("min"));
                ts.setUpperLimit(slab.containsKey("max") ? (long) slab.get("max") : Double.MAX_VALUE);
                ts.setPercent((long) slab.get("percent"));
                slabs.add(ts);
            }
            tr.setSlabs(slabs);
        }
        return tr;
    }
}
