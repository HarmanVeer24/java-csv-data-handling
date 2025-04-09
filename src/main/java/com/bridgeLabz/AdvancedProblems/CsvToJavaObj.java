package com.bridgeLabz.AdvancedProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Student{
    int id;
    String name;
    String email;
    int phoneNo;
    Student(int id,String name,String email,int phoneNo){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}
public class CsvToJavaObj {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        String filepath = "src/main/java/com/bridgeLabz/AdvancedProblems/StudentData.csv";
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            boolean flag = true;
            while((line = br.readLine())!= null){
                if(flag){
                    flag = false;
                    continue;
                }
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0].trim());
                String Name = arr[1].trim();
                String Email = arr[2].trim();
                int phoneNo = (int)Long.parseLong(arr[3].trim());
//                System.out.println(phoneNo);
                Student st1 = new Student(id,Name,Email,phoneNo);
                list.add(st1);
            }
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i).id+" ");
                System.out.print(list.get(i).name+" ");
                System.out.print(list.get(i).email+" ");
                System.out.print(list.get(i).phoneNo+" ");
                System.out.println();
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
