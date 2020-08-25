package dev.codescreen.input;

import dev.codescreen.constants.AppConstants;
import dev.codescreen.entity.TaxDetails;
import dev.codescreen.exceptions.InsufficientParametersException;
import dev.codescreen.exceptions.InvalidAgeException;
import dev.codescreen.exceptions.InvalidYearException;
import dev.codescreen.exceptions.NegativeValueException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    public InputReader() {}

    /**
     * Reads the input file and creates a list of records.
     *
     * @param  fileName path of the input file provided
     * @return list of records
     */
    public List<List<String>> readFile(String fileName) throws IOException {
        List<List<String>> inputParams = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(AppConstants.DELIMITER);
                inputParams.add(Arrays.stream(arr).collect(Collectors.toList()));
            }
        }
        return inputParams;
    }

    /**
     * Validates csv record and creates TaxDetails entity.
     *
     * @param  record list containing parameters for tax calculation
     * @return TaxDetails entity
     * @throws InsufficientParametersException
     */
    public TaxDetails getObjectFromRecord(List<String> record) {
        try {
            if (record == null || record.size() < AppConstants.REQ_NUM_OF_PARAMS) {
                throw new InsufficientParametersException(AppConstants.INSUFFICIENT_PARAMETERS_MESSAGE);
            }

            TaxDetails td = new TaxDetails();
            int year = Integer.parseInt(record.get(0).trim());
            if (!AppConstants.VALID_YEARS.contains(year)) {
                throw new InvalidYearException(AppConstants.INVALID_YEAR_MESSAGE);
            }
            td.setYear(year);

            int age = Integer.parseInt(record.get(1).trim());
            if (age < AppConstants.MIN_AGE_FOR_FILING_IT) {
                throw new InvalidAgeException(AppConstants.INVALID_AGE_MESSAGE);
            }
            td.setAge(age);

            double income = Double.parseDouble(record.get(2).trim());
            if (income < 0) {
                throw new NegativeValueException(AppConstants.NEGATIVE_VALUE_MESSAGE + "income.");
            }
            td.setIncome(income);

            double investment = Double.parseDouble(record.get(3).trim());
            if (investment < 0) {
                throw new NegativeValueException(AppConstants.NEGATIVE_VALUE_MESSAGE + "investment.");
            }
            td.setInvestment(investment);

            return td;
        }
        catch (InsufficientParametersException | InvalidYearException | InvalidAgeException | NegativeValueException e) {
            System.out.println(e.getMessage());
            return null;
        }
        catch (NumberFormatException nfe) {
            System.out.println(AppConstants.INCORRECT_FORMAT_MESSAGE);
            return null;
        }
    }

    /**
     * Creates a record from the command line arguments passed while running the program.
     *
     * @param args array of arguments passed to the program
     * @return list of parameters for tax calculation
     */
    public List<String> getRecordFromArguments(String[] args) {
        try {
            if (args == null || args.length < AppConstants.REQ_NUM_OF_PARAMS) {
                throw new InsufficientParametersException(AppConstants.INSUFFICIENT_PARAMETERS_MESSAGE);
            }
            return Arrays.stream(args).map(String::trim).collect(Collectors.toList());
        }
        catch (InsufficientParametersException ipe) {
            System.out.println(ipe.getMessage());
            return new ArrayList<>();
        }
    }
}
