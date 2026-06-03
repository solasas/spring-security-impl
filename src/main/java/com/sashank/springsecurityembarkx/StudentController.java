package com.sashank.springsecurityembarkx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students=new ArrayList<>(List.of(new Student("Saurabh",22,"CS"),
            new Student("Rishabh",21,"ECE")));
    
     @GetMapping("/students")
    public List<Student> getStudents(){
            return students;
     }
     @PostMapping("/students")
    public String addStudent( @RequestBody Student student){
        students.add(student);
        return "Student added successfully";
     }
}
