package com.bridgeLabz.AdvancedProblems;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class MergeCsv {
    public static void main(String[] args) {
        String filepath1 = "src/main/java/com/bridgeLabz/AdvancedProblems/student1.csv";
        String filepath2 = "src/main/java/com/bridgeLabz/AdvancedProblems/student2.csv";
        String filepath3 = "src/main/java/com/bridgeLabz/AdvancedProblems/MergedStudent.csv";
        HashMap<String,String[]> map = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath1));
            BufferedReader br1 = new BufferedReader(new FileReader(filepath2));
            BufferedWriter br2 = new BufferedWriter(new FileWriter(filepath3))){
            String line = br.readLine();
            while((line= br.readLine())!= null){
                String[] data = line.split(",");
                String ID = data[0].trim();
                String Name = data[1].trim();
                String Age = data[2].trim();
                map.put(ID,new String[]{Name,Age,"",""});
            }
            String line1 = br.readLine();
            while((line1= br1.readLine())!= null){
                String[] data = line1.split(",");
                String ID = data[0].trim();
                String Marks = data[1].trim();
                String Grade = data[2].trim();
                if(map.containsKey(ID)){
                    map.get(ID)[2] = Marks;
                    map.get(ID)[3] = Grade;
                }
            }
            br2.write("ID,Name,Age,Marks,Grade");
            br2.newLine();
            for(String id : map.keySet()){
                String[] data = map.get(id);
                br2.write(id+","+data[0]+","+data[1]+","+data[2]+","+data[3]);
                br2.newLine();
            }
            System.out.println("file merged");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
