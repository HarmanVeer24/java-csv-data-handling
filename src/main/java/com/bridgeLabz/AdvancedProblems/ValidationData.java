package com.bridgeLabz.AdvancedProblems;
import java.io.*;
import java.util.regex.*;

public class ValidationData {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/AdvancedProblems/StudentData.csv";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        String phoneRegex = "^\\d{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            String line;
            int rowNum = 1;

            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Row " + rowNum + " is malformed: " + line);
                    continue;
                }

                String id = data[0].trim();
                String name = data[1].trim();
                String email = data[2].trim();
                String phone = data[3].trim();

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email at Row " + rowNum + ": " + email);
                    valid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone Number at Row " + rowNum + ": " + phone);
                    valid = false;
                }

                if (valid) {
                    System.out.println("Row " + rowNum + " is valid: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

