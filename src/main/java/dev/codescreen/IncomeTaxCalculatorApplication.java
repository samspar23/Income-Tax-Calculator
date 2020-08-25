package dev.codescreen;

import dev.codescreen.calculator.IncomeTaxCalculator;
import dev.codescreen.entity.TaxDetails;
import dev.codescreen.entity.TaxRules;
import dev.codescreen.input.InputReader;
import dev.codescreen.rules.TaxRulesLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the main controller for the income tax calculator application.
 * Accepts input from the command line or a file provided by the user.
 * Validates the input and loads the tax calculation rules for the given year.
 * Calculates the income tax and displays the output on the command line.
 */
public class IncomeTaxCalculatorApplication {
	public static void main(String[] args) throws Exception {
		InputReader inputReader = new InputReader();
		List<List<String>> inputParams = new ArrayList<>();

		if (args.length > 0) {
			List<String> record = inputReader.getRecordFromArguments(args);
			inputParams.add(record);
		}
		else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter path of the file containing data for income tax calculation : ");
			String fileName = sc.next();
			inputParams = inputReader.readFile(fileName);
			sc.close();
		}

		TaxRulesLoader rulesLoader = new TaxRulesLoader();
		IncomeTaxCalculator calculator = new IncomeTaxCalculator();

		for (List<String> record : inputParams) {
			TaxDetails td = inputReader.getObjectFromRecord(record);
			if (td == null) {
				continue;
			}
			TaxRules tr = rulesLoader.getTaxRulesForYear(td.getYear());
			String output = calculator.calculate(td, tr);
			System.out.println(output);
		}
  	}
}
