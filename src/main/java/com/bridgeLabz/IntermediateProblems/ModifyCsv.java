package com.bridgeLabz.IntermediateProblems;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCsv {
    public static void main(String[] args) {
        String FilePath = "src/main/java/com/bridgeLabz/IntermediateProblems/Employee.csv";
        String outputFilePath ="src/main/java/com/bridgeLabz/IntermediateProblems/UpdatedEmployee.csv";
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(FilePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))){
            boolean flag = true;
            while ((line=br.readLine())!=null){
                if(flag){
                    flag = false;
                    continue;
                }
                String[] data = line.split(",");
                int ID = Integer.parseInt(data[0].trim());
                String Name = data[1].trim();
                String department = data[2].trim();
                Double Salary = Double.parseDouble(data[3].trim());
                if(department.equals("IT")){
                    Salary = Salary*1.10;
                }
                String updatedLine = ID + "," + Name + "," + department + "," + String.format("%.2f", Salary);
                bw.write(updatedLine);
                bw.newLine();
                System.out.println("ID "+ ID);
                System.out.println("Name "+ Name);
                System.out.println("Department "+ department);
                System.out.println("Salary "+ Salary);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
