package com.bridgeLabz.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/bridgeLabz/basicProblems/Output.csv";
        String line;
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            boolean flag = true;
            while((line=br.readLine())!= null){
                if(flag){
                    flag = false;
                    continue;
                }
                count++;
            }
            System.out.println("No of Rows are : "+count);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
