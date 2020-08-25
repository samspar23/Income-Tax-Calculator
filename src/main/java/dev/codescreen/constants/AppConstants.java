package dev.codescreen.constants;

import java.util.HashSet;
import java.util.Set;

public class AppConstants {
    public static final String DELIMITER = ",";

    public static final String ENCODING = "UTF-8";

    public static final int REQ_NUM_OF_PARAMS = 4;

    public static final int MIN_AGE_FOR_FILING_IT = 18;

    public static final String INVALID_YEAR_MESSAGE = "Please enter a valid year for tax calculation.";
    public static final String INCORRECT_FORMAT_MESSAGE = "Please enter data in the correct format.";
    public static final String INSUFFICIENT_PARAMETERS_MESSAGE = "Please provide all parameters for tax calculation.";
    public static final String INVALID_AGE_MESSAGE = "Please enter a valid value for age.";
    public static final String NEGATIVE_VALUE_MESSAGE = "Please enter a positive value for ";

    private static final int[] years = { 2018, 2019, 2020 };
    public static final Set<Integer> VALID_YEARS = new HashSet<>();

    static {
        for (int yr : years) {
            VALID_YEARS.add(yr);
        }
    }
}
