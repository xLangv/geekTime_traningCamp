package com.example.week05_spring.teacherDemo.spring02;

import com.example.week05_spring.teacherDemo.spring01.Student;
import lombok.Data;

import java.util.List;

@Data
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
