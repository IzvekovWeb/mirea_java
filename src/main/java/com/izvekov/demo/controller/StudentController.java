package com.izvekov.demo.controller;

import com.izvekov.demo.dao.StudentJdbc;
import com.izvekov.demo.model.Mark;
import com.izvekov.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc) {
        this.studentJdbc = studentJdbc;
    }

//    {"id":3,  "surname":"Petrov","name":"Alexander","second_name":"Ivanovich", "study_group_id": 2}
    @PostMapping("/student")
    int newStudent(@RequestBody Student newStudent) {
        try{
            return studentJdbc.UpdateStudent(newStudent);
        }
        catch (Exception e){
            return -1;
        }
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentJdbc.get(id);
    }

    @GetMapping("/student/group/{student_group_id}")
    public List<Student> getStudentByGroup(@PathVariable int student_group_id){
        return studentJdbc.getStudentByGroup(student_group_id);
    }

    @GetMapping("/student/all")
    public List<Student> getStudentByGroup(){
        return studentJdbc.getAll();
    }
}
