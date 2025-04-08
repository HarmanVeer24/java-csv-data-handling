package com.bridgeLabz.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecord {
    public static void main(String[] args) {
        String filepath = "src/main/java/com/bridgeLabz/IntermediateProblems/FilterData.csv";
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            boolean flag = true;
            while((line=br.readLine())!= null){
               if(flag){
                   flag = false;
                   continue;
               }
               String[] data  = line.split(",");
               int marks = Integer.parseInt(data[3].trim());
               if(marks>80){
                   int id = Integer.parseInt(data[0].trim());
                   String name = data[1].trim();
                   String Subject = data[2].trim();
                   System.out.println("Details");
                   System.out.println("ID : "+id);
                   System.out.println("Name : "+name);
                   System.out.println("Subject : "+Subject);
                   System.out.println("Marks : "+marks);

               }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
