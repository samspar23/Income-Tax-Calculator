package dev.codescreen.input;

import dev.codescreen.entity.TaxDetails;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputReaderTest {
    @Test
    public void readFile() {
        // should read file at the provided path and create a list of records
        try {
            File file = new File("src/test/resources/tax.txt");
            InputReader inputReader = new InputReader();
            List<List<String>> result = inputReader.readFile(file.getAbsolutePath());

            List<List<String>> expectedParams = new ArrayList<>();
            expectedParams.add(Arrays.asList("2020", "65", "3800000", "100000"));
            expectedParams.add(Arrays.asList("2019", "25", "825000", "75000"));

            assertEquals(expectedParams, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord1() {
        // should return null if less parameters are passed
        try {
            List<String> record = new ArrayList<>();
            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord2() {
        // should return null if invalid year is passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2017");
            record.add("25");
            record.add("1000000");
            record.add("100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord3() {
        // should return null if incorrectly formatted data is passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2019");
            record.add("25");
            record.add("$1000000");
            record.add("100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord4() {
        // should return null if invalid age is passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2019");
            record.add("15");
            record.add("1000000");
            record.add("100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord5() {
        // should return null if -ve value for income is passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2019");
            record.add("25");
            record.add("-1000000");
            record.add("100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord6() {
        // should return null if -ve value for investment is passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2019");
            record.add("25");
            record.add("1000000");
            record.add("-100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(null, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getObjectFromRecord7() {
        // should return TaxDetails object if correct parameters are passed
        try {
            List<String> record = new ArrayList<>();
            record.add("2019");
            record.add("25");
            record.add("1000000");
            record.add("100000");

            InputReader inputReader = new InputReader();
            TaxDetails result = inputReader.getObjectFromRecord(record);
            assertEquals(2019, result.getYear());
            assertEquals(25, result.getAge());
            assertEquals(1000000.0, result.getIncome(), 0);
            assertEquals(100000.0, result.getInvestment(), 0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getRecordFromArguments1() {
        // should return an empty list if less parameters are passed
        try {
            String[] args = { "2019", "35" };
            InputReader inputReader = new InputReader();
            List<String> result = inputReader.getRecordFromArguments(args);
            assertTrue(result.isEmpty());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getRecordFromArguments2() {
        // should return a list of same size as number of arguments passed
        try {
            String[] args = {"2019", "35", "1000000", "100000"};
            List<String> expected = Arrays.asList(args);
            InputReader inputReader = new InputReader();
            List<String> result = inputReader.getRecordFromArguments(args);
            assertEquals(expected, result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}