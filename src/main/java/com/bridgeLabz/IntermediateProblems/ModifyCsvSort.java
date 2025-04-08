package com.bridgeLabz.IntermediateProblems;

import java.io.*;
import java.util.*;

public class ModifyCsvSort {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/IntermediateProblems/Employee.csv";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // read header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(data);
            }

            // Sort by Salary in descending order
            employees.sort((a, b) -> {
                double sal1 = Double.parseDouble(a[3].trim());
                double sal2 = Double.parseDouble(b[3].trim());
                return Double.compare(sal2, sal1); // descending
            });

            // Print Top 5
            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(Arrays.toString(employees.get(i)));
            }

            // Overwrite file with sorted content (including header)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write("ID,Name,Department,Salary");
                bw.newLine();
                for (String[] emp : employees) {
                    bw.write(String.join(",", emp));
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

