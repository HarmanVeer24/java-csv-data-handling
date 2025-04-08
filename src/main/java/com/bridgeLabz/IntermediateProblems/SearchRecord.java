package com.bridgeLabz.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter the Username: ");
        String name = sc.nextLine();
        String filepath = "src/main/java/com/bridgeLabz/IntermediateProblems/Employee.csv";
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            boolean flag = true;
            while((line=br.readLine())!= null){
                if(flag){
                    flag = false;
                    continue;
                }
                String[] data  = line.split(",");
                String UName = data[1].trim();
                if(UName.equals(name)){
                    int Salary = Integer.parseInt(data[3].trim());
                    String Department = data[2].trim();
                    System.out.println("Details");
                    System.out.println("Name : "+name);
                    System.out.println("Department : "+Department);
                    System.out.println("Salary : "+Salary);
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            // if the entered uName is not present in csv file
            System.out.println("NO such user found");
        }
    }
}
