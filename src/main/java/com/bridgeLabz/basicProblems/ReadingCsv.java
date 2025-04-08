package com.bridgeLabz.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingCsv {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/bridgeLabz/basicProblems/Data.csv";
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            boolean isHeader = true;
            while((line = br.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String [] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                String HomeTown = data[3].trim();
                System.out.println("Details");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Age : "+age);
                System.out.println("HomeTown : "+HomeTown);
            }

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
