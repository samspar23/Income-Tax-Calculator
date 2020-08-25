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