package com.bridgeLabz.AdvancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileCsv {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/AdvancedProblems/large_employees.csv";
        int chunkSize = 100;
        int totalRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            String header = reader.readLine();
            System.out.println("Header: " + header);

            while ((line = reader.readLine()) != null) {
                lineCount++;
                totalRecords++;
                if (lineCount == chunkSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    lineCount = 0;
                }
            }

            if (lineCount > 0) {
                System.out.println("Processed " + totalRecords + " records total.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
