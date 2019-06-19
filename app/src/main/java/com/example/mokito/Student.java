package com.example.mokito;

public class Student {
    private String Student_Name="";

    public Student(String student_Name) {
        Student_Name = student_Name;
    }

    public void save(String S){
        Student_Name=S;
    }
}
