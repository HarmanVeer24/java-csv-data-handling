package com.bridgeLabz.AdvancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateCsv {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgeLabz/AdvancedProblems/DuplicateData.csv";
        String line;
        HashMap<String,String[]> map = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            System.out.println("Duplicate Values present in Csv file are: ");
            while((line=br.readLine())!= null){
                String[] arr = line.split(",");
                String Id = arr[0].trim();
                String Name = arr[1].trim();
                String Age = arr[2].trim();
                String Marks = arr[3].trim();
                String Grade = arr[4].trim();
                if(map.containsKey(Id)){
                    System.out.print(Id+" ");
                    System.out.print(Name+" ");
                    System.out.print(Age+" ");
                    System.out.print(Marks+" ");
                    System.out.print(Grade+" ");
                    System.out.println();

                }
                else {
                    map.put(Id,new String[]{Name,Age,Marks,Grade});
                }
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
