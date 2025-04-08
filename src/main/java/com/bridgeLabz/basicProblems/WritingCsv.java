package com.bridgeLabz.basicProblems;

import com.opencsv.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/bridgeLabz/basicProblems/Output.csv";
        try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath))){
            br.write("ID,Name,Department,Salary\n");
            br.write("1,Harman,Devolpment,40000\n");
            br.write("2,Aaryan,Testing,50000\n");
            br.write("3,Dhruv,Sales,50000\n");
            br.write("4,Divyam,Management,60000\n");
            br.write("5,Ravi,AppDev,90000\n");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
